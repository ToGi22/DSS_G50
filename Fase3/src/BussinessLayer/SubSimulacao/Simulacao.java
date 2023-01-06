package BussinessLayer.SubSimulacao;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import BussinessLayer.SubCampeonato.Campeonato;
import BussinessLayer.SubCarro.Carro;
import BussinessLayer.SubPiloto.Piloto;
import util.Pair;

public class Simulacao {
	private int corridaAtual;
	private	Map<String,Integer> pontuacaoCamp;
	private Map<String,Integer> afinacoes;
	private int nrMaxAfinacoes;
	private Campeonato campeonato;
	private Map<String,Pair<Carro,Piloto>> jogadores;
	private Corrida corrida;

	
	public Simulacao() {
		this.corridaAtual = 0;
		this.pontuacaoCamp = new HashMap<>();
		this.afinacoes = new HashMap<>();
		this.nrMaxAfinacoes = 0;
		this.campeonato = null;
		this.jogadores = new HashMap<>();
		this.corrida = new Corrida();
	}

	public Simulacao(Campeonato campeonato, Map<String,Pair<Carro,Piloto>> jogadores){
		this.corridaAtual = 0;
		this.pontuacaoCamp = new HashMap<>();
		for(Map.Entry<String,Pair<Carro,Piloto>> entry : jogadores.entrySet())
		this.pontuacaoCamp.put(entry.getKey(), 0);
		this.afinacoes = new HashMap<>();
		for(Map.Entry<String,Pair<Carro,Piloto>> entry : jogadores.entrySet())
			this.afinacoes.put(entry.getKey(), 0);
			this.nrMaxAfinacoes = 2*(campeonato.getNrCorridas()/3);
			this.campeonato = campeonato;
		this.jogadores = jogadores;
		this.corrida = new Corrida();
	}

	public Simulacao(int corridaAtual, Map<String,Integer> pontuacaoCamp, Map<String,Integer> afinacoes,
	int nrMaxAfinacoes, Campeonato campeonato, Map<String,Pair<Carro,Piloto>> jogadores, Corrida corrida) {
		this.corridaAtual = corridaAtual;
		this.pontuacaoCamp = pontuacaoCamp;
		this.afinacoes = afinacoes;
		this.nrMaxAfinacoes = nrMaxAfinacoes;
		this.campeonato = campeonato;
		this.jogadores = jogadores;
		this.corrida = corrida;
	}

	public Simulacao(Simulacao s) {
		this.corridaAtual = s.getCorridaAtual();
		this.pontuacaoCamp = s.getPontuacaoCamp();
		this.afinacoes = s.getAfinacoes();
		this.nrMaxAfinacoes = s.getNrMaxAfinacoes();
		this.campeonato = s.getCampeonato();
		this.jogadores = s.getJogadores();
		this.corrida = s.getCorrida();
	}

	public int getCorridaAtual() {
		return this.corridaAtual;
	}

	public void setCorridaAtual(int corridaAtual) {
		this.corridaAtual = corridaAtual;
	}

	public Map<String,Integer> getPontuacaoCamp() {
		return (Map<String, Integer>) this.pontuacaoCamp.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
	}

	public void setPontuacaoCamp(Map<String,Integer> pontuacaoCamp) {
		this.pontuacaoCamp = pontuacaoCamp;
	}

	public Map<String,Integer> getAfinacoes() {
		return (Map<String, Integer>) this.afinacoes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
	}

	public void setAfinacoes(Map<String,Integer> afinacoes) {
		this.afinacoes = afinacoes;
	}

	public int getNrMaxAfinacoes() {
		return this.nrMaxAfinacoes;
	}

	public void setNrMaxAfinacoes(int nrMaxAfinacoes) {
		this.nrMaxAfinacoes = nrMaxAfinacoes;
	}

	public Campeonato getCampeonato() {
		return new Campeonato(this.campeonato);
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Map<String,Pair<Carro,Piloto>> getJogadores() {
		return this.jogadores;
	}
	
	public void setJogadores(Map<String,Pair<Carro,Piloto>> jogadores) {
		this.jogadores = jogadores;
	}

	public Corrida getCorrida() {
		return this.corrida;
	}
	
	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

	public void iniciaSimulacao() {
		
	}
}
