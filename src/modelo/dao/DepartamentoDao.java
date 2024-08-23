package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;

public interface DepartamentoDao {
	
	void inserir(Departamento obj);
	void atualizar(Departamento obj);
	void deletePorId(Integer id);
	Departamento encontrarPorId(Integer id);
	List<Departamento> encontrarTudo (); 

}
