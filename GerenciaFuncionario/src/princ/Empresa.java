package princ;

import java.util.ArrayList;

public class Empresa {
	private ArrayList<Funcionario> _funcionarios;

	public Empresa() {
		this._funcionarios = new ArrayList<Funcionario>();
	}

	public void adicionarFuncionario(Funcionario f) {
		this._funcionarios.add(f);
	}

	public double gerarFolhaPagamento() {
		double total = 0;
		for (Funcionario _f : this._funcionarios)
			total += _f.getSalario();
		return total;
	}
}
