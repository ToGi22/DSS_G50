package BussinessLayer.SubCarro;

public class GT extends Carro{

    public GT() {
    }

    public GT(double downforce, double fiabilidade, int estadoPneus, String marca, String modelo, int carID, int potenciaICE, int cilindrada, String categoria, TipoPneus tipoPneus, ModoMotor modoMotor) {
        super(downforce, fiabilidade, estadoPneus, marca, modelo, carID, potenciaICE, cilindrada, categoria, tipoPneus, modoMotor);
    }

    public GT(Carro carro) {
        super(carro);
    }


}
