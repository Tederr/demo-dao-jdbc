package aplicaçao;

import modelo.dao.FabricaDeDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = FabricaDeDao.criarVendedorDao();
		
		Vendedor ven = vendedorDao.encontrarPorId(3);
		
		System.out.println(ven);
	}

}
