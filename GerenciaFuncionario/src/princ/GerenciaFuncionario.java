package princ;

import java.util.Scanner;

public class GerenciaFuncionario {
	public static void main(String[] args) {
		Empresa _e = new Empresa();
		Scanner scanner = new Scanner(System.in); // Como o scanner.close fecha o InputStream, outras instancias que
													// usam do System.in não vão funcionar
		Funcionario marcio = GerenciaFuncionario.lerDadosFuncionario(0, 970, scanner);
		Funcionario isabela = GerenciaFuncionario.lerDadosFuncionario(1, 2500, scanner);
		Funcionario inacio = GerenciaFuncionario.lerDadosFuncionario(2, 5000, scanner);
		Funcionario heitor = GerenciaFuncionario.lerDadosFuncionario(3, 2500, scanner);
		scanner.close();
		_e.adicionarFuncionario(marcio);
		_e.adicionarFuncionario(isabela);
		_e.adicionarFuncionario(inacio);
		_e.adicionarFuncionario(heitor);
		System.out.println(_e.gerarFolhaPagamento());

	}

	public static Funcionario lerDadosFuncionario(int id, double salarioBase, Scanner scanner) {
		Cargo[] cargos = { Cargo.DESENVOLVEDOR, Cargo.GERENTE, Cargo.SUPORTE };

		// Tipo usuário
		System.out.println("Qual é o tipo de usuário que deseja cadastrar?");
		System.out.println("1 - Desenvolvedor");
		System.out.println("2 - Gerente");
		System.out.println("3 - Suporte");
		System.out.print("Sua opção: ");
		int escolha = Integer.parseInt(scanner.nextLine());
		// nome usuário
		System.out.println("Qual é o nome do funcionário?");
		String nome = scanner.nextLine();

		Funcionario novoFuncionario;
		Cargo tipoEscolhido = cargos[escolha - 1];
		switch (tipoEscolhido) {
			case DESENVOLVEDOR:
				novoFuncionario = new Desenvolvedor(id, nome, salarioBase);
				break;
			case GERENTE:
				novoFuncionario = new Gerente(id, nome, salarioBase);
				break;
			case SUPORTE:
				novoFuncionario = new Suporte(id, nome, salarioBase);
				break;
			default:
				throw new Error("Defina um valor");
		}
		novoFuncionario.calcularSalario();
		return novoFuncionario;
	}
}
