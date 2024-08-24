package aplicaçao;

import java.util.List;
import java.util.Scanner;

import modelo.dao.DepartamentoDao;
import modelo.dao.FabricaDeDao;
import modelo.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartamentoDao departmentDao = FabricaDeDao.criarDepartamentoDao();

		System.out.println("=== TEST 1: encontrarPorId =======");
		Departamento dep = departmentDao.encontrarPorId(1);
		System.out.println(dep);

		System.out.println("\n=== TEST 2: encontrarTudo =======");
		List<Departamento> list = departmentDao.encontrarTudo();
		for (Departamento d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: inserir =======");
		Departamento newDepartment = new Departamento(null, "Music");
		departmentDao.inserir(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n=== TEST 4: atualizar =======");
		Departamento dep2 = departmentDao.encontrarPorId(1);
		dep2.setNome("Food");
		departmentDao.atualizar(dep2);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deletePorId(id);
		System.out.println("Delete completed");

		sc.close();

	}

}
