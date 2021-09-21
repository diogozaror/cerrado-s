package cerrados.view.funcionario;

import java.util.Scanner;

import cerrados.controller.FornecedorController;
import cerrados.view.MenuPadrao;

public class MenuCadastroFornecedor extends MenuPadrao {

    public MenuCadastroFornecedor() {
        super();
        addMensagem("Menu - Cadastro Fornecedor");
    }

    @Override
    public void mostrar() {
        int estagio = 0;
        String nome = "";
        String cnpj = "";
        String telefone = "";

        Scanner sc = new Scanner(System.in);
        do {
            super.mostrar();
            switch (estagio) {
                case 0:
                    System.out.println("Digite o nome da empresa:");
                    nome = sc.nextLine();
                    estagio++;
                    break;
                case 1:
                    System.out.println("Digite o CNPJ da empresa:");
                    cnpj = sc.nextLine();
                    estagio++;
                    break;
                case 2:
                    System.out.println("Digite o telefone da empresa:");
                    telefone = sc.nextLine();
                    estagio++;
                    break;
                case 3:
                    boolean deuCerto = FornecedorController.getFornecedorController().cadastrarFornecedor(nome, cnpj, telefone);
                    if (deuCerto) {
                        System.out.println("Cadastrado!");
                        estagio++;
                    } else {
                        estagio = 0;
                        System.out.print("Houve um erro! Tente novamente!");
                    }

                default:
                    break;
            }
        } while (estagio <= 3);
    }

}
