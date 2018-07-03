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
public abstract class Pessoa {
    private String nome;
    private int cpf;
    private int genero;
    private String dataNascimento;

    public Pessoa(String nome, int cpf, int genero, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }


    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
  
    
    
}
