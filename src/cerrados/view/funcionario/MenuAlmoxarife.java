package cerrados.view.funcionario;

import java.util.Scanner;

import cerrados.bd.Repository;
import cerrados.model.services.Estoque;
import cerrados.model.services.Item;
import cerrados.view.MenuPadrao;

public class MenuAlmoxarife extends MenuPadrao {

    public MenuAlmoxarife() {
        super();
        addMensagem("Menu - Almoxarifado");
        addMensagem("Digite o indice do produto e a quantidade a solicitar!");
        for (Item i : Estoque.getEstoque().getItens()) {
            addOpcao("Nome: " + i.getProduto().getNome() + " Quantidade: " + i.getQtd() + " ID: " + i.getProduto().getId());
        }
        addOpcao("Voltar");
    }

    @Override
    public void mostrar() {
        Scanner sc = new Scanner(System.in);
        int op = -1;
        int qtd = 0;

        do {
            super.mostrar();
            op = sc.nextInt();
            if (op == super.getQuantidadeOpcoes() - 1) {
                return;
            }
            qtd = sc.nextInt();

            Item p = Estoque.getEstoque().getItens().get(op);
            if (p != null) {
                Item i = new Item(qtd, p.getProduto());
                Repository.bdProdutoSolicitado.add(i);
                System.out.println("Solicitado com sucesso!");
            } else {
                System.out.println("Produto inv�lido!");
            }
            resetaOpcoes();
            for (Item i : Estoque.getEstoque().getItens()) {
                addOpcao("Nome: " + i.getProduto().getNome() + " Quantidade: " + i.getQtd() + " ID: " + i.getProduto().getId());
            }
            addOpcao("Voltar");

        } while (op != super.getQuantidadeOpcoes() - 1);
    }

}
