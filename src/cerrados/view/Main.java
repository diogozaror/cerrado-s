package cerrados.view;

import cerrados.controller.ClienteController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import cerrados.controller.FornecedorController;
import cerrados.controller.FuncionarioController;
import cerrados.controller.PedidoController;
import cerrados.model.entities.Cliente;
import cerrados.model.entities.Produto;
import cerrados.model.entities.Setor;
import cerrados.model.services.Estoque;
import cerrados.model.services.Item;
import cerrados.model.services.Pedido;

public class Main{
    
    public static void main(String[] args) {
        //produtos que ja vem
        Produto p1 = PedidoController.getPedidoController().adicionarProduto(5, "Mesa de Madeira Bonita", 255.5D);
        Produto p2 = PedidoController.getPedidoController().adicionarProduto(10, "Cadeira com encosto", 150.2D);
        Estoque.getEstoque().adicionarItem(new Item(25, p1));
        Estoque.getEstoque().adicionarItem(new Item(34, p2));

        FuncionarioController.getFuncionarioController().cadastrarFuncionario("Jorginho", "123-1", "pega a 12", 4000.D, Setor.GERENCIA); //matricula 0
        FuncionarioController.getFuncionarioController().cadastrarFuncionario("Cleiton", "321-1", "Rua C", 1000.D, Setor.ENTREGA); //matricula 1
        FuncionarioController.getFuncionarioController().cadastrarFuncionario("Robertinho", "231-1", "Rua D", 1300.D, Setor.ALMOXARIFE); //matricula 2

        FornecedorController.getFornecedorController().cadastrarFornecedor("Roberto's Wood", "36", "22");

        Cliente novo = ClienteController.getClienteController().cadastrarCliente("Cleitinho", "99", "Rua Wolverine");
        Produto meuProduto1 = PedidoController.getPedidoController().getProduto(5);
        Produto meuProduto2 = PedidoController.getPedidoController().getProduto(10);
        Item it1 = new Item(7, meuProduto1);
        Item it2 = new Item(10, meuProduto2);
        Pedido pedido = PedidoController.getPedidoController().adicionarPedido(new Date(), new ArrayList<Item>(Arrays.asList(it1, it2)), novo);
        novo.addNoHistorico(pedido);

        
        new MenuPrincipal().mostrar();
    }

}
