package cerrados.view;

import java.util.*;

public class MenuPadrao implements Menu{

  private ArrayList<String> mensagem;
  private ArrayList<String> opcao;

  public MenuPadrao(){
    this.mensagem = new ArrayList<String>();
    this.opcao = new ArrayList<String>();
  }

  public MenuPadrao(ArrayList<String> mensagem, ArrayList<String> opcao){
    this.mensagem = mensagem;
    this.opcao = opcao;
  }

  public void addMensagem(String string){
    this.mensagem.add(string);
  }

  public void addOpcao(String string){
    this.opcao.add(string);
  }
  
  public void resetaOpcoes() {
	  this.opcao.clear();
  }

  public int getQuantidadeOpcoes(){
    return this.opcao.size();
  }

  @Override
  public void mostrar(){
    for(String a : this.mensagem){
      System.out.println(a);
    }
    System.out.println(" ");
    int aux = 0;
    for(String a : this.opcao){
      System.out.println("["+aux+"] " + a);
      aux+=1;
    }
  }

}