package princ;

public abstract class Funcionario {
	private String nome;
	private int id;
	private double salario;
	private double salarioBase;

	public Funcionario(String nome, int id, double salarioBase) {
		this.setNome(nome);
		this.setId(id);
		this.setSalarioBase(salarioBase);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public abstract void calcularSalario();
}
