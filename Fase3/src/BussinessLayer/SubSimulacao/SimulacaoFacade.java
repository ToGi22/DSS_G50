package BussinessLayer.SubSimulacao;

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

	public Map<String,Integer> simulacao(Campeonato campeonato, Map<String, Pair<Carro, Piloto>> jogadores) {
		this.simulacao.configuraSimulacao(campeonato, jogadores);
		
		for (int i = 0; i < this.simulacao.getCampeonato().getNrCorridas(); i++) {
			this.simulacao.proximaCorrida();
			
		}

		return null;
	}
}
