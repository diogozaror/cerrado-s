package cerrados.controller;

import java.util.ArrayList;
import java.util.Date;

import cerrados.bd.Repository;
import cerrados.model.entities.Cliente;
import cerrados.model.entities.Produto;
import cerrados.model.services.Item;
import cerrados.model.services.Pedido;

public class PedidoController {

    private static PedidoController pedidocontroller;

    public static PedidoController getPedidoController() {
        if (pedidocontroller == null) {
            pedidocontroller = new PedidoController();
        }
        return pedidocontroller;
    }

    public Produto getProduto(int id) {
        for (Produto p : Repository.bdProduto) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public Pedido getPedido(int id) {
        for (Pedido p : Repository.bdPedidos) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public Produto adicionarProduto(int id, String nome, double preco) {
        Produto p = new Produto(id, nome, preco);
        Repository.bdProduto.add(p);
        return p;
    }

    public Pedido adicionarPedido(Date data, ArrayList<Item> itens, Cliente cliente) {
        Pedido p = new Pedido(data, itens, cliente);
        Repository.bdPedidos.add(p);
        return p;
    }
}
