package cerrados.view.cliente;

import java.util.Scanner;

import cerrados.controller.ClienteController;
import cerrados.view.MenuPadrao;

public class MenuCadastroCliente extends MenuPadrao {

    public MenuCadastroCliente() {
        super();
        addMensagem("Menu - Cadastro Cliente");
    }

    @Override
    public void mostrar() {
        int estagio = 0;
        String nome = "";
        String cpf = "";
        String endereco = "";
        Scanner sc = new Scanner(System.in);
        do {
            super.mostrar();
            switch (estagio) {
                case 0:
                    System.out.println("Digite o seu nome:");
                    nome = sc.nextLine();
                    estagio++;
                    break;
                case 1:
                    System.out.println("Digite o seu CPF:");
                    cpf = sc.nextLine();
                    estagio++;
                    break;
                case 2:
                    System.out.println("Digite o seu endereço:");
                    endereco = sc.nextLine();
                    estagio++;
                    break;
                case 3:
                    boolean deuCerto;
                    deuCerto = ClienteController.getClienteController().cadastrarCliente(nome, cpf, endereco) != null;
                    if (deuCerto) {
                        System.out.println("Cadastrado!");
                        System.out.println("Bem-vindo, " + ClienteController.getClienteController().cliente.getNome());
                        estagio++;
                    } else {
                        estagio = 0;
                        System.out.println("Houve um erro! Tente novamente!");
                    }

                default:
                    break;
            }
        } while (estagio < 4);
    }
}
