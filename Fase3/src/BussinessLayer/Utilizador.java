package BussinessLayer;

public class Utilizador {
    private String codUtil;
    private String password;
    private String email;
    private int pontuacaoGlobal;
    private Boolean isAdmin;
    private Boolean isPremium;

    public Utiilizador() {
        this.codUtil = null;
        this.password = null;
        this.email = null;
        this.pontuacaoGlobal = 0;
        this.isAdmin = false;
        this.isPremium = false;
    }

    public Utilizador(String codUtil, String password, String email, int pontuacaoGlobal, Boolean isAdmin, Boolean isPremium){
        this.codUtil = codUtil;
        this.password = password;
        this.email = email;
        this.pontuacaoGlobal = pontuacaoGlobal; 
        this.isAdmin = isAdmin;
        this.isPremium = isPremium;
    }

    public Utiilizador(Utilizador utilizador) {
        this.codUtil = utilizador.getCodUtil();
        this.password = utilizador.getPassword();
        this.email = utilizador.getEmail();
        this.pontuacaoGlobal = utilizador.getPontuacaoGlobal();
        this.isAdmin = utilizador.getIsAdmin();
        this.isPremium = utilizador.getIsPremium();
    }

    public String getCodUtil() {
        return this.codUtil;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public int getPontuacaoGlobal() {
        return this.pontuacaoGlobal;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public Boolean getIsPremium() {
        return this.isPremium;
    }

    public void setCodUtil(String codUtil) {
        this.codUtil = codUtil;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPontuacaoGlobal(int pontuacaoGlobal) {
        this.pontuacaoGlobal = pontuacaoGlobal;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

}
