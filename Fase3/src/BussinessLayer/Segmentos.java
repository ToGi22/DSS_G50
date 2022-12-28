package BussinessLayer;


public class Segmentos {
    
    public enum SegmentoEstrada{
        CURVA,
        RETA,
        CHICANE;
    }
    
    private SegmentoEstrada segmento;
    private int gdu;
    
    public SegmentoEstrada getSegmento() {
        return segmento;
    }

    public Segmentos(){
        this.segmento = null;
        this.gdu = 0;
    }

    public Segmentos(SegmentoEstrada segmento, int gdu){
        this.segmento = segmento;
        this.gdu = gdu;
    }

    public Segmentos(Segmentos s){
        this.segmento = s.segmento;
        this.gdu = s.gdu;
    }


    public void setSegmento(SegmentoEstrada segmento) {
        this.segmento = segmento;
    }
    public int getGdu() {
        return gdu;
    }
    public void setGdu(int gdu) {
        this.gdu = gdu;
    }
}
