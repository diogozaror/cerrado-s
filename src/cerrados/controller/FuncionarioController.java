package cerrados.controller;

import cerrados.bd.Repository;
import cerrados.model.entities.Funcionario;
import cerrados.model.entities.Setor;

public class FuncionarioController {

	private static FuncionarioController funcionarioController;

	public static FuncionarioController getFuncionarioController() {
		if (funcionarioController == null) {
			funcionarioController = new FuncionarioController();
		}
		return funcionarioController;
	}

	public Funcionario funcionario;

	public boolean hasFuncionario(int matricula) {
		for (Funcionario f : Repository.bdFuncionarios) {
			if (f.getMatricula() == matricula)
				return true;
		}

		return false;

	}

	public boolean cadastrarFuncionario(String nome, String cpf, String endereco, double salario, Setor setor) {
		if (nome != null && cpf != null && endereco != null) {
			int matricula = Repository.bdFuncionarios.size();
			if (!hasFuncionario(matricula)) {
				Funcionario func = new Funcionario(salario, matricula, setor, nome, cpf, endereco);
				Repository.bdFuncionarios.add(func);
				return true;
			} else {
				System.out.println("Essa matricula já foi registrada!");
				return false;
			}

		} else {
			System.out.println("Valores inválidos, tente novamente!");
			return false;
		}
	}

}