package BussinessLayer.SubCarro;

public class Carro {

    public enum TipoPneus{
        MACIO,DURO,CHUVA;
    }

    public enum ModoMotor{
        AGRESSIVO,CONSERVADOR,NORMAL;
    }

    private double downforce;
    private double fiabilidade;
    private int estadoPneus;
    private String marca;
    private String modelo;
    private int carID;
    private int potenciaICE;
    private int cilindrada;
    private String categoria;
    private TipoPneus tipoPneus;
    private ModoMotor modoMotor;


    public Carro(){
        this.downforce = 0;
        this.fiabilidade = 0;
        this.estadoPneus = 0;
        this.marca = null;
        this.modelo = null;
        this.carID = 0;
        this.potenciaICE = 0;
        this.cilindrada = 0;
        this.categoria = null;
        this.tipoPneus = null;
        this.modoMotor = null;
    }

    public Carro(double downforce,double fiabilidade,int estadoPneus,String marca,String modelo,int carID,int potenciaICE,int cilindrada, String categoria, TipoPneus tipoPneus, ModoMotor modoMotor){
        this.downforce = downforce;
        this.fiabilidade = fiabilidade;
        this.estadoPneus = estadoPneus;
        this.marca = marca;
        this.modelo = modelo;
        this.carID = carID;
        this.potenciaICE = potenciaICE;
        this.cilindrada = cilindrada;
        this.categoria = categoria;
        this.tipoPneus = tipoPneus;
        this.modoMotor = modoMotor;

    }

    public Carro(Carro carro){
        this.downforce = carro.getDownforce();
        this.fiabilidade = carro.getFiabilidade();
        this.estadoPneus = carro.getEstadoPneus();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.carID = carro.getCarID();
        this.potenciaICE = carro.getPotenciaICE();
        this.cilindrada = carro.getCilindrada();
        this.categoria = carro.getCategoria();
        this.tipoPneus = carro.getTipoPneus();
        this.modoMotor = carro.getModoMotor();
    }


    public double getDownforce() {
        return this.downforce;
    }

    public double getFiabilidade() {
        return this.fiabilidade;
    }

    public int getEstadoPneus() {
        return this.estadoPneus;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getCarID() {
        return this.carID;
    }

    public int getPotenciaICE() {
        return this.potenciaICE;
    }

    public TipoPneus getTipoPneus(){
        return this.tipoPneus;
    }

    public ModoMotor getModoMotor(){
        return this.modoMotor;
    }
    
    public int getCilindrada(){
        return this.cilindrada;
    }
    
    public String getCategoria(){
        return this.categoria;
    }

    public void setDownforce(double downforce) {
        this.downforce = downforce;
    }

    public void setFiabilidade(double fiabilidade) {
        this.fiabilidade = fiabilidade;
    }

    public void setEstadoPneus(int estadoPneus) {
        this.estadoPneus = estadoPneus;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public void setPotenciaICE(int potenciaICE) {
        this.potenciaICE = potenciaICE;
    }

    public void setTipoPneus(TipoPneus tipoPneus){
        this.tipoPneus = tipoPneus;
    }

    public void setModoMotor(ModoMotor modoMotor){
        this.modoMotor = modoMotor;
    }

    public boolean verificaPac(){
        return (this.downforce >= 0 && this.downforce <= 1);
    }
}
