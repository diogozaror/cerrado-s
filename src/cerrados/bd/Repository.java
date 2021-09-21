package cerrados.bd;

import java.util.ArrayList;

import cerrados.model.entities.Cliente;
import cerrados.model.entities.Fornecedor;
import cerrados.model.entities.Funcionario;
import cerrados.model.entities.Produto;
import cerrados.model.services.Item;
import cerrados.model.services.Pedido;

public class Repository{
	  //private static Repository repository;
	  public static ArrayList<Cliente> bdClientes = new ArrayList<Cliente>();
	  public static ArrayList<Funcionario> bdFuncionarios = new ArrayList<Funcionario>();
	  public static ArrayList<Produto> bdProduto = new ArrayList<Produto>();
	  public static ArrayList<Pedido> bdPedidos = new ArrayList<Pedido>();
	  public static ArrayList<Fornecedor> bdFornecedores = new ArrayList<Fornecedor>();
	  public static ArrayList<Item> bdProdutoSolicitado = new ArrayList<Item>();
	  
}
