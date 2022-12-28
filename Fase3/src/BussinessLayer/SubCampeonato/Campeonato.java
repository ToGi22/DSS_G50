package BussinessLayer;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Write a description of class Campeonato here.
 *
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

    public void setNomeCamp(String nomeCamp){
        this.nomeCamp = nomeCamp;
    }

    public int getNrCorridas(){
        return this.nrCorridas;
    }

    public void setNrCorridas(int nrCorridas){
        this.nrCorridas = nrCorridas;
    }

    public int getNrMaxParticipantes(){
        return this.nrMaxParticipantes;
    }

    public void setNrMaxParticipantes(int nrMaxParticipantes){
        this.nrMaxParticipantes = nrMaxParticipantes;
    }

    public ArrayList<Circuito> getCircuitosIntegrantes(){
        //return (ArrayList<Circuito>) new ArrayList<>(this.circuitosIntegrantes);
        return (ArrayList<Circuito>) this.circuitosIntegrantes.stream().collect(Collectors.toList());
    }

    public ArrayList<Circuito> setCircuitosIntegrantes(){
        return (ArrayList<Circuito>) this.circuitosIntegrantes.stream().collect(Collectors.toList());
    }

     public void addCircuito(Circuito circuito){
        this.circuitosIntegrantes.add(circuito);
     }

    // --- Métodos ---

    // Função para validar o nome do campeonato
    // O nome deve começar com uma letra
    // O nome deve ter entre 5 a 29 caracteres
    public static boolean verificaNomeCamp(String nomeCamp)
    {

        String regex = "^[A-Za-z]\\w{5,29}$";

        Pattern p = Pattern.compile(regex);

        if (nomeCamp == null) {
            return false;
        }
        Matcher m = p.matcher(nomeCamp);

        return m.matches();
    }

    // Função para validar o nome do circuito
    // O nome deve começar com uma letra
    // O nome deve ter entre 5 a 29 caracteres
    public static boolean verificaNomeCir(String nomeCir)
    {

        String regex = "^[A-Za-z]\\w{5,29}$";

        Pattern p = Pattern.compile(regex);

        if (nomeCir == null) {
            return false;
        }
        Matcher m = p.matcher(nomeCir);

        return m.matches();
    }

}
