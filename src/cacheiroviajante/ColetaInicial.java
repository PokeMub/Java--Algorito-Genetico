package cacheiroviajante;
public class ColetaInicial {
    public int qtdPopulacao ;
    public int tmPopulacao ;
    public float txCrossOver ;
    public double txMutacao ;
    public int pcTermino ;
    public int pMax;
    
    public int getQTDPopulacao(){
        return this.qtdPopulacao;
    }
    public int getTMPopulacao(){
        return this.tmPopulacao;
    }
    public float getTXCrossOver(){
        return this.txCrossOver;
    }
    public double getTXMutacao(){
        return this.txMutacao;
    }
    public int getPCTermino(){
        return this.pcTermino;
    }
    public int getPmax(){
        return this.pMax;
    }
    
    public void setQTDPopulacao(int qtdPopulacao){
        this.qtdPopulacao = qtdPopulacao;
    }
    public void setTMPopulacao (int tmPopulacao){
        this.tmPopulacao = tmPopulacao;
    }
    public void setTXCrossOver(float txCrossOver){
        this.txCrossOver = txCrossOver;
    }
    public void setTXMutacao(double txMutacao){
        this.txMutacao = txMutacao;
    }
    public void setPCTermino(int pcTermino){
        this.pcTermino = pcTermino;
    }
    public void setpMax(int pMax){
        this.pMax = pMax;
    }
    
}
