package BussinessLayer.SubSimulacao;

import java.util.Map;
import java.util.stream.Collectors;

import BussinessLayer.SubCampeonato.Circuito;
import BussinessLayer.SubCarro.Carro;

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
	private Map<String,Carro> classificacao;

	public Corrida() {
		this.voltaAtual = 0;
		this.desistencias = null;
		this.isPremium = false;
		this.clima = null;
		this.circuito = null;
		this.classificacao = null;
	}

	public Corrida(int voltaAtual, Map<Integer,String> desistencias, Boolean isPremium, Clima clima, Circuito circuito, Map<String,Carro> classificacao) {
		this.voltaAtual = voltaAtual;
		this.desistencias = desistencias;
		this.isPremium = isPremium;
		this.clima = clima;
		this.circuito = circuito;
		this.classificacao = classificacao;
	}
	
	public Corrida(Corrida c) {
		this.voltaAtual = c.getVoltaAtual();
		this.desistencias = c.getDesistencias();
		this.isPremium = c.getIsPremium();
		this.clima = c.getClima();
		this.circuito = c.getCircuito();
		this.classificacao = c.getClassificacao();
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

	public Map<String,Carro> getClassificacao() {
		return (Map<String,Carro>) this.classificacao.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
	}

	public void setClassificacao(Map<String,Carro> classificacao) {
		this.classificacao = classificacao;
	}

}
