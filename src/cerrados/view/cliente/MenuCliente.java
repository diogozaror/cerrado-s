package cerrados.view.cliente;

import java.util.Scanner;

import cerrados.controller.ClienteController;
import cerrados.view.MenuPadrao;

public class MenuCliente extends MenuPadrao {

    private MenuCadastroCliente menucadastro;
    private MenuCompra menucompra;
    private MenuGerenciaCarrinho menucarrinho;

    public MenuCliente() {
        super();
        addMensagem("Menu - Cliente");
        addOpcao("Cadastrar");
        addOpcao("Consultar/Comprar Produto");
        addOpcao("Gerenciar Carrinho");
        addOpcao("Voltar");
        this.menucadastro = new MenuCadastroCliente();
    }

    @Override
    public void mostrar() {
        int op = 0;
        Scanner sc = new Scanner(System.in);

        do {
            super.mostrar();
            op = sc.nextInt();
            switch (op) {
                case 0:
                    System.out.println("Iniciando cadastro...");
                    menucadastro.mostrar();
                    break;
                case 1:
                    System.out.println("Iniciando consulta a produto...");
                    menucompra = new MenuCompra();
                    menucompra.mostrar();
                    break;
                case 2:
                    System.out.println("Iniciando gerência do carrinho...");
                    if (ClienteController.getClienteController().cliente == null) {
                        System.out.println("Você precisa estar cadastrado!");
                        return;
                    }
                    menucarrinho = new MenuGerenciaCarrinho(ClienteController.getClienteController().cliente);
                    menucarrinho.mostrar();
                    break;
                case 3:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Insira opção válida!");
            }

        } while (op != super.getQuantidadeOpcoes() - 1);
    }
}
