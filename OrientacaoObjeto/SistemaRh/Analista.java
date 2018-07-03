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
public class Analista extends Funcionario{ //extends chama a classe pai, Analista herda de Funcionario
    private String[] projeto;

    public Analista(String cargo, Double salario, String setor, String dataAdmissao, int numeroSuspensoes, Gerente superior, String nome, int cpf, int genero, String dataNascimento) {
        super(cargo, salario, setor, dataAdmissao, numeroSuspensoes, superior, nome, cpf, genero, dataNascimento);
    }

    public String[] getProjeto() {
        return projeto;
    }

    public void setProjeto(String[] projeto) {
        this.projeto = projeto;
    }

    @Override
    public Double getBonus() {
       return getSalario();
    }
    
    
}
