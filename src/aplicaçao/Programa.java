package aplicaçao;

import java.util.List;

import modelo.dao.FabricaDeDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = FabricaDeDao.criarVendedorDao();
		
		System.out.println("==== TESTE 1: vendedor encontrarPorId ====");	
		Vendedor ven = vendedorDao.encontrarPorId(3);
		System.out.println(ven);
		
		System.out.println("\n==== TESTE 2: vendedor encontrarPorDepartamento ====");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> vendedor = vendedorDao.encontrarPorDepartamento(departamento); 
		for(Vendedor obj : vendedor) {
			System.out.println(obj);
		}
	}

}
