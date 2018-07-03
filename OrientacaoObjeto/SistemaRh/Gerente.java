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
public class Gerente extends Funcionario{ //extends chama a classe pai, Gerente herda de Funcionario
    private Funcionario[] subordinados;

    public Gerente(Funcionario[] subordinados, String cargo, Double salario, String setor, String dataAdmissao, int numeroSuspensoes, Gerente superior, String nome, int cpf, int genero, String dataNascimento) {
        super(cargo, salario, setor, dataAdmissao, numeroSuspensoes, superior, nome, cpf, genero, dataNascimento);
        this.subordinados = subordinados;
    }

    public Funcionario[] getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(Funcionario[] subordinados) {
        this.subordinados = subordinados;
    }
    
    
    @Override //redefinindo o metodo getBonus para gerente
    public Double getBonus(){ 
        Double bonus = 2 * getSalario() + 100 * subordinados.length;
        return bonus;
    }
    
}
