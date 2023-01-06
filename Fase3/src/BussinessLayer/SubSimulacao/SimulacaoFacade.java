package BussinessLayer.SubSimulacao;

import java.util.HashMap;
import java.util.Map;
import util.Pair;

import BussinessLayer.SubCampeonato.Campeonato;
import BussinessLayer.SubPiloto.Piloto;
import BussinessLayer.SubCarro.Carro;

public class SimulacaoFacade implements ISimulacao{
	private Simulacao simulacao;


	public SimulacaoFacade(Campeonato campeonato, Map<String, Pair<Carro, Piloto>> jogadores) {
		this.simulacao = new Simulacao(campeonato, jogadores);
	}

	public void simulacao() {
		this.simulacao.iniciaSimulacao();
	}
}
