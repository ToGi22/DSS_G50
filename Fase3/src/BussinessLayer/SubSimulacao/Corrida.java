package BussinessLayer.SubSimulacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import BussinessLayer.SubCampeonato.Circuito;
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
	private Map<Integer, String> desistencias;
	private Boolean isPremium;
	private Clima clima;
	private Circuito circuito;
	private List<Carro> classificacao;
	private Map<Integer,Piloto> pilotos;
	private List<Pair<Carro,Integer>> positions;

	public Corrida() {
		this.voltaAtual = 0;
		this.desistencias = new HashMap<>();
		this.isPremium = false;
		this.clima = null;
		this.circuito = null;
		this.classificacao = new ArrayList<>();
		this.pilotos = new HashMap<>();
	}

	public Corrida(int voltaAtual, Map<Integer,String> desistencias, Boolean isPremium,
					Clima clima, Circuito circuito, ArrayList<Carro> classificacao, Map<Integer,Piloto> pilotos) {
						this.voltaAtual = voltaAtual;
		this.desistencias = desistencias;
		this.isPremium = isPremium;
		this.clima = clima;
		this.circuito = circuito;
		this.classificacao = classificacao;
		this.pilotos = pilotos;
	}
	
	public Corrida(Corrida c) {
		this.voltaAtual = c.getVoltaAtual();
		this.desistencias = c.getDesistencias();
		this.isPremium = c.getIsPremium();
		this.clima = c.getClima();
		this.circuito = c.getCircuito();
		this.classificacao = c.getClassificacao();
		this.pilotos = c.getPilotos();
	}

	public int getVoltaAtual() {
		return this.voltaAtual;
	}

	public void setVoltaAtual(int voltaAtual) {
		this.voltaAtual = voltaAtual;
	}

	public Map<Integer,String> getDesistencias() {
		return (Map<Integer,String>) this.desistencias.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
	}

	public void setDesistencias(Map<Integer,String> desistencias) {
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
	
	public ArrayList<Carro> getClassificacao() {
		return (ArrayList<Carro>) this.classificacao.stream().collect(Collectors.toList());
	}

	public void setClassificacao(ArrayList<Carro> classificacao) {
		this.classificacao = classificacao;
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

	public Map<Integer,Piloto> getPilotos() {
		return this.pilotos;
	}
	
	public void setPilotos(Map<Integer,Piloto> pilotos) {
		this.pilotos = pilotos;
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
			this.classificacao.add(iterador.getFirst());
			this.pilotos.put(iterador.getFirst().getCarID(), iterador.getSecond());
		}
		if (ThreadLocalRandom.current().nextBoolean())
			this.clima = Clima.SOLARENGO;
		else
			this.clima = Clima.CHUVA;

		
	}
}
