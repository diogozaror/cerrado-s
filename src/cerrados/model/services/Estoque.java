package cerrados.model.services;

import java.util.ArrayList;

import cerrados.model.entities.Produto;

public class Estoque{
	private static Estoque estoque;
	private ArrayList<Item> itens;
	
	private Estoque() {
		itens = new ArrayList<>();
	}
	
	public static Estoque getEstoque() {
		if(estoque == null) {
			estoque = new Estoque();
		}
		return estoque;
	}

    public ArrayList<Item> getItens(){
        return this.itens;
    }
    
    public Item getItem(Produto produto) {
    	for(Item item : itens) {
    		if(item.getProduto() == produto) {
    			return item;
    		}
    	}
    	return null;
    }

    public boolean adicionarItem(Item item){
        return this.itens.add(item);
    }

    public boolean removeItem(Item item){
        return this.itens.remove(item);
    }

    public boolean hasItem(Item item){
        return this.itens.contains(item);
    }
    
    public boolean hasProduto(Produto produto){
        for(Item i : itens) {
        	if(i.getProduto() == produto) {
        		return true;
        	}
        }
        return false;
    }

}
