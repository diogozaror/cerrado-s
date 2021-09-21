package cerrados.model.services;

import java.util.ArrayList;
import java.util.Date;

import cerrados.model.entities.Cliente;
import cerrados.model.entities.Funcionario;
import cerrados.model.services.state.PedidoState;
import cerrados.model.services.state.PendenteState;

public class Pedido{


    private int id;
    private Date data;
    private ArrayList<Item> itens = new ArrayList<>();
    private Funcionario funcionario;
    private Cliente cliente;
    private PedidoState situacao;
    private double total;

    public Pedido(Date data, ArrayList<Item> itens, Cliente cliente){
        this.data = data;
        this.funcionario = null;
        this.cliente = cliente;
        this.situacao = new PendenteState(this);
    }
    
    public Pedido(Date data, ArrayList<Item> itens, Funcionario funcionario, Cliente cliente){
        this.data = data;
        this.itens = itens;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.situacao = new PendenteState(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean addItem(Item item){
        return this.itens.add(item);

    }

    public boolean removeItem(Item item){
        return this.itens.add(item);

    }

    public boolean hasItem(Item item){
        return this.itens.contains(item);

    }

    public Date getData(){
        return data;
    }

    public void setData(Date data){
        this.data = data;
    }

    public ArrayList<Item> getItens(){
        return itens;
    }

    public Funcionario getFuncionario(){
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setEnderecoEntrega(Cliente cliente){
        this.cliente = cliente;
    }

    public PedidoState getSituacao(){
        return this.situacao;
    }

    public void setSituacao(PedidoState situacao){
        this.situacao = situacao;
    }
    
    public void atualizaSituacao() {
    	this.situacao.atualizar();
    }
    
    public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


    @Override
    public String toString(){
        return "Pedido{" + "data: " + data + ", funcionario: " + funcionario + ", endereçoEntrega: " + cliente.getEndereco() + ", situação: " + situacao + '}';
    }

}
