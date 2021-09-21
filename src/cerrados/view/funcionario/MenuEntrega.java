package cerrados.view.funcionario;

import java.util.Scanner;

import cerrados.bd.Repository;
import cerrados.controller.FuncionarioController;
import cerrados.model.services.Pedido;
import cerrados.view.MenuPadrao;

public class MenuEntrega extends MenuPadrao {

    public MenuEntrega() {
        super();
        addMensagem("Menu - Entrega");
        for (Pedido p : Repository.bdPedidos) {
            String texto = "CPF do cliente: " + p.getCliente().getCpf() + "\t entregar em: " + p.getCliente().getEndereco() + "\t Situação: " + p.getSituacao().toString();
            addOpcao(texto);
        }
        addOpcao("Voltar");
    }

    @Override
    public void mostrar() {
        Scanner sc = new Scanner(System.in);
        int op = -1;

        do {
            super.mostrar();
            op = sc.nextInt();
            if(op == super.getQuantidadeOpcoes()-1)return;
            
            Pedido p = Repository.bdPedidos.get(op);
            if (p != null) {
                p.atualizaSituacao();
                p.setFuncionario(FuncionarioController.getFuncionarioController().funcionario);
                System.out.println("Atualizado com sucesso!");
                op++; //confia
            } else {
                if (op != super.getQuantidadeOpcoes() - 1) {
                    System.out.println("Número de pedido inválido!");
                }
            }

            resetaOpcoes();
            for (Pedido pedido : Repository.bdPedidos) {
                String texto = "CPF do cliente: " + pedido.getCliente().getCpf() + "\t entregar em: " + pedido.getCliente().getEndereco()
                        + "\t Situação: " + pedido.getSituacao().toString();
                addOpcao(texto);
            }
            addOpcao("Voltar");

        } while (op != super.getQuantidadeOpcoes() - 1);
    }

}
