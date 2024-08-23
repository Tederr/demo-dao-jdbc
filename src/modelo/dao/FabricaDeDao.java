package modelo.dao;

import db.DB;
import modelo.dao.impl.VendedorDaoJDBC;

public class FabricaDeDao {
	
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}

}
