package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {

	private Connection conn;

	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePorId(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendedor encontrarPorId(Integer id) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " 
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id " 
					+ "WHERE seller.Id = ?");

			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Departamento departamento = instanciandoDepartamento(resultSet);

				Vendedor vendedor = instanciandoVendedor(resultSet, departamento);
				return vendedor;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(resultSet);
			DB.closeStatement(statement);
		}
	}

	private Vendedor instanciandoVendedor(ResultSet resultSet, Departamento departamento) throws SQLException {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(resultSet.getInt("Id"));
		vendedor.setNome(resultSet.getString("Name"));
		vendedor.setEmail(resultSet.getString("Email"));
		vendedor.setSalaroBase(resultSet.getDouble("BaseSalary"));
		vendedor.setAniversario(resultSet.getDate("BirthDate"));
		vendedor.setDepartamento(departamento);
		return vendedor;
	}

	private Departamento instanciandoDepartamento(ResultSet resultSet) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setId(resultSet.getInt("DepartmentId"));
		departamento.setNome(resultSet.getString("DepName"));
		return departamento;
	}

	@Override
	public List<Vendedor> encontrarTudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendedor> encontrarPorDepartamento(Departamento departamento) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conn.prepareStatement(
					"SELECT \r\n"
					+ "	seller.*,\r\n"
					+ "    department.Name as DepName\r\n"
					+ "FROM \r\n"
					+ "	seller \r\n"
					+ "    INNER JOIN department ON seller.DepartmentId = department.Id\r\n"
					+ "WHERE \r\n"
					+ "	department.Id = ?\r\n"
					+ "ORDER BY \r\n"
					+ "	Name");

			statement.setInt(1, departamento.getId());
			resultSet = statement.executeQuery();
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (resultSet.next()) {

				Departamento dep = map.get(resultSet.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instanciandoDepartamento(resultSet);
					map.put(resultSet.getInt("DepartmentId"), dep);
				}
				
				Vendedor vendedor = instanciandoVendedor(resultSet, dep);
				lista.add(vendedor);	
			}
			return lista;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(resultSet);
			DB.closeStatement(statement);
		}
	}
}
