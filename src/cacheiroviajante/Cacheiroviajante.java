package cacheiroviajante;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.math.BigInteger; 
import java.util.Random;
/**
 *
 * @author PokeMub
 */
public class Cacheiroviajante extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Adicionar Arquivo'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Cacheiro Viajante");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //launch(args);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ColetaInicial inicio;
        inicio = new ColetaInicial();
        Scanner ler = new Scanner(System.in);
        System.out.println("Quantidades de Cidades do Arquivo CSV(Padrão 8): "); //qtd de cidadas (8)
        inicio.setQTDPopulacao(ler.nextInt());
        System.out.println("Tamanho da População(Padrão 20): "); //qtd de geração / tamanho populacao (20)
        inicio.setTMPopulacao(ler.nextInt());
        System.out.println("Taxa de CrossOver(Padrão 0.25): "); // taxa de crossOver (0.25)
        inicio.setTXCrossOver(ler.nextFloat());
        System.out.println("Taxa de Mutação(Padrão 0.01): "); // taxa de mutação (0.01)
        inicio.setTXMutacao(ler.nextDouble());
        System.out.println("Porcentagem de termino sem Alteração(Padrão 30)"); // porcentagem de termino sem alteração "melhora"(30geracao)
        inicio.setPCTermino(ler.nextInt());
        System.out.println("Geração Maxima gerada(Padrão 1000)");
        inicio.setpMax(ler.nextInt());
        // busca inicial dos dados
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        double valMut = inicio.getTXMutacao() * 100 ;
        int valMut2 = (int)valMut;
        int valSor = 0 ;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // abrir o arquivo em CSV e Jogar ParA O oBEJTO ItensTabelaCSV
        String csvArquivo = "D:\\area de trabalho\\Java\\planilha\\plan.csv";
        BufferedReader conteudoCSV = null;
        String linha = "";
        String csvSeparadorCampo = ";";
        int i=0,j=0,k=0;
        int cid1=0, cid2=0;
        double difDis = 0; // distancia entre 2 cidades
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<ItenstabelaCSV> lista = new ArrayList<ItenstabelaCSV>();
        //ItenstabelaCSV v1 = new ItenstabelaCSV();
        ItenstabelaCSV dados; 
        try {
            conteudoCSV = new BufferedReader (new FileReader (csvArquivo));
            while ( (linha= conteudoCSV.readLine()) != null ){
                String[] itens = linha.split(csvSeparadorCampo);
                
                if(i>=1){
                   dados = new ItenstabelaCSV();
                   dados.setNomeCidade (itens[0]);
                   dados.setDisX(Double.parseDouble(itens[1]));
                   dados.setDisY(Double.parseDouble(itens[2]));  
                   dados.setIdent(i);
                   lista.add(dados);
                }
                i++;
            }
        }catch(IOException e){
            System.out.println(e.getMessage()); // mensagem de erro
        }finally{
        }// parte da leitura 
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////
        for(i=0 ; i< lista.size();i++){
            System.out.print("nome cidade: " + lista.get(i).getNomeCidade());
            System.out.print("   Distancia X: " + lista.get(i).getDisX());
            System.out.println("   Distancia Y: " + lista.get(i).getDisy()); 
        }
        // so pra printar na tela
        ///////////////////////////////////////////////////////////////////////////////////
         //difDis = calculo (lista, cid1 , cid2);
         //System.out.println("valor: " + difDis);
         ///////////////////////////////////////////////////////////////////////////////////
         double [][] distancia = new double[lista.size()][lista.size()];
         for(j=0 ;j<lista.size();j++){
            for(k=0; k<lista.size();k++){
                distancia[j][k] = calculo (lista, j , k);
                System.out.print("  "+ distancia[j][k]);
            }
            System.out.println("");
         }
         // matriz 
         //////////////////////////////////////////////////////////////////////////////////
         double crostaxa = 0;
         int subst = 0;
         int w=0;
         int z=0;
         int valo =0;
         int cont =0;
         int t = 0;
         double vetcomp [] ; 
         double vetcomp2[];
         double menGen [];
         int yy=0;
         int jj=0;
         int jjj=0;
         int kk=0;
         int kkk=0;
         int posicmae =0;
         int ww = 0;
         int posicpai =0;
         double maegen =0;
         double  junt = 0;
         int oo=0;
         vetcomp = new double[inicio.getTMPopulacao()];
         vetcomp2 = new double[inicio.getQTDPopulacao()];
         double menVal = 0;
         int metadePop =0 ;
         menGen = new double [inicio.getPmax()];
         //criacão da primeira linhagem
         Random random = new Random();
         metadePop = inicio.getQTDPopulacao() / 2;
         crostaxa =  inicio.getTXCrossOver() * (inicio.getTMPopulacao());
         int zzz=0;
         int crostaxa2 = (int)crostaxa; 
         int metcros = crostaxa2 / 2;
         int ooo;
         int escant=0;
         int [][][] genis = new int [inicio.getPmax()][inicio.getTMPopulacao()][inicio.getQTDPopulacao()];
         double [][][] genidist = new double [inicio.getPmax()][inicio.getTMPopulacao()][1];
         for(j=0;j<inicio.getPmax();j++){
             
             /////////////////////////////////// primeira geracao
            if(j==0){
                for(k=0;k<inicio.getTMPopulacao();k++){
                    for(w=0;w<inicio.getQTDPopulacao();w++){
                        genis[j][k][w] = random.nextInt(inicio.getQTDPopulacao());
                        if(w==0){
                            genidist [j][k][0] = 0;
                            genidist [j][k][0] =  genidist [j][k][0] + distancia[w][w];
                            //System.out.println(" "+ genidist[j][k][0]);
                        }
                        for(z=0 ; z<=w ; z++){
                            if(z==0){
                                if(z>=t){
                                    t++;  
                                } 
                            }else{
                                if(genis[j][k][z-1] == genis[j][k][w]  ) {
                                    w--;
                                    z=3000;
                                }else{
                                    if(z>=t){
                                        t++;
                                        yy ++;
                                        genidist [j][k][0] =  genidist [j][k][0] + distancia[genis[j][k][w-1]][genis[j][k][w]];
                                        System.out.println(""+genidist [j][k][0]);
                                    }    
                                }
                            }
                        }
                    }
                    System.out.println("");
                    System.out.println("");     
                    System.out.println("");    
                    t=0;
                    vetcomp[k] =genidist [j][k][0] ;
                    
                    if(k==0){
                        menGen[j] = genidist [j][k][0];
                        maegen = menGen[j];
                        posicmae= 1;
                        posicpai=0;
                    }else{
                        
                        if(menGen[j] > vetcomp[k]){
                            posicmae = posicpai ; 
                            posicpai =  k;
                            maegen = menGen[j];
                            menGen[j] = genidist [j][k][0];
                            jj= j;
                            //kkk=kk;
                            //kk=k;
                            //ww=w;
                        }
                    }   
                }
                
            }else{
            
                
             /////////////////////////////////////////////////////////////////////////

             /////////////////////////////////  prox geracoes menos a primeira
            for(k=0;k<inicio.getTMPopulacao();k++){
                // aki
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                if(k < crostaxa2){
                    System.out.println("taxa de cross "+ crostaxa2);
                    if(k<metcros){
                    for(w=0;w<inicio.getQTDPopulacao();w++){
                        System.out.println(""+posicpai);
                        System.out.println(""+posicmae);
                        if(metadePop <= w){
                            genis[j][k][w] =  genis[j-1][posicmae][w];
                            //System.out.println(""+ genis[j][k][w]);
                        }else{
                            genis[j][k][w] =  genis[j-1][posicpai][w];
                        }
                    }
                    
                    for(w=0;w<inicio.getQTDPopulacao();w++){
                        valSor = random.nextInt(100);
                        if(valSor <= valMut2){
                           if(w==0){
                               subst =  genis[j][k][w] ;
                               genis[j][k][w] = genis[j][k][w+1];
                               genis[j][k][w+1] = subst;
                               System.out.println(" mutou valor k: "+ k + "valor w"+ w + "j:" + j );
                           }else{
                               subst =  genis[j][k][w] ;
                               genis[j][k][w] = genis[j][k][w-1];
                               genis[j][k][w-1] = subst;
                               System.out.println(" mutou valor k: "+ k + "valor w"+ w + "j:" + j );
                           }
                           
                           
                        }
                    }
                    
                    
                            
                    for(i= metadePop;i<inicio.getQTDPopulacao();i++){
                        ooo= 0 ;
                        for(oo= 0 ; oo <inicio.getQTDPopulacao() ; oo++){
                            if(i == oo){
                                if(oo == inicio.getQTDPopulacao() ){
                                    if(genis[j][k][oo] == genis[j][k][i] ){
                                    oo = 0;
                                    genis[j][k][i]= ooo;
                                    ooo++;
                                    }
                                }
                            }else{
                                if(genis[j][k][oo] == genis[j][k][i] ){
                                    oo = -1;
                                    genis[j][k][i]= ooo;
                                    ooo++;
                                }
                            }
                            
                            /*if(metadePop <= oo){
                            }else{
                                if(genis[j][k][i] == genis[j][k][oo]  ){
                                   escant = ooo++;
                                   if(genis[j][k][i] == escant){
                                        oo--;
                                   }else{
                                       genis[j][k][i] = escant;
                                       oo = 10000;
                                    }
                                } 
                            }*/
                        }
                    }
                   
                    
                    
                }
                if(k>=metcros){
                    for(w=0;w<inicio.getQTDPopulacao();w++){
                        System.out.println(""+posicpai);
                        System.out.println(""+posicmae);
                        if(metadePop <= w){
                            genis[j][k][w] =  genis[j-1][posicpai][w];
                            //System.out.println(""+ genis[j][k][w]);
                        }else{
                            genis[j][k][w] =  genis[j-1][posicmae][w];
                        }
                    }
                    
                            
                    for(i= metadePop;i<inicio.getQTDPopulacao();i++){
                        ooo= 0 ;
                        for(oo= 0 ; oo <inicio.getQTDPopulacao() ; oo++){
                            if(i == oo){
                                if(oo == inicio.getQTDPopulacao() ){
                                    if(genis[j][k][oo] == genis[j][k][i] ){
                                    oo = 0;
                                    genis[j][k][i]= ooo;
                                    ooo++;
                                    }
                                }
                            }else{
                                if(genis[j][k][oo] == genis[j][k][i] ){
                                    oo = -1;
                                    genis[j][k][i]= ooo;
                                    ooo++;
                                }
                            }
                            
                          
                        }
                    }
                
                }
                for(i=0;i<inicio.getQTDPopulacao();i++){
                    if(i==0){
                        genidist [j][k][0] = 0;
                        genidist [j][k][0] =  genidist [j][k][0] + distancia[i][i];
                    }else{
                        genidist [j][k][0] =  genidist [j][k][0] + distancia[genis[j][k][i-1]][genis[j][k][i]];
                    }
                        
                }
                if(k > 0){
                if(k == 1){
                    vetcomp[0] =genidist [j][0][0] ;
                    if(k==0){
                        menGen[j] = genidist [j][0][0];
                        maegen = menGen[j];
                        posicmae= 1;
                        posicpai=0;
                    }else{
                        if(menGen[j] > vetcomp[0]){
                            posicmae = posicpai ; 
                            posicpai =  0;
                            maegen = menGen[j];
                            menGen[j] = genidist [j][0][0];
                            jj= j;
                            //kkk=kk;
                            //kk=k;
                            //ww=w;
                            
                            //junt = genidist [j][0][0];
                        }
                    }
                }    
                vetcomp[k] =genidist [j][k][0] ;
                //if(junt < vetcomp[k] ){
                    //genidist [j][k][0] = junt ;
                 //}
                    if(k==0){
                        menGen[j] = genidist [j][k][0];
                        maegen = menGen[j];
                        posicmae= 1;
                        posicpai=0;
                    }else{
                        if(menGen[j] > vetcomp[k]){
                            posicmae = posicpai ; 
                            posicpai =  k;
                            maegen = menGen[j];
                            menGen[j] = genidist [j][k][0];
                            jj= j;
                            
                            
                            //kkk=kk;
                            //kk=k;
                            //ww=w;
                        }
                    } 
                } 
                // aki
              ////////////////////////////////////////////////////////////////////////////////////////////////////////  
                }else{
                    for(k=k;k<inicio.getTMPopulacao();k++){
                    for(w=0;w<inicio.getQTDPopulacao();w++){
                        genis[j][k][w] = random.nextInt(inicio.getQTDPopulacao());
                        if(w==0){
                            genidist [j][k][0] = 0;
                            genidist [j][k][0] =  genidist [j][k][0] + distancia[w][w];
                            //System.out.println(" "+ genidist[j][k][0]);
                        }
                        for(z=0 ; z<=w ; z++){
                            if(z==0){
                                if(z>=t){
                                    t++;  
                                } 
                            }else{
                                if(genis[j][k][z-1] == genis[j][k][w]  ) {
                                    w--;
                                    z=3000;
                                }else{
                                    if(z>=t){
                                        t++;
                                        yy ++;
                                        genidist [j][k][0] =  genidist [j][k][0] + distancia[genis[j][k][w-1]][genis[j][k][w]];
                                        System.out.println(""+genidist [j][k][0]);
                                    }    
                                }
                            }
                        }
                    }
                    System.out.println("");
                    System.out.println("");     
                    System.out.println("");    
                    t=0;
                    vetcomp[k] =genidist [j][k][0] ;
                    //if(junt < vetcomp[k] ){
                       //genidist [j][k][0] = junt ;
                    //}
                    if(k==crostaxa2){
                        menGen[j] = genidist [j][k][0];
                        maegen = menGen[j];
                        posicmae= 1;
                        posicpai=0;
                    }else{
                        
                        if(menGen[j] > vetcomp[k]){
                            posicmae = posicpai ; 
                            posicpai =  k;
                            maegen = menGen[j];
                            menGen[j] = genidist [j][k][0];
                            jj= j;
                            
                            
                            //kkk=kk;
                            //kk=k;
                            //ww=w;
                        }
                    }   
                }
                
                
                }
                   
            }

             ////////////////////
         for(k=0 ; k < inicio.getTMPopulacao() ; k++){
             vetcomp[k] =genidist [j][k][0] ;
                    //if(junt < vetcomp[k] ){
                       //genidist [j][k][0] = junt ;
                    //}
                    if(k==0){
                        menGen[j] = genidist [j][k][0];
                        maegen = menGen[j];
                        posicmae= 1;
                        posicpai=0;
                    }else{
                        
                        if(menGen[j] > vetcomp[k]){
                            posicmae = posicpai ; 
                            posicpai =  k;
                            maegen = menGen[j];
                            menGen[j] = genidist [j][k][0];
                            jj= j;
                            
                            
                            //kkk=kk;
                            //kk=k;
                            
                        }
                    }
         
         }   
            
        }
           zzz++; 
           if(j==0){
                menVal = menGen[j];
            }else{
                if(menVal > menGen[j]){
                    menVal= menGen[j];
                    jjj= j;
                    zzz=0;     
                }
            }
        
          ///
         
        if((inicio.getPCTermino()) == zzz){
          j=10000000;
        }   
        ww++;   
           
           
           
           
        }
        for(j=0;j<ww;j++){
            System.out.println("");
            for(k=0;k<inicio.getTMPopulacao();k++){
                for(w=0;w<inicio.getQTDPopulacao();w++){
                    System.out.print(" ," + genis[j][k][w]);
                }
                System.out.println(" "+ genidist[j][k][0]);
            }
        }
        for(i=0;i<ww;i++){
            System.out.println(""+menGen[i]);
        }
        System.out.println("" + menVal);      
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
    }
    public static double calculo(ArrayList<ItenstabelaCSV> lista, int cid1, int cid2){
        double d,d2;
        d =   Math.pow((lista.get(cid1).getDisX() - lista.get(cid2).getDisX()),2); 
        d2 = Math.pow((lista.get(cid1).getDisy() - lista.get(cid2).getDisy()),2); 
        d = d + d2; 
        d2 = Math.sqrt(d); 
        //System.out.print(" "+d2);
        return d2;
    } 
    // calculo para gerar a distancia
////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   
            
}
