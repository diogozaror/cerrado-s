package cerrados.model.entities;

import java.util.ArrayList;
import java.util.Objects;

public class Fornecedor{

    private String cnpj;
    private String nome;
    private String telefone;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Fornecedor(String cnpj, String nome, String telefone){
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public ArrayList<Produto> getProdutos(){
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos){
        this.produtos = produtos;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cnpj);
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
        final Fornecedor other = (Fornecedor) obj;
        if(!Objects.equals(this.cnpj, other.cnpj)){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Fornecedor{" + "cnpj=" + cnpj + ", nome=" + nome + ", telefone=" + telefone + ", produtos=" + produtos + '}';
    }

}
