package cerrados.view.funcionario;

import cerrados.controller.FuncionarioController;
import cerrados.model.entities.Setor;
import cerrados.view.MenuPadrao;
import java.util.Scanner;

public class MenuCadastroFuncionario extends MenuPadrao {

    public MenuCadastroFuncionario() {
        super();
        addMensagem("Menu - Cadastro Funcionários");
    }

    @Override
    public void mostrar() {
        int estagio = 0;
        String nome = "";
        String cpf = "";
        String endereco = "";
        double salario = 0.0;
        Setor setor = null;

        Scanner sc = new Scanner(System.in);
        do {
            super.mostrar();
            switch (estagio) {
                case 0:
                    System.out.println("Digite o nome do funcionário:");
                    nome = sc.nextLine();
                    estagio++;
                    break;
                case 1:
                    System.out.println("Digite o CPF do funcionário:");
                    cpf = sc.nextLine();
                    estagio++;
                    break;
                case 2:
                    System.out.println("Digite o salário:");
                    try {
                        salario = Double.parseDouble(sc.nextLine());
                        estagio++;
                    } catch (NumberFormatException nfe) {
                        System.err.println("Deve ser um valor numérico!");
                        estagio = 2;
                    }
                    break;
                case 3:
                    System.out.println("Digite o endereço:");
                    endereco = sc.nextLine();
                    estagio++;
                    break;
                case 4:
                    System.out.println("Digite:");
                    System.out.println("[1] se o funcionário for um entregador");
                    System.out.println("[2] se o funcionário for um almoxarife");
                    System.out.println("[3] se o funcionário for um gerente");
                    int meuSetor = sc.nextInt(); //talvez tenha que dar next line depois disso?
                    if (meuSetor == 1) {
                        setor = Setor.ENTREGA;
                    }
                    if (meuSetor == 2) {
                        setor = Setor.ALMOXARIFE;
                    }
                    if (meuSetor == 3) {
                        setor = Setor.GERENCIA;
                    }
                    estagio++;
                    break;

                case 5:
                    boolean deuCerto = FuncionarioController.getFuncionarioController().cadastrarFuncionario(nome, cpf, endereco, salario, setor);
                    if (deuCerto) {
                        System.out.println("Cadastrado!");
                        estagio++;
                    } else {
                        estagio = 0;
                        System.out.print("Houve um erro! Tente novamente!");
                    }

                default:
                    break;
            }
        } while (estagio <= 5);
    }

}
