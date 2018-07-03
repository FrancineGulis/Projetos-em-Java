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
public class Vendedor extends Funcionario{ //extends chama a classe pai, Vendedor herda de Funcionario
    private Double comissao;

    public Vendedor(Double comissao, String cargo, Double salario, String setor, String dataAdmissao, int numeroSuspensoes, Gerente superior, String nome, int cpf, int genero, String dataNascimento) {
        super(cargo, salario, setor, dataAdmissao, numeroSuspensoes, superior, nome, cpf, genero, dataNascimento);
        this.comissao = comissao;
    }

    
    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
    
    
    @Override //redefinindo o metodo getBonus para vendedor
    public Double getBonus(){ //redefinindo o metodo getBonus para vendedor
        return getSalario()+0.2*getComissao();
    }
        
}
