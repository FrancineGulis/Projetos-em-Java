/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarhtardealterado;

/**
 *
 * @author francine
 */
public class AuxDeLimpeza extends Funcionario{

    public AuxDeLimpeza(String cargo, Double salario, String setor, String dataAdmissao, int numeroSuspensoes, Gerente superior, String nome, int cpf, int genero, String dataNascimento) {
        super(cargo, salario, setor, dataAdmissao, numeroSuspensoes, superior, nome, cpf, genero, dataNascimento);
    }
    
    @Override
    public Double getBonus(){
        return 0.5 * getSalario();
    }
    
    
    
    
}
