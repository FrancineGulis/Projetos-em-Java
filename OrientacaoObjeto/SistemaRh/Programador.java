/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarhtarde2;

/**
 * @author francine
 */
public class Programador extends Funcionario{

    public Programador(String cargo, Double salario, String setor, String dataAdmissao, int numeroSuspensoes, Gerente superior, String nome, int cpf, int genero, String dataNascimento) {
        super(cargo, salario, setor, dataAdmissao, numeroSuspensoes, superior, nome, cpf, genero, dataNascimento);
    }

    @Override
    public Double getBonus() {
        return getSalario() * 0.8;
    }
    

}
