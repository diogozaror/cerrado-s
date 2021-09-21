package cerrados.model.entities;

import java.util.Objects;

public class Funcionario extends Pessoa{

    private Double salario;
    private Integer matricula;
    private Setor setor;

    public Funcionario(Double salario, Integer matricula, Setor setor, String nome, String cpf, String endereco){
        super(nome, cpf, endereco);
        this.salario = salario;
        this.matricula = matricula;
        this.setor = setor;
    }

    public Double getSalario(){
        return salario;
    }

    public void setSalario(Double salario){
        this.salario = salario;
    }

    public Integer getMatricula(){
        return matricula;
    }

    public void setMatricula(Integer matricula){
        this.matricula = matricula;
    }

    public Setor getSetor(){
        return setor;
    }

    public void setSetor(Setor setor){
        this.setor = setor;
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.matricula);
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
        final Funcionario other = (Funcionario) obj;
        if(!Objects.equals(this.matricula, other.matricula)){
            return false;
        }
        return true;
    }

}