package cerrados.view.funcionario;

import java.util.ArrayList;
import java.util.Scanner;

import cerrados.controller.FornecedorController;
import cerrados.controller.PedidoController;
import cerrados.model.entities.Fornecedor;
import cerrados.model.entities.Produto;
import cerrados.model.services.Estoque;
import cerrados.model.services.Item;
import cerrados.view.MenuPadrao;

public class MenuCadastroProduto extends MenuPadrao {

    public MenuCadastroProduto() {
        super();
        addMensagem("\nMenu - Cadastro de Produtos");
    }

    @Override
    public void mostrar() {
        int estagio = 0;
        int id = 0;
        String nome = "";
        double preco = 0;
        Fornecedor forn = null;

        Scanner sc = new Scanner(System.in);
        do {
            super.mostrar();
            switch (estagio) {
                case 0:
                    System.out.println("Digite o id do produto:");
                    try {
                        id = Integer.parseInt(sc.nextLine());
                        estagio++;
                    } catch (NumberFormatException nfe) {
                        System.err.println("Deve ser um valor numérico!");
                        estagio = 0;
                    }
                    break;
                case 1:
                    System.out.println("Digite o nome do produto:");
                    nome = sc.nextLine();
                    estagio++;
                    break;
                case 2:
                    System.out.println("Digite o preço do produto:");
                    try {
                        preco = Double.parseDouble(sc.nextLine());
                        estagio++;
                    } catch (NumberFormatException nfe) {
                        System.err.println("Deve ser um valor numérico!");
                        estagio = 2;
                    }
                    break;
                case 3:
                    System.out.println("Digite o CNPJ do fornecedor deste produto:");
                    String cnpj = sc.nextLine();
                    forn = FornecedorController.getFornecedorController().getFornecedor(cnpj);
                    estagio++;
                    break;
                case 4:
                    if (forn != null) {
                        Produto p = PedidoController.getPedidoController().adicionarProduto(id, nome, preco);
                        ArrayList<Produto> produtos = forn.getProdutos();
                        produtos.add(p);
                        forn.setProdutos(produtos);
                        Estoque.getEstoque().adicionarItem(new Item(0, p));
                        System.out.println("Cadastrado!");
                    } else {
                        System.out.println("Houve um erro CPNJ não encontrado! Tente novamente!");
                    }
                    estagio++;

                default:
                    break;
            }
        } while (estagio <= 4);
    }

}
