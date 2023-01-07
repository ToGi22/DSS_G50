package BussinessLayer.SubCarro;

import java.util.Random;

public class GT extends Carro{
    private double taxaDeterioracao;
    

    public GT(double downforce, double fiabilidade, int estadoPneus, String marca, String modelo, 
                int carID, int potenciaICE, int cilindrada, String categoria, TipoPneus tipoPneus, 
                ModoMotor modoMotor,double taxaDeterioracao) {

        super(downforce, fiabilidade, estadoPneus, marca, modelo, carID, 
                potenciaICE, cilindrada, categoria, tipoPneus, modoMotor);

        this.taxaDeterioracao = taxaDeterioracao;
    }

    public GT(Carro carro, double taxaDeterioracao) {
        super(carro);
        this.taxaDeterioracao = taxaDeterioracao;
    }

    public double getTaxaDeterioracao() {
        return taxaDeterioracao;
    }

    public void setTaxaDeterioracao(double taxaDeterioracao) {
        this.taxaDeterioracao = taxaDeterioracao;
    }

    // Função que gera a taxa de deterioração de um automóvel da categoria GT
    public void geraTaxaDeterioracao() {
        Random random = new Random();
        double min = 0.0035;
        double max = 0.0075;
        double num = min + random.nextDouble() * (max - min);

        this.setTaxaDeterioracao(num);
    }

}
