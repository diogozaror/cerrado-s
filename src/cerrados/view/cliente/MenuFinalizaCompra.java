package cerrados.view.cliente;

import java.util.Scanner;

import cerrados.controller.ClienteController;
import cerrados.view.MenuPadrao;

public class MenuFinalizaCompra extends MenuPadrao {

    public MenuFinalizaCompra() {
        super();
        addMensagem("Menu - Finaliza Compra");
        addMensagem("Sua compra deu: " + ClienteController.getClienteController().getTotalCarrinho());
    }

    @Override
    public void mostrar() {
        int estagio = 0;
        String cartao = "";
        String codigo = "";
        Scanner sc = new Scanner(System.in);
        do {
            super.mostrar();
            switch (estagio) {
                case 0:
                    System.out.println("Digite o seu cartão:");
                    cartao = sc.nextLine();
                    estagio++;
                    break;
                case 1:
                    System.out.println("Digite o código verificador atrás do cartão:");
                    codigo = sc.nextLine();
                    estagio++;
                    break;
                case 2:
                    boolean deuCerto = ClienteController.getClienteController().validaCompra(cartao, codigo);
                    if (deuCerto) {
                        ClienteController.getClienteController().transformaCarrinhoEmPedido();
                        ClienteController.getClienteController().cliente.getCarrinho().clear();
                        System.out.println("Compra finalizada!");
                        estagio++;
                    } else {
                        estagio = 0;
                        System.out.println("Houve um erro! Tente novamente!");
                    }
                    break;

                default:
                    break;
            }
        } while (estagio < 3);
    }
}
