package BussinessLayer.SubSimulacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import BussinessLayer.SubCampeonato.Campeonato;
import BussinessLayer.SubCampeonato.Circuito;
import BussinessLayer.SubCampeonato.Segmentos;
import BussinessLayer.SubCarro.Carro;
import BussinessLayer.SubPiloto.Piloto;
import BussinessLayer.SubSimulacao.Corrida.Clima;
import util.Pair;

public interface ISimulacao {
    public void removeCarro(int carro, int motivo);
    public List<Pair<Integer,String>> simulaCorrida(Circuito c, ArrayList<Pair<Carro,Piloto>> jogadores);
    public void trocarPosicoesClassificacao(int x, int y);
    public boolean avaria(Carro c);
    public double probabilidadeUltrapassagem(int cilindrada, int potencia , int gdu, double ctsPiloto, double svaPiloto, Clima meteo);
    public double fatorClimaCarro (Carro carro);
    public int colisaoDespiste(Segmentos segmento, Carro carro, boolean ultrapassagem);
    public boolean ultrapassa(double probabilidade);
    public void configuraSimulacao(Campeonato campeonato, Map<String,Pair<Carro,Piloto>> jogadores);
    public void proximaCorrida();
    public Map<String,Integer> simulacao(Campeonato campeonato, Map<String, Pair<Carro, Piloto>> jogadores);
}