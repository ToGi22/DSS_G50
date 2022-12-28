package BussinessLayer.SubCarro;

public class C2 extends Carro{

    public C2() {
    }

    public C2(double downforce, double fiabilidade, int estadoPneus, String marca, String modelo, int carID, int potenciaICE, int cilindrada, String categoria, TipoPneus tipoPneus, ModoMotor modoMotor) {
        super(downforce, fiabilidade, estadoPneus, marca, modelo, carID, potenciaICE, cilindrada, categoria, tipoPneus, modoMotor);
    }

    public C2(Carro carro) {
        super(carro);
    }

    public boolean verificaCilindrada(){
        return(this.getCilindrada() >= 3000 && this.getCilindrada() <= 5000);
    }
    
    public boolean verificaFiabilidade(){
        return (this.getFiabilidade() > 0.80 && this.getFiabilidade() < 0.95); // fiabilidade dos C2 teórica é 80%, mas quanto maior a cilindrada, mais fiável
    }
    
}
