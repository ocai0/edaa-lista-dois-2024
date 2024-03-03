package princ;

public class Desenvolvedor extends Funcionario {

	public Desenvolvedor(int id, String nome, double salario) {
		super(nome, id, salario);
	}

	@Override
	public void calcularSalario() {
		this.setSalario(this.getSalarioBase() * 1.1);
	}

}
