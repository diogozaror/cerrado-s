package cerrados.view.funcionario;

import cerrados.controller.ClienteController;
import cerrados.model.entities.Cliente;
import cerrados.view.MenuPadrao;
import java.util.Scanner;

public class MenuRelatorios extends MenuPadrao {

	public MenuRelatorios() {
		super();
		addMensagem("Menu - Relatórios");
	}

	@Override
	public void mostrar() {
		Scanner sc = new Scanner(System.in);
		boolean sair = false;
		Cliente c = null;
		do {
			System.out.println("Digite o CPF do cliente (ou coloque um CPF que não é válido para sair!):");
			String cpf = sc.nextLine();
			c = ClienteController.getClienteController().getCliente(cpf);
			if (c == null) {
				System.out.println("CPF inválido! Voltando à página anterior...");
				sair = true;
			} else {
				System.out.println("Pedidos do cliente:");
				c.mostrarHistorico();
				System.out.println("");
			}

		} while (!sair);
	}
}
