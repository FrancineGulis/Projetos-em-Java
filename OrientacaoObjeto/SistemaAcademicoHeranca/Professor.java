/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademicoher;

/**
 *
 * @author francine
 */
public class Professor extends Pessoa {

    private String[] disciplinas;
    private int contadorDisciplinas;

    public Professor(String nome, int idade, int qtdaDisciplinasLeciona) {
        super(nome, idade);
        this.disciplinas = new String[qtdaDisciplinasLeciona];
    }

    public String disciplinasLeciona(String disciplina) {
        if (this.disciplinas.length == 0) {
            return "Este professor não pode lecionar em nenhuma disciplina, por favor, fale com a secretaria.";
        } else if (this.contadorDisciplinas < this.disciplinas.length) {
            this.disciplinas[this.contadorDisciplinas++] = disciplina;
            return "Matricula na disciplina " + disciplina + " executada.";
        } else {
            return "Quantidade de disciplinas excedida. O limite de disciplinas\n"
                    + " para este professor é de " + this.disciplinas.length + " disciplina(s).\n"
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
        return "Professor não está matriculado na disciplina " + disciplina + " ,portanto não é possível cancelar esta matrícula."; 
    }

    public String imprime() {
        String resultado = "Nome: " + getNome() + "\nIdade: " + getIdade() + "\nEndereço: " + getEndereco() + "\nDisciplinas: ";
        for (int i = 0; i < disciplinas.length; i++) {
            resultado = resultado + disciplinas[i] + " ";
        }
        return resultado;
    }

    public String[] getDisciplinas() {
        return this.disciplinas;
    }    
}
