package cerrados.view.funcionario;

import java.util.Scanner;

import cerrados.view.MenuPadrao;

public class MenuGerente extends MenuPadrao{
    private MenuCadastroFuncionario menuCadastroFuncionario;
    private MenuCadastroFornecedor menuCadastroFornecedor;
    private MenuCadastroProduto menuCadastroProduto;
    private MenuRelatorios menuRelatorio;
    private MenuEstoque menuEstoque;
    
    public MenuGerente(){
        super();
        addMensagem("Menu - Gerente");
        addOpcao("Cadastrar funcionários");
        addOpcao("Cadastrar fornecedor");
        addOpcao("Cadastrar produto");
        addOpcao("Ver relatórios");
        addOpcao("Ver solicitações de re-estoque");
        addOpcao("Voltar");
        this.menuCadastroFuncionario = new MenuCadastroFuncionario();
        this.menuCadastroFornecedor = new MenuCadastroFornecedor();
        this.menuCadastroProduto = new MenuCadastroProduto();
    }
    
    @Override
    public void mostrar(){
        int op = 0;
        Scanner sc = new Scanner(System.in);
        
        do{
            super.mostrar();
            op = sc.nextInt();
            
            switch(op){
                case 0:
                    System.out.println("Iniciando o menu de cadastro do funcionário...");
                    menuCadastroFuncionario.mostrar();
                    break;
                case 1:
                	System.out.println("Iniciando o menu de cadastro do fornecedor...");
                	menuCadastroFornecedor.mostrar();
                    break;
                case 2:
                	System.out.println("Iniciando o menu de cadastro de produtos...");
                	menuCadastroProduto.mostrar();
                    break;
                case 3:
                	System.out.println("Iniciando consulta a relatórios...");
                	menuRelatorio = new MenuRelatorios();
                	menuRelatorio.mostrar();
                	break;
                case 4:
                	System.out.println("Iniciando solicitações de reestoque...");
                	menuEstoque = new MenuEstoque();
                	menuEstoque.mostrar();
                	break;
                case 5:
                	System.out.println("Voltando...");
                	break;
                    
                default:
                    System.out.println("Digite opção válida!");
            }
            
        }while(op != super.getQuantidadeOpcoes()-1);
        
    }
}
