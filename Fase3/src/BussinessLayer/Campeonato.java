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

    public Campeonato(){
        this.nomeCamp = null;
        this.nrCorridas = 0;
        this.nrMaxParticipantes = 0;
        this.circuitosIntegrantes = new ArrayList<Circuito>();
    }

    public Campeonato(String nomeCamp, int nrCorridas, int nrMaxParticipantes, ArrayList<Circuito> circuitosIntegrantes){
        this.nomeCamp = nomeCamp;
        this.nrCorridas = nrCorridas;
        this.nrMaxParticipantes = nrMaxParticipantes;
        this.circuitosIntegrantes = circuitosIntegrantes;
    }

    public Campeonato(Campeonato campeonato){
        this.nomeCamp = campeonato.getNomeCamp();
        this.nrCorridas = campeonato.getNrCorridas();
        this.nrMaxParticipantes = campeonato.getNrMaxParticipantes();
        this.circuitosIntegrantes = campeonato.getCircuitosIntegrantes();
    }

    public String getNomeCamp(){
        return this.nomeCamp;
    }

    public int getNrCorridas(){
        return this.nrCorridas;
    }

    public int getNrMaxParticipantes(){
        return this.nrMaxParticipantes;
    }

    public ArrayList<Circuito> getCircuitosIntegrantes(){
        //return (ArrayList<Circuito>) new ArrayList<>(this.circuitosIntegrantes);
        return (ArrayList<Circuito>) this.circuitosIntegrantes.stream().collect(Collectors.toList());
    }


}
