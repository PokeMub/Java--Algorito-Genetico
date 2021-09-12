package cacheiroviajante;
public class ItenstabelaCSV {
     public String nomeCidade;
     public double distancX;
     public double distanciaY;
     public int indentificador;
     
     public String getNomeCidade(){
         return this.nomeCidade;
     }
     public double getDisX(){
         return this.distancX;
     }
     public double getDisy(){
         return this.distanciaY;
     }
     public int getIdentificar(){
         return this.indentificador;
     }
     
     public void setNomeCidade(String nomeCidade){
         this.nomeCidade = nomeCidade;
     }
     public void setDisX(double distancX){
         this.distancX = distancX;
     }
     public void setDisY(double distanciaY){
         this.distanciaY = distanciaY;
     }
     public void setIdent(int indentificador){
         this.indentificador = indentificador;
     }
     
}
