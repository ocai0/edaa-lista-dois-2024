package princ;

public class Gerente extends Funcionario {
	public Gerente(int id, String nome, double salario) {
		super(nome, id, salario);
	}

	@Override
	public void calcularSalario() {
		this.setSalario(this.getSalarioBase() * 1.2 + 1000);
	}
}
