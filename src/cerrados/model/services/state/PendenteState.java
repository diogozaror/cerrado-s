package cerrados.model.services.state;

import cerrados.model.services.Pedido;

public class PendenteState implements PedidoState{

	private Pedido pedido;
	
	public PendenteState(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public void atualizar() {
		System.out.println("Pedido enviado!");
		pedido.setSituacao(new EnviadoState(pedido));
	}

	@Override
	public String toString() {
		return "Pendente";
	}
}
