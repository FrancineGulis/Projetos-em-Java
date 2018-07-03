
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author francine
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String sobrenome;
    private String RG;
    private String CPF;
    private String Endereco;

    public Cliente(String nome, String sobrenome, String RG, String CPF, String Endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.CPF = CPF;
        this.Endereco = Endereco;
    }
    
    public Cliente(String nome) {
        this.nome = nome;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }
    
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
