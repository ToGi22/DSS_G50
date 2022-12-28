package BussinessLayer;

public class Piloto {
    private String nomePiloto;
    private double cts;
    private double sva;
    private String nacionalidade;

    public Piloto() {
        this.nomePiloto = null;
        this.cts = 0;
        this.sva = 0;
        this.nacionalidade = null;
    }

    public Piloto(String nomePiloto, double cts, double sva, String nacionalidade) {
        this.nomePiloto = nomePiloto;
        this.cts = cts;
        this.sva = sva;
        this.nacionalidade = nacionalidade;
    }

    public Piloto(Piloto piloto) {
        this.nomePiloto = piloto.getNomePiloto();
        this.cts = piloto.getCts();
        this.sva = piloto.getSva();
        this.nacionalidade = piloto.getNacionalidade();
    }
    
    public String getNomePiloto() {
        return this.nomePiloto;
    }
    public double getCts() {
        return this.cts;
    }
    public double getSva() {
        return this.sva;
    }
    public String getNacionalidade() {
        return this.nacionalidade;
    }
    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }
    public void setCts(double cts) {
        this.cts = cts;
    }
    public void setSva(double sva) {
        this.sva = sva;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
