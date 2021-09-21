package cerrados.view.funcionario;

import java.util.Scanner;

import cerrados.bd.Repository;
import cerrados.model.services.Estoque;
import cerrados.model.services.Item;
import cerrados.view.MenuPadrao;

public class MenuEstoque extends MenuPadrao {

    public MenuEstoque() {
        super();
        addMensagem("Menu - Solicitação de Estoque");
        for (Item p : Repository.bdProdutoSolicitado) {
            String texto = "Nome: " + p.getProduto().getNome() + " Quantidade solicitada: " + p.getQtd();
            addOpcao(texto);
        }
        addOpcao("Voltar");
    }

    @Override
    public void mostrar() {
        Scanner sc = new Scanner(System.in);
        int op = -1;

        do {
            super.mostrar();
            op = sc.nextInt();

            if (op == super.getQuantidadeOpcoes() - 1) {
                return;
            }
            if (op <= Repository.bdProdutoSolicitado.size()) {
                Item item = Repository.bdProdutoSolicitado.get(op);
                if (item != null) {
                    if (Estoque.getEstoque().hasProduto(item.getProduto())) {
                        Item itemEstocado = Estoque.getEstoque().getItem(item.getProduto());
                        itemEstocado.setQtd(itemEstocado.getQtd() + item.getQtd());
                    } else {
                        Estoque.getEstoque().adicionarItem(item);
                    }
                    Repository.bdProdutoSolicitado.remove(op);
                    System.out.println("Solicitação atendida!");
                } else {
                    System.out.println("Não foi possível atender a solicitação!");
                    return;
                }
            }

            resetaOpcoes();
            for (Item p : Repository.bdProdutoSolicitado) {
                String texto = "Nome: " + p.getProduto().getNome() + " Quantidade solicitada: " + p.getQtd();
                addOpcao(texto);
            }
            addOpcao("Voltar");
            op = -1;

        } while (op!=super.getQuantidadeOpcoes()-1);
    }

}
