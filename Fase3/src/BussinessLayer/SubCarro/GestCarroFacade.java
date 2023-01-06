package BussinessLayer.SubCarro;

import java.util.Map;

import DataLayer.CarroDAO;

public class GestCarroFacade implements ICarros {
    private Map<Integer, Carro> carros;

    public GestCarroFacade(){
        this.carros = CarroDAO.getInstance();
    }

    // Função que regista um objeto carro da categoria C1 hibrido na base de dados
    public void registaC1Hibrido(String marca, String modelo, double downforce, // cilindrada dos C1 é sempre 6000
                                int potenciaICE, int PotenciaE){
        int carID = carros.size();
        String categoria = "C1H";
        int cilindrada = 6000;
        C1H c1 = new C1H(downforce, 0.0, 100, marca, modelo, carID,
                        potenciaICE, cilindrada, categoria, null, null, PotenciaE);
        c1.geraFiabilidade();
        this.carros.put(c1.getCarID(), c1);
    }

    // Função que regista um objeto carro da categoria C1 na base de dados
    public void registaC1(String marca, String modelo, double downforce, int potenciaICE){
        int carID = carros.size();
        String categoria = "C1";
        int cilindrada = 6000;
        C1 c1 = new C1(downforce, 0.0, 100, marca, modelo, carID,
                    potenciaICE, cilindrada, categoria, null, null);
        c1.geraFiabilidade();
        this.carros.put(c1.getCarID(), c1);
    }

    // Função que regista um objeto carro da categoria C2 hibrido na base de dados
    public void registaC2Hibrido(String marca, String modelo, int cilindrada,
                                double downforce, int potenciaICE, int PotenciaE){
        int carID = carros.size();
        String categoria = "C2H";
        C2H c2 = new C2H(downforce, 0.0, 100, marca, modelo, carID, 
                        potenciaICE, cilindrada, categoria, null, null, PotenciaE);
        c2.geraFiabilidade();
        this.carros.put(c2.getCarID(), c2);
    }

    // Função que regista um objeto carro da categoria C2 na base de dados
    public void registaC2(String marca, String modelo, int cilindrada, int downforce, int potenciaICE){
        int carID = carros.size();
        String categoria = "C2";
        C2 c2 = new C2(downforce, 0.0, 100, marca, modelo, carID, 
                        potenciaICE, cilindrada, categoria, null, null);
        c2.geraFiabilidade();
        this.carros.put(c2.getCarID(), c2);
    }

    // Função que regista um objeto carro da categoria SC na base de dados
    public void registaSC(String marca, String modelo, int cilindrada, int downforce, int potenciaICE){
        int carID = carros.size();
        String categoria = "SC";
        SC sc = new SC(downforce, 0.0, 100, marca, modelo, carID, 
                        potenciaICE, cilindrada, categoria, null, null);
        sc.geraFiabilidade();
        this.carros.put(sc.getCarID(), sc);
    }

    // Função que regista um objeto carro da categoria GT na base de dados
    public void registaGT(String marca, String modelo, int cilindrada, int downforce, int potenciaICE){
        int carID = carros.size();
        String categoria = "GT";
        GT gt = new GT(downforce, 0.0, 100, marca, modelo, carID, potenciaICE, 
                        cilindrada, categoria, null, null, 0.0);
        gt.geraTaxaDeterioracao();
        gt.geraFiabilidade();
        this.carros.put(gt.getCarID(), gt);
    }

    // Função que regista um objeto carro da categoria GT hibrido na base de dados
    public void registaGTHibrido(String marca, String modelo, int cilindrada, int downforce, int potenciaICE, int potenciaE){
        int carID = carros.size();
        String categoria = "GTH";
        GTH gt = new GTH(downforce, 0.0, 100, marca, modelo, carID, potenciaICE, 
                        cilindrada, categoria, null, null, 0.0, potenciaE);
        gt.geraTaxaDeterioracao();
        gt.geraFiabilidade();
        this.carros.put(gt.getCarID(), gt);
    }

    // --- Métodos ---
    
    /** Função responsável por decrementar a fiabilidade dos carros da categoria GT consoante um parâmetro 
    * @param taxaDeterioracao 
    */
    public int decrementaFiabilidadeGT(int nVoltas, int fiabilidade, int taxaDeterioracao){ //taxa deterioracao hardcoded
        while (nVoltas >= 0){
            fiabilidade = fiabilidade - (taxaDeterioracao * fiabilidade);
        }
        return fiabilidade;
    }
}
