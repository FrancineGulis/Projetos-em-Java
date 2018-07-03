
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
public class Automovel extends Veiculo{

    private final ModeloAutomovel modelo;

    public Automovel(ModeloAutomovel modelo, double valorDeCompra, Calendar dataDeCompra, int ano, String placa, Categoria categoria, Marca marca, Estado estado, Locacao locacao) {
        super(valorDeCompra, dataDeCompra, ano, placa, categoria, marca, estado, locacao);
        this.modelo = modelo;
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }
    
    
    @Override
    public double getValorDiariaLocacao() {
        switch (this.getCategoria()) {
            case POPULAR:
                return 100.00;
                    
            case INTERMEDIARIO:
                return 300.00;
                         
            case LUXO:
                return 450.00;
                
            default:
                System.out.println("Automóvel sem categoria.");
                return 0.0;
        }
    }
    
}
