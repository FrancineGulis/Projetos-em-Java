
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
public class Motocicleta extends Veiculo{
    
    final ModeloMotocicleta modelo;

    public Motocicleta(ModeloMotocicleta modelo, double valorDeCompra, Calendar dataDeCompra, int ano, String placa, Categoria categoria, Marca marca, Estado estado, Locacao locacao) {
        super(valorDeCompra, dataDeCompra, ano, placa, categoria, marca, estado, locacao);
        this.modelo = modelo;
    }

    public ModeloMotocicleta getModelo() {
        return modelo;
    }

    
    @Override
    public double getValorDiariaLocacao() {
        switch (this.getCategoria()) {
            case POPULAR:
                return 70.00;
                    
            case INTERMEDIARIO:
                return 200.00;
                         
            case LUXO:
                return 350.00;
                
            default:
                System.out.println("Motocicleta sem categoria.");
                return 0.0;
        }
    }
    
}
