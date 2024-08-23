package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

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
}
