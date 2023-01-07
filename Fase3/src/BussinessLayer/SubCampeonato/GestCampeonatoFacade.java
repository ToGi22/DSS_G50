package BussinessLayer.SubCampeonato;


import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DataLayer.CampeonatoDAO;
import DataLayer.CircuitoDAO;

public class GestCampeonatoFacade implements ICampeonato{
    private Map<String, Campeonato> campeonatos;
    private Map<String, Circuito> circuitos;
    

    public GestCampeonatoFacade(){
        this.campeonatos = CampeonatoDAO.getInstance();
        this.circuitos = CircuitoDAO.getInstance();
    }

    public void registaCircuito(String nomeCir, double distancia, int numeroVoltas, ArrayList<Segmentos> listaSegmentos){
        Circuito c = new Circuito(nomeCir, distancia, numeroVoltas, 0, listaSegmentos); // TO-DO falta definir como vamos fazer com o tempoBox
        this.circuitos.put(c.getNomeCir(),c);
    }

    public void registaCampeonato(String nomeCamp, int nrMaxParticipantes, ArrayList<String> listaCircuitosIntegrantes){
        ArrayList<Circuito>circuitosIntegrantes = new ArrayList<>();
        for (String m : listaCircuitosIntegrantes){
            Circuito circuito = this.circuitos.get(m);
            circuitosIntegrantes.add(circuito);
        }
        Campeonato camp = new Campeonato(nomeCamp, nrMaxParticipantes, circuitosIntegrantes);
        this.campeonatos.put(camp.getNomeCamp(), camp);
    }

    /**
    public Collection<Circuito> getCircuitos() {
        return this.circuitos.values();
    }

    public Campeonato getCampeonato(String nome){
        Campeonato c = new Campeonato();
        c = this.campeonatos.get(nome);
        ArrayList <Circuito> lCirc = new ArrayList<>();
        for(Circuito m : c.getLc().values()){
            lCirc.add(this.circuitos.get(m.getnomeCir()));
        }
        return  new Campeonato(nome,lCirc);
    }
    */

    // --- Métodos ---

    // Função para validar o nome do campeonato
    // O nome deve começar com uma letra
    // O nome deve ter entre 5 a 29 caracteres
    public static boolean validaNomeCamp(String nomeCamp)
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
    public static boolean validaNomeCir(String nomeCir)
    {

        String regex = "^[A-Za-z]\\w{5,29}$";

        Pattern p = Pattern.compile(regex);

        if (nomeCir == null) {
            return false;
        }
        Matcher m = p.matcher(nomeCir);

        return m.matches();
    }

    // Função que verifica se não há nomes repetidos na lista de campeonatos
    public boolean verificaNomeCamp(String nomeCamp){
        return campeonatos.containsKey(nomeCamp);
    }

    // Função que verifica se não há nomes repetidos na lista de circuitos
    public boolean verificaNomeCir(String nomeCir){
        return circuitos.containsKey(nomeCir);
    }

}
