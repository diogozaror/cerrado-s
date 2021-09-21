package cerrados.model.entities;

import java.util.Objects;

public abstract class Pessoa{

    private String nome;
    private String cpf;
    private String endereco;

    public Pessoa(){

    }

    public Pessoa(String nome, String cpf, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cpf);
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
        final Pessoa other = (Pessoa) obj;
        if(!Objects.equals(this.cpf, other.cpf)){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nCPF: " + cpf + "\nEndereco: " + endereco + '\n';
    }

}
