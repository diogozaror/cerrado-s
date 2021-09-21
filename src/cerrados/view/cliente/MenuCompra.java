package cerrados.view.cliente;

import java.util.Scanner;

import cerrados.controller.ClienteController;
import cerrados.model.entities.Cliente;
import cerrados.model.services.Estoque;
import cerrados.model.services.Item;
import cerrados.view.MenuPadrao;

public class MenuCompra extends MenuPadrao {

    public MenuCompra() {
        super();
        addMensagem("Menu - Compras");
        addMensagem("Digite o índice do produto e a quantidade que deseja adicionar ao carrinho.");
        for (Item i : Estoque.getEstoque().getItens()) {
            String nome = i.getProduto().getNome();
            addOpcao(nome + "-\t R$" + i.getProduto().getPreco() + "\t Itens restantes: " + i.getQtd());
        }
        addOpcao("Voltar");
    }

    @Override
    public void mostrar() {
        Cliente cliente = ClienteController.getClienteController().getClienteLogado();
        int op = 0;
        int qtd = 0;
        Scanner sc = new Scanner(System.in);

        if (cliente == null) {
            System.out.println("Você precisa estar cadastrado!");
            return;
        }

        do {
            super.mostrar();
            op = sc.nextInt();
            if (op == super.getQuantidadeOpcoes() - 1) {
                return;
            }
            qtd = sc.nextInt();

            Item p = Estoque.getEstoque().getItens().get(op);
            if (p != null) {
                cliente.adicionarAoCarrinho(new Item(qtd, p.getProduto()));
                System.out.println("Adicionado com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }

        } while (op != super.getQuantidadeOpcoes() - 1);
    }
}
