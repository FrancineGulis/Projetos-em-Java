
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
abstract class Veiculo implements VeiculoI{
    
    private double valorDeCompra;
    private Calendar dataDeCompra;
    private int ano;
    // Usar máscara para a inserção da placa - MaskFormatter formatter = new MaskFormatter("UUU-####")
    //https://docs.oracle.com/javase/7/docs/api/javax/swing/text/MaskFormatter.html
    private String placa;
    private Categoria categoria;
    private Marca marca;
    private Estado estado;
    private Locacao locacao;

    public Veiculo(double valorDeCompra, Calendar dataDeCompra, int ano, String placa, Categoria categoria, Marca marca, Estado estado, Locacao locacao) {
        this.valorDeCompra = valorDeCompra;
        this.dataDeCompra = dataDeCompra;
        this.ano = ano;
        this.placa = placa;
        this.categoria = categoria;
        this.marca = marca;
        this.estado = estado;
        this.locacao = locacao;
    }
    
     /*Muda estado para LOCADO. Cria uma instância de Locacao e armazena no atributo
     locacao. Chama o método getValorDiariaLocacao para calcular o valor da locação.*/
    @Override
    public void locar(int dias, Calendar data, Cliente cliente){
        this.estado = Estado.LOCADO;
        locacao = new Locacao(dias, this.getValorDiariaLocacao(), data, cliente);
    }

    //Muda estado para VENDIDO e não pode mais ser alugado
    @Override
    public void vender(){
        this.estado = Estado.VENDIDO;
        locacao = null;
    }
    
    //Muda estado para DISPONIVEL
    @Override
    public void devolver(){
        this.estado = Estado.DISPONIVEL;
        locacao = null;
    }

    @Override
    public Estado getEstado(){
        return this.estado;
    }

    @Override
    public Marca getMarca(){
        return this.marca;
    }

    @Override
    public Categoria getCategoria(){
        return this.categoria;
    }

    @Override
    public Locacao getLocacao(){
        return this.locacao;
    }

    @Override
    public String getPlaca(){
        return this.placa;
    }

    @Override
    public int getAno() {
        return ano;
    }
    
    @Override
    public double getValorParaVenda(){
        Calendar esteAno = Calendar.getInstance(); 
        int idadeVeiculoEmAnos = esteAno.get(Calendar.YEAR) - this.getAno();
        double valorParaVenda = valorDeCompra - idadeVeiculoEmAnos * 0.15 * valorDeCompra;
        if( (valorParaVenda < (valorDeCompra*0.1)) || (valorParaVenda < 0) )
            valorParaVenda = valorDeCompra * 0.1;
        return valorParaVenda; 
    }
    
    //Método que será abstrato na classe Veiculo
    @Override
    abstract public double getValorDiariaLocacao();
    
}
