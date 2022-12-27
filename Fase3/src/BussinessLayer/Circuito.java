package BussinessLayer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Circuito{
    private String nomeCir;
    private double distancia;
    private int numeroVoltas;
    private int tempoBox;
    private List<SegmentoEstrada> listaSegmentos;

    public Circuito(){
        this.nomeCir = null;
        this.distancia = 0;
        this.numeroVoltas= 0;
        this.tempoBox = 0;
        this.listaSegmentos = new ArrayList<SegmentoEstrada>();
    }

    public enum SegmentoEstrada(){
        CURVA,
        RETA,
        CHICANE
    }
}
