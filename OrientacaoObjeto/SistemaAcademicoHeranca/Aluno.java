/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademicoher;
/**
 *
 * @author rafae
 */
public class Aluno extends Pessoa{

    private String[] disciplinas;
    private String matricula;
    private String curso;
    private int periodo;
    private int contadorDisciplinas;

    public Aluno(String nome, String matricula, String curso, int periodo, int idade, int qtdaDisciplinasPermitidas) {
        super(nome, idade);
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.disciplinas = new String[qtdaDisciplinasPermitidas];
    }


    public String fazMatricula(String disciplina) {
        if (this.disciplinas.length == 0) {
            return "Este aluno não pode ser matriculado em nenhuma disciplina, por favor, fale com a secretaria.";
        } else if (this.contadorDisciplinas < this.disciplinas.length) {
            this.disciplinas[this.contadorDisciplinas++] = disciplina;
            return "Matricula na disciplina " + disciplina + " executada.";
        } else {
            return "Quantidade de disciplinas excedida. O limite de disciplinas\n"
                    + " para este aluno é de " + this.disciplinas.length + " disciplina(s).\n"
                    + " Se desejar, cancele a matrícula de uma das disciplinas e faça a nova matrícula.";
        }
    }

    public String cancelarMatricula(String disciplina) {
        for (int i = 0; i < this.disciplinas.length; i++) {
            if (disciplina.equals(this.disciplinas[i])) {
                for (; i < (this.disciplinas.length - 1); i++) {
                    this.disciplinas[i] = this.disciplinas[i + 1];
                }
                this.disciplinas[i]="";
                return "Cancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.";
            }
        }
        return "Aluno não está matriculado na disciplina " + disciplina + " ,portanto não é possível cancelar esta matrícula."; 
    }
    
    public String imprime(){
        String resultado = "Nome: "+getNome()+"\nMatricula: "+this.matricula+"\nCurso: "+this.curso+
                "\nPeriodo: "+this.periodo+"\nIdade: "+getIdade()+"\nEndereço: "+getEndereco()+ "\nDisciplinas: ";
        for(int i=0; i<disciplinas.length; i++)
            resultado = resultado+disciplinas[i]+" ";
        return resultado;        
    }

    public String[] getDisciplinas() {
        return this.disciplinas;
    }

}