package modelo.dao;

import modelo.dao.impl.VendedorDaoJDBC;

public class FabricaDeDao {
	
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC();
	}

}
