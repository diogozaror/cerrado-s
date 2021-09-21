package cerrados.model.entities;

import cerrados.bd.Repository;
import java.util.ArrayList;

import cerrados.model.services.Item;
import cerrados.model.services.Pedido;

public class Cliente extends Pessoa {

    private ArrayList<Item> carrinho = new ArrayList<>();
    private ArrayList<Pedido> historico = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf, String endereco) {
        super(nome, cpf, endereco);
    }

    public boolean adicionarAoCarrinho(Item item) {
        return this.carrinho.add(item);
    }

    public boolean removerDoCarrinho(Item item) {
        return this.carrinho.remove(item);
    }

    public ArrayList<Item> getCarrinho() {
        return this.carrinho;
    }

    public boolean hasProduto(Item item) {
        return this.carrinho.contains(item);
    }

    public void mostrarHistorico() {
        for (Pedido p : this.historico) {
            System.out.println(p);
        }
    }

    public void addNoHistorico(Pedido p) {
        this.historico.add(p);
    }

    public void editarCarrinho(int id, int qtd) {
        for (Item i : carrinho) {
            if (i.getProduto().getId() == id) {
                i.setQtd(qtd);
            }
        }
    }
}
