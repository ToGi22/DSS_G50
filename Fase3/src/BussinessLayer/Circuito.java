package BussinessLayer;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Circuito{
    private String nomeCir;
    private double distancia;
    private int numeroVoltas;
    private int tempoBox;
    private ArrayList<SegmentoEstrada> listaSegmentos;
	private enum SegmentoEstrada{
		CURVA,
		RETA,
		CHICANE
	}

    private enum SegmentoEstrada{
        CURVA,
        RETA,
        CHICANE
    }

    public Circuito(){
        this.nomeCir = null;
        this.distancia = 0;
        this.numeroVoltas= 0;
        this.tempoBox = 0;
        this.listaSegmentos = new ArrayList<SegmentoEstrada>();
    }

<<<<<<< HEAD
	public Circuito(String nomeCir, double distancia, int numeroVoltas, int tempoBox, ArrayList<SegmentoEstrada> listaSegmentos) {
		this.nomeCir = nomeCir;
		this.distancia = distancia;
		this.numeroVoltas = numeroVoltas;
		this.tempoBox = tempoBox;
		this.listaSegmentos = listaSegmentos;
	}

	public Circuito(Circuito c) {
		this.nomeCir = c.getNomeCir();
		this.distancia = c.getDistancia();
		this.numeroVoltas = c.getNumeroVoltas();
		this.tempoBox = c.getTempoBox();
		this.listaSegmentos = c.getListaSegmentos();
	}

	public String getNomeCir() {
		return this.nomeCir;
	}

	public void setNomeCir(String nomeCir) {
		this.nomeCir = nomeCir;
	}

	public double getDistancia() {
		return this.distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public int getNumeroVoltas() {
		return this.numeroVoltas;
	}

	public void setNumeroVoltas(int numeroVoltas) {
		this.numeroVoltas = numeroVoltas;
	}

	public int getTempoBox() {
		return this.tempoBox;
	}

	public void setTempoBox(int tempoBox) {
		this.tempoBox = tempoBox;
	}

	public ArrayList<SegmentoEstrada> getListaSegmentos() {
		return (ArrayList<SegmentoEstrada>) this.listaSegmentos.stream().collect(Collectors.toList());
	}
=======
    public Circuito(String nomeCir, double distancia, int numeroVoltas, int tempoBox, List<SegmentoEstrada> listaSegmentos) {
        this.nomeCir = nomeCir;
        this.distancia = distancia;
        this.numeroVoltas = numeroVoltas;
        this.tempoBox = tempoBox;
        this.listaSegmentos = listaSegmentos;
    }

    public Circuito(Circuito circuito){
        this.nomeCir = circuito.getNomeCir();
        this.distancia = circuito.getDistancia();
        this.numeroVoltas = circuito.getNumeroVoltas(); 
        this.tempoBox = circuito.getTempoBox();
        this.listaSegmentos = circuito.getListaSegmentos();
    }

    public String getNomeCir() {
        return this.nomeCir;
    }

    public void setNomeCir(String nomeCir) {
        this.nomeCir = nomeCir;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getNumeroVoltas() {
        return this.numeroVoltas;
    }

    public void setNumeroVoltas(int numeroVoltas) {
        this.numeroVoltas = numeroVoltas;
    }

    public int getTempoBox() {
        return this.tempoBox;
    }

    public void setTempoBox(int tempoBox) {
        this.tempoBox = tempoBox;
    }

    public List<SegmentoEstrada> getListaSegmentos() {
        return (ArrayList<SegmentoEstrada>) this.listaSegmentos.stream().collect(Collectors.toList());
    }

    public void addSegmentoEstrada(SegmentoEstrada s) {
        this.listaSegmentos.add(s);
    }
>>>>>>> 84bdeb5248858a9a99182f0e1076ce3fc24e3d99

	public void setListaSegmentos(ArrayList<SegmentoEstrada> listaSegmentos) {
		this.listaSegmentos = listaSegmentos;
	}
}
