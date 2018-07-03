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
public class SistemaRh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Analista a = new Analista("Analista",2000.00,"TI","01012016",0, null,"João",44,0,"01011985");
        Vendedor v = new Vendedor(1000.0, "Vendedor", 3000.0, "TI", "01012016", 0, null,"Pedro", 30, 0, "02031987");
        Funcionario[] funcionarios = new Funcionario[2];
        funcionarios[0]=a;
        funcionarios[1]=v;
        Gerente g = new Gerente(funcionarios,"Gerente", 8000.00,"TI","01012016",0, null,"Tiago",12, 0,"2012983");
        
        String[] departamentos = new String[3];
        departamentos[0]= "RH";
        departamentos[1]= "Desenvolvimento";
        departamentos[2]= "Financeiro";
        
        Diretor d = new Diretor(departamentos, "Diretor", 12000.00, "Executivo", "02.03.2010", 0, null, "Jorge", 29, 0, "22.08.1978");
        
        Programador p = new Programador("Programador", 6000.00, "TI", "04.07.2012", 0, null, "Lucas", 102, 0, "10.11.1982");
        
        AuxDeLimpeza ax = new AuxDeLimpeza("Faxineiro", 1200.00, "Recepção", "02.03.2014", 1, null, "Sandra", 89, 1, "10.07.1970");
        
        Funcionario[] imprimeFuncionarios = new Funcionario[6];
        imprimeFuncionarios[0] = a;
        imprimeFuncionarios[1] = v;
        imprimeFuncionarios[2] = g;        
        imprimeFuncionarios[3] = d;   
        imprimeFuncionarios[4] = p;   
        imprimeFuncionarios[5] = ax;           
        
        imprimeRelatorio(imprimeFuncionarios);
        
        //Funcionario f = new Funcionario("Analista", 2000.00,"TI","01012016",0, null,"João",44,0,"01011985");
        
        //POLIMORFISMO: acessar os objetos de formas diferentes.
        //Uma Pessoa p2 está fazendo refência à um Funcionário
        /*O inverso (Funcionário -> Pessoa) não funciona, pois uma pessoa nem sempre é um funcionário, 
        e também Pessoa não contém os atributos de funcionário*/
        //p2 traz apenas os metodos de Pessoa
        //Pessoa p2 = new Funcionario("Analista",2000.00,"TI","01012016",0, null,"João",44,0,"01011985");

    } 
    
    /*public static void imprimeRelatorio(Funcionario[] funcionarios){
        for(Funcionario f: funcionarios){
            System.out.println(f.toString()); *//*POLIMORFISMO: a função toString está na classe Funcionario, e contém o metodo
                                              getBonus. Este metodo se refere ao getBonus do objeto se ele possuir
                                              nos casos Gerente e Vendedor), se não, ele procura o metodo herdado
                                              mais próximo (vendedor herda getBonus de Funcionario).*/
    /*    }
    }*/
    
        public static void imprimeRelatorio(Funcionario[] funcionarios){
        for(Funcionario f: funcionarios){
            System.out.println(f.toString()); /*POLIMORFISMO: a função toString está na classe Funcionario, e contém o metodo
                                              getBonus. Este metodo se refere ao getBonus do objeto se ele possuir
                                              nos casos Gerente e Vendedor), se não, ele procura o metodo herdado
                                              mais próximo (vendedor herda getBonus de Funcionario).*/
        }
    }
}
