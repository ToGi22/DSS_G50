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
	}
}
