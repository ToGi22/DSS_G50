package BussinessLayer.SubCarro;

/**
 * Write a description of class Carro here.
 *
 */

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

    // --- Empty Constructor ---
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

    // --- Parameterized Constructor ---
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

    // --- Copy Constructor ---
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

    // -- Getters & Setters ---
    public double getDownforce() {
        return this.downforce;
    }

    public void setDownforce(double downforce) {
        this.downforce = downforce;
    }

    public double getFiabilidade() {
        return this.fiabilidade;
    }

    public void setFiabilidade(double fiabilidade) {
        this.fiabilidade = fiabilidade;
    }

    public int getEstadoPneus() {
        return this.estadoPneus;
    }

    public void setEstadoPneus(int estadoPneus) {
        this.estadoPneus = estadoPneus;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCarID() {
        return this.carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getPotenciaICE() {
        return this.potenciaICE;
    }

    public void setPotenciaICE(int potenciaICE) {
        this.potenciaICE = potenciaICE;
    }

    public TipoPneus getTipoPneus(){
        return this.tipoPneus;
    }

    public void setTipoPneus(TipoPneus tipoPneus){
        this.tipoPneus = tipoPneus;
    }

    public ModoMotor getModoMotor(){
        return this.modoMotor;
    }

    public void setModoMotor(ModoMotor modoMotor){
        this.modoMotor = modoMotor;
    }
    
    public int getCilindrada(){
        return this.cilindrada;
    }

    public void setCilindrada(int cilindrada){
        this.cilindrada = cilindrada;
    }
    
    public String getCategoria(){
        return this.categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }


    // --- Métodos ---

    public boolean verificaPac(){
        return (this.downforce >= 0 && this.downforce <= 1);
    }
}
