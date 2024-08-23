package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public interface VendedorDao {
	void inserir(Vendedor obj);
	void atualizar(Vendedor obj);
	void deletePorId(Integer id);
	Vendedor encontrarPorId(Integer id);
	List<Vendedor> encontrarTudo (); 
	List<Vendedor> encontrarPorDepartamento(Departamento departamento);

}
