package cerrados.view.funcionario;

import cerrados.bd.Repository;
import cerrados.controller.FuncionarioController;
import cerrados.model.entities.Funcionario;
import cerrados.model.entities.Setor;
import cerrados.view.MenuPadrao;
import java.util.Scanner;

public class MenuLoginFuncionario extends MenuPadrao {

    private MenuEntrega menuEntrega;
    private MenuAlmoxarife menuAlmoxarife;
    private MenuGerente menuGerencia;

    public MenuLoginFuncionario() {
        super();
        addMensagem("Menu - Matrícula");
        this.menuGerencia = new MenuGerente();
    }

    @Override
    public void mostrar() {
            super.mostrar();
            System.out.println("Insira sua matrícula:");
            Scanner sc = new Scanner(System.in);
            int matricula = sc.nextInt();
            if (FuncionarioController.getFuncionarioController().hasFuncionario(matricula)) {
                for (Funcionario f : Repository.bdFuncionarios) {
                    if (f.getMatricula() == matricula) {
                        FuncionarioController.getFuncionarioController().funcionario = f;
                        if (f.getSetor() == Setor.ENTREGA) {
                            menuEntrega = new MenuEntrega();
                            menuEntrega.mostrar();
                        } else if (f.getSetor() == Setor.ALMOXARIFE) {
                        	menuAlmoxarife = new MenuAlmoxarife();
                            menuAlmoxarife.mostrar();
                        } else if (f.getSetor() == Setor.GERENCIA) {
                            menuGerencia.mostrar();
                        }
                        break;
                    }
                }
            }
    }
}
