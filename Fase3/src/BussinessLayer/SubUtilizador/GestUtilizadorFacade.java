package BussinessLayer.SubUtilizador;

public class UtilizadorFacade implements IUtilizador{
    private Map<String,Jogador> utilizadores;

    public GestUtilizadores(){
        this.utilizadores = UtilizadorDAO.getInstance();
    }

    // Função que regista um objeto utilizador na base de dados
    public void registaUtilizador(String codUtil, String password, String email, boolean isPremium){
        Utilizador util = new Utilizador(codUtil, password, email, isPremium);
        this.utilizadores.put(util.getCodUtil(), util);
    }

    // Função que regista um administrador
    public void registaAdmin(String codUtil){
        Utilizador util = utilizadores.get(CodUtil);
        util.setIsAdmin(True);
    }

    /** Função que autentica um utilizador
    * verifica se as passwords coincidem
    */
    public boolean autenticaUtilizador(String codUtil, String password){
        Utilizador util = utilizadores.get(CodUtil);
        return util.getPassword().equals(password);
    }

     // --- Métodos ---

    /** Função para validar um email
    * Um email deve começar com um caracter alfanumérico seguido de mais caracteres ou sinais (+, &, * ou -)
    * Um email pode conter um ou mais conjunto de pontos seguido de um ou mais caracteres alfanuméricos ou sinais
    * Um email deve ter um simbolo de arroba (@)
    * Um email deve conter pelo menos um conjunto de um ou mais caracteres alfanuméricos ou hífens (-) seguidos de um ponto
    */ Um email deve acabar com pelo menos 2 e no máximo 7 caracteres alfabéticos
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

    /** Função para validar uma palavra passe
    * Uma palavra passe deve conter pelo menos um digito
    * Uma palavra passe deve conter pelo menos uma minúscula
    * Uma palavra passe deve conter pelo menos uma maiúscula
    * Uma palavra passe deve conter pelo menos um caracter especial (@, #, $, %, ! ou ?)
    */ Uma palavra passe deve ter entre 6 a 20 caracteres
    public Boolean verificaPass(String password) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!?]).{6,20}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Função que atualiza a pontuação global de um utilizador
    public void addPontuacaoGlobal(String codUtil, int pontuacaoCampeonato) {
        int pontuacao = utilizadores.get(CodUtil).getPontuacaoGlobal();
        pontuacao += pontuacaoCampeonato;
        utilizadores.get(CodUtil).setPontuacaoGlobal(pontuacao);
    }

    // Função que verifica se não há nomes repetidos na lista de utilizadores
    public boolean verificaUtilizador(String codUtil){
        return utilizadores.containsKey(codUtil);
    }
}
