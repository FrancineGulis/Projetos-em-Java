
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author francine
 */
public class Locacao {

    private final int dias;
    private final double valor;
    private final Calendar data;
    private final Cliente cliente;

    public Locacao(int dias, double valor, Calendar data, Cliente cliente) {
        this.dias = dias;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }
    
    public double getValor(){
        return this.valor;
    }

    public Calendar getData(){
        return this.data;
    } 
        
    public Cliente getCliente(){
        return this.cliente;
    }
    
}
