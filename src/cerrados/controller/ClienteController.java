package cerrados.controller;

import java.util.Date;

import cerrados.bd.Repository;
import cerrados.model.entities.Cliente;
import cerrados.model.services.Estoque;
import cerrados.model.services.Item;
import cerrados.model.services.Pedido;

public class ClienteController {

    private static ClienteController clientecontroller;

    public static ClienteController getClienteController() {
        if (clientecontroller == null) {
            clientecontroller = new ClienteController();
        }
        return clientecontroller;
    }

    public Cliente cliente;//esse é o cliente logado no momento, sempre que é cadastrado ele muda

    public Cliente getClienteLogado() {
        return cliente;
    }

    private boolean verificaCPF(String cpf) {
        for (Cliente c : Repository.bdClientes) {
            if (c.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public Cliente cadastrarCliente(String nome, String cpf, String endereco) {
        if (nome != null && cpf != null && endereco != null) {

            if (!verificaCPF(cpf)) {
                cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEndereco(endereco);
                Repository.bdClientes.add(cliente);
                return cliente;
            } else {
                System.out.println("Esse CPF já foi registrado!");
                return null;
            }

        } else {
            System.out.println("Valores inválidos, tente novamente!");
            return null;
        }
    }

    public void logOut() {
        cliente = null;
    }

    public boolean validaCompra(String cartao, String codigo) {
         
        if (cartao != null && codigo != null) {
            // codigo vem aqui pra validar o cartao do cara
            for(Item i : cliente.getCarrinho()){
                if(Estoque.getEstoque().getItem(i.getProduto()).getQtd() < i.getQtd()){
                    System.out.println("Não há itens suficientes no estoque!");
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public Pedido transformaCarrinhoEmPedido() {
        Pedido pedido = new Pedido(new Date(), cliente.getCarrinho(), cliente);
        double total = getTotalCarrinho();
        pedido.setTotal(total);
        Repository.bdPedidos.add(pedido);
        for (Item i : cliente.getCarrinho()) {//atualiza a quantidade no estoque
            Item itemEstoque = Estoque.getEstoque().getItem(i.getProduto());
            itemEstoque.setQtd(itemEstoque.getQtd() - i.getQtd());
        }

        cliente.addNoHistorico(pedido);
        return pedido;
    }

    public double getTotalCarrinho() {
        double total = 0;
        for (Item item : cliente.getCarrinho()) {
            total += item.getQtd() * item.getProduto().getPreco();
        }
        return total;
    }

    public Cliente getCliente(String cpf) {
        for (Cliente c : Repository.bdClientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

}
