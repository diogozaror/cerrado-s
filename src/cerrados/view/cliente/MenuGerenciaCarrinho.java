package cerrados.view.cliente;

import java.util.Scanner;

import cerrados.model.entities.Cliente;
import cerrados.model.services.Item;
import cerrados.view.MenuPadrao;

public class MenuGerenciaCarrinho extends MenuPadrao {

    private Cliente cliente;
    private MenuFinalizaCompra menufinaliza;

    public MenuGerenciaCarrinho(Cliente cliente) {
        super();
        this.cliente = cliente;
        addMensagem("Menu - Compras");
        addMensagem("Digite o indice do item e a quantidade que deseja mudar no carrinho, coloque 0 para remover o produto!");
        for (Item item : cliente.getCarrinho()) {
            String nome = item.getProduto().getNome() + "\t Quantidade: " + item.getQtd();
            addOpcao(nome);
        }
        addOpcao("Finalizar Compra");
        addOpcao("Voltar");
    }

    @Override
    public void mostrar() {
        int op = 0;
        int qtd = 0;
        Scanner sc = new Scanner(System.in);

        do {
            super.mostrar();
            op = sc.nextInt();
            if (op == super.getQuantidadeOpcoes() - 1) {
                return;
            }
            if (op == super.getQuantidadeOpcoes() - 2) {
                menufinaliza = new MenuFinalizaCompra();
                menufinaliza.mostrar();
                return;
            }
            qtd = sc.nextInt();
            Item item = cliente.getCarrinho().get(op);
            if (item != null) {
                if (qtd != 0) {
                    cliente.editarCarrinho(item.getProduto().getId(), qtd);
                    System.out.println("Editado com sucesso!");
                } else {
                    cliente.removerDoCarrinho(item);
                    System.out.println("Removido com sucesso!");
                }
            } else {
                System.out.println("Item não encontrado!");
            }
            resetaOpcoes();
            for (Item item2 : cliente.getCarrinho()) {
                String nome = item2.getProduto().getNome() + "\t Quantidade: " + item2.getQtd();
                addOpcao(nome);
            }
            addOpcao("Finalizar Compra");
            addOpcao("Voltar");

        } while (op != super.getQuantidadeOpcoes() - 1);
    }
}
