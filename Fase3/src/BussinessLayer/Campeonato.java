package BussinessLayer;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Write a description of class Campeonato here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Campeonato{
    private String nomeCamp;
    private int nrCorridas;
    private int nrMaxParticipantes;
    private List<Circuito> circuitosIntegrantes;

    // --- Empty Constructor ---
    public Campeonato(){
        this.nomeCamp = null;
        this.nrCorridas = 0;
        this.nrMaxParticipantes = 0;
        this.circuitosIntegrantes = new ArrayList<Circuito>();
    }

    // --- Parameterized Constructor ---
    public Campeonato(String nomeCamp, int nrCorridas, int nrMaxParticipantes, ArrayList<Circuito> circuitosIntegrantes){
        this.nomeCamp = nomeCamp;
        this.nrCorridas = nrCorridas;
        this.nrMaxParticipantes = nrMaxParticipantes;
        this.circuitosIntegrantes = circuitosIntegrantes;
    }

    // --- Copy Constructor ---
    public Campeonato(Campeonato campeonato){
        this.nomeCamp = campeonato.getNomeCamp();
        this.nrCorridas = campeonato.getNrCorridas();
        this.nrMaxParticipantes = campeonato.getNrMaxParticipantes();
        this.circuitosIntegrantes = campeonato.getCircuitosIntegrantes();
    }

    // --- Getters & Setters ---
    public String getNomeCamp(){
        return this.nomeCamp;
    }

    public String setNomeCamp(String nomeCamp){
        this.nomeCamp = nomeCamp;
    }

    public int getNrCorridas(){
        return this.nrCorridas;
    }

    public int setNrCorridas(int nrCorridas){
        this.nrCorridas = nrCorridas;
    }

    public int getNrMaxParticipantes(){
        return this.nrMaxParticipantes;
    }

    public int setNrMaxParticipantes(int nrMaxParticipantes){
        this.nrMaxParticipantes = nrMaxParticipantes;
    }

    public ArrayList<Circuito> getCircuitosIntegrantes(){
        //return (ArrayList<Circuito>) new ArrayList<>(this.circuitosIntegrantes);
        return (ArrayList<Circuito>) this.circuitosIntegrantes.stream().collect(Collectors.toList());
    }

    public ArrayList<Circuito> setCircuitosIntegrantes(){
        return (ArrayList<Circuito>) this.circuitosIntegrantes.stream().collect(Collectors.toList());
    }

    // public void addCircuito(Circuito circuito){
    //    this.circuitosIntegrantes.add(circuito.clone());
    // }

    // --- Métodos ---


}
