package cerrados.view;

import cerrados.view.cliente.MenuCliente;
import cerrados.view.funcionario.MenuLoginFuncionario;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal extends MenuPadrao {

    private MenuLoginFuncionario menuf;
    private MenuCliente menuc;

    public MenuPrincipal() {
        super();
        addMensagem("MENU PRINCIPAL");
        addOpcao("Sou Cliente");
        addOpcao("Sou Funcionário");
        addOpcao("Sair");
        menuf = new MenuLoginFuncionario();
        menuc = new MenuCliente();
    }

    @Override
    public void mostrar() {

        int op = 0;
        Scanner sc = new Scanner(System.in);
        do {
            super.mostrar();
            try {
                op = sc.nextInt();
                switch (op) {
                    case 0:
                        menuc.mostrar();
                        break;
                    case 1:
                        menuf.mostrar();
                        break;

                    case 2:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Digite um número válido!");
            }
        } while (op != super.getQuantidadeOpcoes() - 1);

        sc.close();
    }

}
