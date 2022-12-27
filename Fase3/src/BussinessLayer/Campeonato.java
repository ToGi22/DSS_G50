package BussinessLayer;

import java.util.List;
import java.util.ArrayList;

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
}
