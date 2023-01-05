package BussinessLayer.SubCarro;

public class GT extends Carro{
    private int taxaDeterioracao;
    

    public GT(double downforce, double fiabilidade, int estadoPneus, String marca, String modelo, int carID, int potenciaICE, int cilindrada, String categoria, TipoPneus tipoPneus, ModoMotor modoMotor,int taxaDeterioracao) {
        super(downforce, fiabilidade, estadoPneus, marca, modelo, carID, potenciaICE, cilindrada, categoria, tipoPneus, modoMotor);
        this.taxaDeterioracao = taxaDeterioracao;
    }

    public GT(Carro carro, int taxaDeterioracao) {
        super(carro);
        this.taxaDeterioracao = taxaDeterioracao;
    }
 
    public int getTaxaDeterioracao() {
        return taxaDeterioracao;
    }

    public void setTaxaDeterioracao(int taxaDeterioracao) {
        this.taxaDeterioracao = taxaDeterioracao;
    }

    // Função que gera a taxa de deterioração de um automóvel da categoria GT
    public void geraTaxaDeterioracao() {
        Random random = new Random();
        double min = 0.1;
        double max = 0.5;
        double num = min + random.nextDouble() * (max - min);

        this.setTaxaDeterioracao(num);
    }
    




}
