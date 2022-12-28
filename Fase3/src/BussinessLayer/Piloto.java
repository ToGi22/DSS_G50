package BussinessLayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Piloto here.
 *
 */

public class Piloto {
    private String nomePiloto;
    private double cts;
    private double sva;
    private String nacionalidade;

    // --- Empty Constructor ---
    public Piloto() {
        this.nomePiloto = null;
        this.cts = 0;
        this.sva = 0;
        this.nacionalidade = null;
    }

    // --- Parameterized Constructor ---
    public Piloto(String nomePiloto, double cts, double sva, String nacionalidade) {
        this.nomePiloto = nomePiloto;
        this.cts = cts;
        this.sva = sva;
        this.nacionalidade = nacionalidade;
    }

    // --- Copy Constructor ---
    public Piloto(Piloto piloto) {
        this.nomePiloto = piloto.getNomePiloto();
        this.cts = piloto.getCts();
        this.sva = piloto.getSva();
        this.nacionalidade = piloto.getNacionalidade();
    }

    // --- Getters & Setters ---
    public String getNomePiloto() {
        return this.nomePiloto;
    }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public double getCts() {
        return this.cts;
    }

    public void setCts(double cts) {
        this.cts = cts;
    }

    public double getSva() {
        return this.sva;
    }

    public void setSva(double sva) {
        this.sva = sva;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    // --- Métodos ---

    // Função para verificar a perícia CTS (Chuva vs Tempo Seco)
    public boolean verificaCts(){
        return (this.getCts() >= 0 && this.getCts() <= 1);
    }

    // Função para verificar a perícia SVA (Segurança vs Agressividade)
    public boolean verificaSva(){
        return (this.getSva() >= 0 && this.getSva() <= 1);
    }

    // Função para validar o nome do piloto
    // O nome deve começar com uma letra
    // O nome deve ter entre 5 a 29 caracteres
    public static boolean verificaPiloto(String nomePiloto)
    {

        String regex = "^[A-Za-z]\\w{5,29}$";

        Pattern p = Pattern.compile(regex);

        if (nomePiloto == null) {
            return false;
        }
        Matcher m = p.matcher(nomePiloto);

        return m.matches();
    }
}
