package BussinessLayer.SubSimulacao;

import java.util.HashMap;
import java.util.Map;
import util.Pair;

import BussinessLayer.SubCampeonato.Campeonato;
import BussinessLayer.SubPiloto.Piloto;
import BussinessLayer.SubCarro.Carro;

public class SimulacaoFacade implements ISimulacao{
	private Simulacao simulacao;


	public SimulacaoFacade() {
		this.simulacao = new Simulacao();
	}

	public void simulacao(Campeonato campeonato, Map<String, Pair<Carro, Piloto>> jogadores) {
		this.simulacao.configuraSimulacao(campeonato, jogadores);
		this.simulacao.proximaCorrida();
	}
}
