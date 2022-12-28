package BussinessLayer.SubCarro;

public class GT extends Carro{

    int taxaDeterioracao;
    

    public GT(double downforce, double fiabilidade, int estadoPneus, String marca, String modelo, int carID, int potenciaICE, int cilindrada, String categoria, TipoPneus tipoPneus, ModoMotor modoMotor,int taxaDeterioracao) {
        super(downforce, fiabilidade, estadoPneus, marca, modelo, carID, potenciaICE, cilindrada, categoria, tipoPneus, modoMotor);
        this.taxaDeterioracao = taxaDeterioracao;
    }

    public GT(Carro carro,int taxaDeterioracao) {
        super(carro);
        this.taxaDeterioracao = taxaDeterioracao;
    }
 
    public int getTaxaDeterioracao() {
        return taxaDeterioracao;
    }

    public void setTaxaDeterioracao(int taxaDeterioracao) {
        this.taxaDeterioracao = taxaDeterioracao;
    }

    public int decrementaFiabilidadeGT(int nVoltas,int fiabilidade,int taxaDeterioracao){ //taxa deterioracao hardcoded
        while (nVoltas >= 0){
            fiabilidade = fiabilidade - (taxaDeterioracao * fiabilidade);
        }
        return fiabilidade;
    }




}
