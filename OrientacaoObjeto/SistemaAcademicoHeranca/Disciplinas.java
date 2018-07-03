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
public class Disciplinas {
    
    private String[] disciplinas={"Aa","Ab","Ac","Ad","Ae"};    

    public String[] getDisciplinas() {
        return disciplinas;
    }   

    @Override
    public String toString() {
        return "Disciplinas: " + disciplinas[0] +", "+ disciplinas[1] +", "+ disciplinas[2] +", "+ disciplinas[3] +", "+ disciplinas[4];
    }

   
}
