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
import BussinessLayer.SubCarro.C1H;
import BussinessLayer.SubCarro.C2H;
import BussinessLayer.SubCarro.Carro;
import BussinessLayer.SubCarro.GTH;
import BussinessLayer.SubCarro.Carro.TipoPneus;
import BussinessLayer.SubPiloto.Piloto;
import util.Pair;

public class Corrida {
	public enum Clima{
		SOLARENGO,
		CHUVA;
	}

	private int voltaAtual;
	private Map<Carro, String> desistencias;
	private Boolean isPremium;
	private Clima clima;
	private Circuito circuito;
	private Map<Integer,Piloto> pilotos;
	private List<Pair<Carro,Integer>> classificacao;

	public Corrida() {
		this.voltaAtual = 0;
		this.desistencias = new HashMap<>();
		this.isPremium = false;
		this.clima = null;
		this.circuito = null;
		this.classificacao = new ArrayList<>();
		this.pilotos = new HashMap<>();
	}

	public Corrida(int voltaAtual, Map<Carro,String> desistencias, Boolean isPremium,
					Clima clima, Circuito circuito, ArrayList<Pair<Carro,Integer>> classificacao, Map<Integer,Piloto> carros) {
		this.voltaAtual = voltaAtual;
		this.desistencias = desistencias;
		this.isPremium = isPremium;
		this.clima = clima;
		this.circuito = circuito;
		this.classificacao = classificacao;
		this.pilotos = carros;
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

	public Map<Carro,String> getDesistencias() {
		return (Map<Carro,String>) this.desistencias.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
	}

	public void setDesistencias(Map<Carro,String> desistencias) {
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
	
	public Map<Integer,Piloto> getPilotos() {
		return this.pilotos;
	}
	
	public void setPilotos(Map<Integer,Piloto> carros) {
		this.pilotos = carros;
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
			this.pilotos.put(iterador.getFirst().getCarID(), iterador.getSecond());
		}
		if (ThreadLocalRandom.current().nextBoolean())
			this.clima = Clima.SOLARENGO;
		else
			this.clima = Clima.CHUVA;
		
		int numeroDeVoltas = this.getCircuito().getNumeroVoltas();
		while(voltaAtual < numeroDeVoltas) {
			for (Segmentos segmento : this.getCircuito().getListaSegmentos()) {
				int i = 1;
				while (i < this.getClassificacao().size()) {
					Carro carro = this.classificacao.get(i).getFirst();

					if (avaria(this.classificacao.get(i).getFirst())){
						Carro desistencia = this.classificacao.remove(i).getFirst();
						this.desistencias.put(desistencia, "");
					}

					// else if () {
					// 	// despiste/colisao
					// } 

					else if(carro.getClass() == C1H.class) {
						int potencia = carro.getPotenciaICE() + ((C1H)carro).getPotenciaE();
						Piloto piloto = pilotos.get(carro.getCarID());
						double p = probabilidadeUltrapassagem(carro.getCilindrada(), potencia, segmento.getGdu(), piloto.getCts(), piloto.getSva(), this.clima);
						if (ultrapassa(p)){
							this.trocarPosicoesClassificacao(i, i+1);
							i += 2;
						}
						else
							i++;
					}
					else if(carro.getClass() == C2H.class) {
						int potencia = carro.getPotenciaICE() + ((C2H)carro).getPotenciaE();
						Piloto piloto = pilotos.get(carro.getCarID());
						double p = probabilidadeUltrapassagem(carro.getCilindrada(), potencia, segmento.getGdu(), piloto.getCts(), piloto.getSva(), this.clima);
						if (ultrapassa(p)){
							this.trocarPosicoesClassificacao(i, i+1);
							i += 2;
						}
						else
							i++;
					}
					else if(carro.getClass() == GTH.class) {
						int potencia = carro.getPotenciaICE() + ((GTH)carro).getPotenciaE();
						Piloto piloto = pilotos.get(carro.getCarID());
						double p = probabilidadeUltrapassagem(carro.getCilindrada(), potencia, segmento.getGdu(), piloto.getCts(), piloto.getSva(), this.clima);
						if (ultrapassa(p)){
							this.trocarPosicoesClassificacao(i, i+1);
							i += 2;
						}
						else
							i++;
					}
					else {
						int potencia = carro.getPotenciaICE();
						Piloto piloto = pilotos.get(carro.getCarID());
						double p = probabilidadeUltrapassagem(carro.getCilindrada(), potencia, segmento.getGdu(), piloto.getCts(), piloto.getSva(), this.clima);
						if (ultrapassa(p)){
							this.trocarPosicoesClassificacao(i, i+1);
							i += 2;
						}
						else
							i++;
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

	public double probabilidadeUltrapassagem(int cilindrada, int potencia , int gdu, double ctsPiloto, double svaPiloto, Clima meteo){ //modo motor e downforce
		
		double probabilidade = 0.0;
		double habilidadePilotoChuva = 1 - ctsPiloto;
	
		if(meteo == Clima.CHUVA){
			probabilidade = 0.4 * habilidadePilotoChuva + 0.4 * (double) (cilindrada / potencia) * gdu + 0.2 * (1.0 - svaPiloto);
		}
		else{
			probabilidade = 0.4 * ctsPiloto + 0.4 * (double) (cilindrada / potencia) * gdu + 0.2 * (1.0 - svaPiloto);
		}
		
		return probabilidade;
	}

	public double fatorClimaCarro (Carro carro){
		// if 
		return 0.0;
	}

	/**
	 * @param segmento
	 * @param carro
	 * @param ultrapassagem true quando o carro esta a ultrapassar (serve para aumentar as probabilidades de colisao e despiste)
	 * @return 0 para quando nao acontece nada; 1 para quando se despista mas sem quasar qualquer colisao; 2 quando colide com o carro da frente
	 */
	public int colisaoDespiste(Segmentos segmento, Carro carro, boolean ultrapassagem){
		if (segmento.getSegmento() == SegmentoEstrada.RETA){
			if (ThreadLocalRandom.current().nextInt(0,100) < 1)
				return 2;
		}
		else {
			double p = 10 + (carro.getDownforce() - 0.5)*2 + this.fatorClimaCarro(carro);
			if (ThreadLocalRandom.current().nextInt(0,100) < p)
				if (ThreadLocalRandom.current().nextInt(0,100) > 20)
					return 1;
				else
					return 2;
		}
		return 0;
	}

	public boolean ultrapassa(double probabilidade){
		
		if (ThreadLocalRandom.current().nextDouble(0,1) < probabilidade){
			// if(avaria(c)){
			// 	return false;
			// }
			return true;
		}
		return false;
	}

	public void move(){ // checa se nesta iteração algum carro ultrapassou e se sim adianta -o 2 posições em vez de uma
		for (Pair<Carro,Integer> iterator : this.classificacao){
			if(ultrapassa(iterator.getFirst())){
				iterator.setSecond(iterator.getSecond()+2);
			}
			else iterator.setSecond(iterator.getSecond()+1);
		}	
	}
}

