package BussinessLayer.SubUtilizador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Utilizador here.
 *
 */

public class Utilizador {
    private String codUtil;
    private String password;
    private String email;
    private int pontuacaoGlobal;
    private Boolean isAdmin;
    private Boolean isPremium;

    // --- Empty Constructor ---
    public Utilizador() {
        this.codUtil = null;
        this.password = null;
        this.email = null;
        this.pontuacaoGlobal = 0;
        this.isAdmin = false;
        this.isPremium = false;
    }

    // --- Parameterized Constructor ---
    public Utilizador(String codUtil, String password, String email, int pontuacaoGlobal, Boolean isAdmin, Boolean isPremium){
        this.codUtil = codUtil;
        this.password = password;
        this.email = email;
        this.pontuacaoGlobal = pontuacaoGlobal; 
        this.isAdmin = isAdmin;
        this.isPremium = isPremium;
    }

    // --- Copy Constructor ---
    public Utilizador(Utilizador utilizador) {
        this.codUtil = utilizador.getCodUtil();
        this.password = utilizador.getPassword();
        this.email = utilizador.getEmail();
        this.pontuacaoGlobal = utilizador.getPontuacaoGlobal();
        this.isAdmin = utilizador.getIsAdmin();
        this.isPremium = utilizador.getIsPremium();
    }

    // --- Getters & Setters ---
    public String getCodUtil() {
        return this.codUtil;
    }

    public void setCodUtil(String codUtil) {
        this.codUtil = codUtil;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPontuacaoGlobal() {
        return this.pontuacaoGlobal;
    }

    public void setPontuacaoGlobal(int pontuacaoGlobal) {
        this.pontuacaoGlobal = pontuacaoGlobal;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsPremium() {
        return this.isPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

    // --- Métodos ---

    // Função para validar um email
    // Um email deve começar com um caracter alfanumérico seguido de mais caracteres ou sinais (+, &, * ou -)
    // Um email pode conter um ou mais conjunto de pontos seguido de um ou mais caracteres alfanuméricos ou sinais
    // Um email deve ter um simbolo de arroba (@)
    // Um email deve conter pelo menos um conjunto de um ou mais caracteres alfanuméricos ou hífens (-) seguidos de um ponto
    // Um email deve acabar com pelo menos 2 e no máximo 7 caracteres alfabéticos
    public boolean verificaMail(String email)
    {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern p = Pattern.compile(regex);
        if (email == null)
            return false;

        return p.matcher(email).matches();
    }

    // Função para validar uma palavra passe
    // Uma palavra passe deve conter pelo menos um digito
    // Uma palavra passe deve conter pelo menos uma minúscula
    // Uma palavra passe deve conter pelo menos uma maiúscula
    // Uma palavra passe deve conter pelo menos um caracter especial (@, #, $, %, ! ou ?)
    // Uma palavra passe deve ter entre 6 a 20 caracteres
    public Boolean verificaPass(String password) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!?]).{6,20}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void addPontuacaoGlobal(int pontuacaoCampeonato) {

    }

    
}
