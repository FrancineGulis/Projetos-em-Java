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
public class Diretor extends Funcionario{
    private String[] departamentos;

    public Diretor(String[] departamentos, String cargo, Double salario, String setor, String dataAdmissao, int numeroSuspensoes, Gerente superior, String nome, int cpf, int genero, String dataNascimento) {
        super(cargo, salario, setor, dataAdmissao, numeroSuspensoes, superior, nome, cpf, genero, dataNascimento);
        this.departamentos = departamentos;
    }

    public String[] getDepartamento(){
        return departamentos;
    }
    
    public void setDepartamentos(String[] departamento){
        this.departamentos = departamento;
    }
    
    @Override
    public Double getBonus() {
        return 4*getSalario() + 3000*this.departamentos.length;
    }
    
    
}
