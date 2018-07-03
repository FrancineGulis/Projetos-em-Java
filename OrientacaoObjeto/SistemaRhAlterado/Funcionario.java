/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarhtarde2;

/**
 *
 * @author francine
 */
public abstract class Funcionario extends Pessoa{ //extends chama a classe pai, Funcionário herda de Pessoa
    private String cargo;
    private Double salario;
    private String setor;
    private String dataAdmissao;
    private int numeroSuspensoes;
    private Gerente superior;

    public Funcionario(String cargo, Double salario, String setor, String dataAdmissao, int numeroSuspensoes, Gerente superior, String nome, int cpf, int genero, String dataNascimento) {
        super(nome, cpf, genero, dataNascimento);//chamada do construtor da clase pai
        this.cargo = cargo;
        this.salario = salario;
        this.setor = setor;
        this.dataAdmissao = dataAdmissao;
        this.numeroSuspensoes = numeroSuspensoes;
        this.superior = superior;
    }
    
    public Funcionario(String cargo, Double salario, String setor, String dataAdmissao, int numeroSuspensoes, Gerente superior, Pessoa p) { //Passa uma Pessoa como atributo 
        super(p.getNome(), p.getCpf(), p.getGenero(), p.getDataNascimento());/*chamada do construtor da clase pai, Pessoa,
                                                                             pegando os atributos da classe passada como paremetro do construtor*/
        this.cargo = cargo;
        this.salario = salario;
        this.setor = setor;
        this.dataAdmissao = dataAdmissao;
        this.numeroSuspensoes = numeroSuspensoes;
        this.superior = superior;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public int getNumeroSuspensoes() {
        return numeroSuspensoes;
    }

    public void suspender() {
        this.numeroSuspensoes++;
    }

    public Gerente getSuperior() {
        return superior;
    }

    public void setSuperior(Gerente superior) {
        this.superior = superior;
    }
    
    public abstract Double getBonus();
    
    public String toString(){
        String retorno = "Nome: " + getNome() +  ";Cargo: " + getCargo()+ ";Salario: " +getSalario()+ ";Bonus: " +getBonus();
        return retorno;
    }
}
