package cerrados.model.entities;

import java.util.Objects;

public class Produto{

    private Integer id;
    private String nome;
    private Double preco;

    public Produto(Integer id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if(!Objects.equals(this.id, other.id)){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Produto{" + "id=" + id + ", nome=" + nome + ", preco=" + preco + '}';
    }

}
