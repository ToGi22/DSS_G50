package BussinessLayer.RacingSimulator;

import java.util.Map;
import java.util.stream.Collectors;

import BussinessLayer.SubCampeonato.Campeonato;

public class Simulacao {
	private int corridaAtual;
	private	Map<String,Integer> pontuacaoCamp;
	private Map<String,Integer> afinacoes;
	private int nrMaxAfinacoes;
	private Campeonato campeonato;


	public Simulacao() {
		this.corridaAtual = 0;
		this.pontuacaoCamp = null;
		this.afinacoes = null;
		this.nrMaxAfinacoes = 0;
		this.campeonato = null;
	}

	public Simulacao(int corridaAtual, Map<String,Integer> pontuacaoCamp, Map<String,Integer> afinacoes, int nrMaxAfinacoes, Campeonato campeonato) {
		this.corridaAtual = corridaAtual;
		this.pontuacaoCamp = pontuacaoCamp;
		this.afinacoes = afinacoes;
		this.nrMaxAfinacoes = nrMaxAfinacoes;
		this.campeonato = campeonato;
	}
	
	public Simulacao(Simulacao s) {
		this.corridaAtual = s.getCorridaAtual();
		this.pontuacaoCamp = s.getPontuacaoCamp();
		this.afinacoes = s.getAfinacoes();
		this.nrMaxAfinacoes = s.getNrMaxAfinacoes();
		this.campeonato = s.getCampeonato();
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

}
