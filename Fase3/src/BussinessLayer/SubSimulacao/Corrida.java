package BussinessLayer.SubSimulacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import BussinessLayer.SubCampeonato.Circuito;
import BussinessLayer.SubCampeonato.Segmentos;
import BussinessLayer.SubCampeonato.Segmentos.SegmentoEstrada;
import BussinessLayer.SubCarro.Carro;
import BussinessLayer.SubPiloto.Piloto;
import util.Pair;

public class Corrida {
	public enum Clima{
		SOLARENGO,
		CHUVA;
	}

	private int voltaAtual;
	private Map<Piloto, String> desistencias;
	private Boolean isPremium;
	private Clima clima;
	private Circuito circuito;
	private Map<Piloto,Carro> carros;
	private List<Pair<Carro,Integer>> classificacao;

	public Corrida() {
		this.voltaAtual = 0;
		this.desistencias = new HashMap<>();
		this.isPremium = false;
		this.clima = null;
		this.circuito = null;
		this.classificacao = new ArrayList<>();
		this.carros = new HashMap<>();
	}

	public Corrida(int voltaAtual, Map<Piloto,String> desistencias, Boolean isPremium,
					Clima clima, Circuito circuito, ArrayList<Pair<Carro,Integer>> classificacao, Map<Piloto,Carro> carros) {
		this.voltaAtual = voltaAtual;
		this.desistencias = desistencias;
		this.isPremium = isPremium;
		this.clima = clima;
		this.circuito = circuito;
		this.classificacao = classificacao;
		this.carros = carros;
	}
	
	public Corrida(Corrida c) {
		this.voltaAtual = c.getVoltaAtual();
		this.desistencias = c.getDesistencias();
		this.isPremium = c.getIsPremium();
		this.clima = c.getClima();
		this.circuito = c.getCircuito();
		this.classificacao = c.getClassificacao();
		this.carros = c.getCarros();
	}

	public int getVoltaAtual() {
		return this.voltaAtual;
	}

	public void setVoltaAtual(int voltaAtual) {
		this.voltaAtual = voltaAtual;
	}

	public Map<Piloto,String> getDesistencias() {
		return (Map<Piloto,String>) this.desistencias.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
	}

	public void setDesistencias(Map<Piloto,String> desistencias) {
		this.desistencias = desistencias;
	}

	public Boolean isIsPremium() {
		return this.isPremium;
	}

	public Boolean getIsPremium() {
		return this.isPremium;
	}

	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}

	public Clima getClima() {
		return this.clima;
	}

	public void setClima(Clima clima) {
		this.clima = clima;
	}


	public Circuito getCircuito() {
		return this.circuito;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}
	
	public ArrayList<Pair<Carro,Integer>> getClassificacao() {
		return (ArrayList<Pair<Carro,Integer>>) this.classificacao.stream().collect(Collectors.toList());
	}

	public void setClassificacao(ArrayList<Pair<Carro,Integer>> classificacao) {
		this.classificacao = classificacao;
	}
	
	public Map<Piloto,Carro> getCarros() {
		return this.carros;
	}
	
	public void setCarros(Map<Piloto,Carro> carros) {
		this.carros = carros;
	}

	// --- Métodos ---

	/**
	 * Configura as variaveis necessarias para a simulacao de uma corrida
	 * @param c
	 * @param jogadores
	 */
	public void simulaCorrida(Circuito c, ArrayList<Pair<Carro,Piloto>> jogadores){
		this.setCircuito(c);
		for (Pair<Carro,Piloto> iterador : jogadores) {
			this.classificacao.add(new Pair<Carro,Integer>(iterador.getFirst(), 0));
			this.carros.put(iterador.getSecond(),iterador.getFirst());
		}
		if (ThreadLocalRandom.current().nextBoolean())
			this.clima = Clima.SOLARENGO;
		else
			this.clima = Clima.CHUVA;
		
		int numeroDeVoltas = this.getCircuito().getNumeroVoltas();
		while(voltaAtual < numeroDeVoltas) {
			for (Segmentos segmento : this.getCircuito().getListaSegmentos()) {
				for (int i = 1; i < this.getClassificacao().size(); i++) {
					if (avaria(this.classificacao.get(i).getFirst())) {
						Carro desistencia = this.classificacao.remove(i).getFirst();
						// this.desistencias.put()
					}
				}
			}
		}
	}

	/**
	 * @param x
	 * @param y
	 */
	public void trocarPosicoesClassificacao(int x, int y){
		Pair<Carro,Integer> temp = this.classificacao.get(x);
		this.classificacao.set(x, this.classificacao.get(y));
		this.classificacao.set(y, temp);
	}

	public boolean avaria(Carro c){ // rever esta formulação é provavel que isto tenha demasiada porbabilidade de haver avarias
		return ThreadLocalRandom.current().nextDouble(0,100) % 1000 < c.getFiabilidade(); 
	}
	
	public double probabilidadeUltrapassagem(int cilindrada, int potencia , int gdu, int svaPiloto, int ctsPiloto, int sva, Clima meteo){ //modo motor e downforce
		
		double probabilidade = 0.0;
		double habilidadePilotoChuva = 1 - ctsPiloto;
	
		if(meteo == Clima.CHUVA){
			probabilidade = 0.4 * habilidadePilotoChuva + 0.4 * (double) (cilindrada / potencia) * gdu + 0.2 * (1.0 - sva);
		}
		else{
			probabilidade = 0.4 * ctsPiloto + 0.4 * (double) (cilindrada / potencia) * gdu + 0.2 * (1.0 - sva);
		}
		
		return probabilidade;
	}
	
	public boolean ultrapassa(Carro c){
		
		if(avaria(c)){
			return false;
		}
	
		return true;
	}
}
