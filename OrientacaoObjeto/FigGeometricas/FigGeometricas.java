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
public class FigGeometricas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Superficie q = new Quadrado(40);
        Superficie c = new Circunferencia(5);
        
        System.out.println("Area do quadrado: " + q.area());
        //System.out.println("Perímetro do quadrado: " + q.perimetroQuadrado());
        System.out.println("Area do circulo: " + c.area());        
    }
}
