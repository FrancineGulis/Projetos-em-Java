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
public class Quadrado implements Superficie{
    int lado;
    
    public Quadrado(int lado){
        this.lado = lado;
    }
    @Override
    public double area(){
        return this.lado*this.lado;
    } 
    
    public double perimetroQuadrado(){
        return this.lado*4;
    }
}
