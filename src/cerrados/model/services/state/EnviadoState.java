package cerrados.model.services.state;

import cerrados.model.services.Pedido;

public class EnviadoState implements PedidoState{

	private Pedido pedido;
	
	public EnviadoState(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public void atualizar() {
		System.out.println("Pedido entregue!");
		pedido.setSituacao(new EntregueState());
	}

	@Override
	public String toString() {
		return "Enviado";
	}
}
