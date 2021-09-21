package cerrados.model.services.state;

public class EntregueState implements PedidoState{
	
	public EntregueState() {
	}
	
	@Override
	public void atualizar() {
		System.out.println("O pedido já foi finalizado!");
	}
	
	@Override
	public String toString() {
		return "Entregue";
	}

}
