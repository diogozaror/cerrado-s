package cerrados.model.services;

import cerrados.model.entities.Produto;
import java.util.Objects;

public class Item{

    private Integer qtd;
    private Produto produto;

    public Item(Integer qtd, Produto produto){
        this.qtd = qtd;
        this.produto = produto;
    }

    public Integer getQtd(){
        return qtd;
    }

    public void setQtd(Integer qtd){
        this.qtd = qtd;
    }

    public Produto getProduto(){
        return produto;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Item other = (Item) obj;
        if(!Objects.equals(this.produto, other.produto)){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Item{" + "qtd=" + qtd + ", produto=" + produto + '}';
    }

}
