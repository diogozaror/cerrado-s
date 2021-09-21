package cerrados.controller;

import cerrados.bd.Repository;
import cerrados.model.entities.Fornecedor;

public class FornecedorController {

	private static FornecedorController fornecedorController;

	public static FornecedorController getFornecedorController() {
		if (fornecedorController == null) {
			fornecedorController = new FornecedorController();
		}
		return fornecedorController;
	}
	
	public boolean hasFornecedor(String cnpj) {
		if(getFornecedor(cnpj)!=null)return true;
		return false;
	}
	
	public Fornecedor getFornecedor(String cnpj) {
		for(Fornecedor f : Repository.bdFornecedores) {
			if(f.getCnpj().equals(cnpj))return f;
		}
		return null;
	}

	public boolean cadastrarFornecedor(String nome, String cnpj, String telefone) {
		if (nome != null && cnpj != null && telefone != null) {
			if (!hasFornecedor(cnpj)) {
				Fornecedor forn = new Fornecedor(cnpj, nome, telefone);
				Repository.bdFornecedores.add(forn);
				return true;
			} else {
				System.out.println("Esse CNPJ já foi registrado!");
				return false;
			}

		} else {
			System.out.println("Valores inválidos, tente novamente!");
			return false;
		}
	}
}
