package princ;

public class Suporte extends Funcionario {

	public Suporte(int id, String nome, double salarioBase) {
		super(nome, id, salarioBase);
	}

	@Override
	public void calcularSalario() {
		this.setSalario(this.getSalarioBase() * 1.05);
	}
}
