package BussinessLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import BussinessLayer.Segmentos;

public class Circuito{
    
    

    private String nomeCir;
    private double distancia;
    private int numeroVoltas;
    private int tempoBox;
    private List<Segmentos> listaSegmentos;

    public Circuito(){
        this.nomeCir = null;
        this.distancia = 0;
        this.numeroVoltas= 0;
        this.tempoBox = 0;
        this.listaSegmentos = new ArrayList<Segmentos>();
    }

    public Circuito(String nomeCir, double distancia, int numeroVoltas, int tempoBox, List<Segmentos> listaSegmentos) {
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

    public List<Segmentos> getListaSegmentos() {
        return (ArrayList<Segmentos>) this.listaSegmentos.stream().collect(Collectors.toList());
    }

    public void addSegmentoEstrada(Segmentos s) {
        this.listaSegmentos.add(s);
    }





}
