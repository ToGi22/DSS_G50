package UI;

import java.util.Scanner;

import BussinessLayer.SubCampeonato.GestCampeonatoFacade;
import BussinessLayer.SubCampeonato.ICampeonato;
import BussinessLayer.SubCarro.GestCarroFacade;
import BussinessLayer.SubCarro.ICarros;
import BussinessLayer.SubPiloto.GestPilotoFacade;
import BussinessLayer.SubPiloto.IPiloto;
import BussinessLayer.SubSimulacao.ISimulacao;
import BussinessLayer.SubSimulacao.SimulacaoFacade;
import BussinessLayer.SubUtilizador.GestUtilizadorFacade;
import BussinessLayer.SubUtilizador.IUtilizador;
import BussinessLayer.SubUtilizador.Utilizador;

/**
 * TextUI
 */
public class TextUI {
	private ICampeonato modelCampeonato;
	private ICarros modelCarro;
	private IPiloto modelPiloto;
	private IUtilizador modeUtilizador;
	private ISimulacao modeSimulacao;

	// Scanner para leitura
	private Scanner scin;

	public TextUI() {
		this.modelCampeonato = new GestCampeonatoFacade();
		this.modelCarro = new GestCarroFacade();
		this.modelPiloto = new GestPilotoFacade();
		this.modeUtilizador = new GestUtilizadorFacade();
		this.modeSimulacao = new SimulacaoFacade();
		this.scin = new Scanner(System.in);
	}

	public void run() {
		boolean logged = false;
		Menu menu = new Menu(new String[]{
			"Registar-se",
			"Autenticar-se",
			"Adicionar Circuito",
			"Adicionar Piloto",
			"Adicionar Campeonato",
			"Adicionar Carro",
		});
		menu.setPreCondition(1,()-> !logged);
        menu.setPreCondition(2,()-> !logged);

		menu.setHandler(1,()->{
            int tom = -1;
            for (int i = 0; tom < 0 || tom > 2; i++) {
                if (i > 0)
                    System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                System.out.println("Selecione o tipo de utilizador que pretende");
                System.out.println("1-> Jogador");
                System.out.println("2-> Administrador");
                System.out.println("0-> Terminar Operação");
                tom = scin.nextInt();
                if (tom!=0) {
                    System.out.println("Insira o seu nome de utilizador!");
                    String username = scin.nextLine();
                    System.out.println("Insira a sua password!");
                    String password = scin.nextLine();
                    if (tom==1) {
                        Utilizador.registaUtil(username, password);
                    }
                    else {
                        Utilizador.addAdministrador(username,password);
                    }
                }
            }
        });
	}

	
}
