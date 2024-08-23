package aplicaçao;

import java.util.Date;

import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

		Departamento obj = new Departamento(1, "livros");
		Vendedor ven = new Vendedor(21, "Pedro", "Pedro@gmail.com", new Date(), 3000.0, obj);
		
		System.out.println(ven);
	}

}
