/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figgeometricas;

/**
 *
 * @author francine
 */
public class Circunferencia implements Superficie{
    int raio;
    
    public Circunferencia(int raio){
        this.raio = raio;
    }
    
    @Override
    public double area(){
        return Math.PI*(this.raio*this.raio);
    } 
}
