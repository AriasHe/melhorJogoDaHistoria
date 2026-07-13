package com.melhorJogoDaHistoria.tijolos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.melhorJogoDaHistoria.Movimento;



public class Gerenciadortijolos {

    protected  int tileSize;
    protected  int maxScreenCol;
    protected  int maxScreenLin;
    protected  int linScreen;
    protected  int colScreen;
     Movimento tecla;

    Tijolos[] tile;
    int mapTileNum[][];
    //Player jogador =  new Player(painel, tecla);
    BufferedImage cenario;
   public Gerenciadortijolos(int tileSize,int maxWordCol, int maxWordLin,int linScreen,int colScreen, Movimento tecla){
        this.tileSize = tileSize;
        this.maxScreenCol = maxWordCol;
        this.maxScreenLin = maxWordLin;
        this.linScreen = linScreen;
        this.colScreen = colScreen;
        this.tecla = tecla;
       
   }

    public Tijolos[] mapa(){
        tile = new Tijolos[10];
    
        try{
            //cenario = ImageIO.read(getClass().getResourceAsStream("/cenario/trees.png"));
            tile[0] = new Tijolos();
            tile[0].imagem = ImageIO.read(getClass().getResourceAsStream("/textura/terraa.bmp"));
            tile[0].colisao = false;

            tile[1] = new Tijolos();
            tile[1].imagem = ImageIO.read(getClass().getResourceAsStream("/textura/agua.bmp"));
            tile[1].colisao = true;

            tile[2] = new Tijolos();
            tile[2].imagem = ImageIO.read(getClass().getResourceAsStream("/textura/grama.bmp"));
            tile[2].colisao = false;

            tile[3] = new Tijolos();
            tile[3].imagem = ImageIO.read(getClass().getResourceAsStream("/textura/terra.bmp"));
            tile[3].colisao = false;

            tile[4] = new Tijolos();
            tile[4].imagem = ImageIO.read(getClass().getResourceAsStream("/jogador/monsstro.png"));
            tile[4].colisao = true;
            
        }catch(IOException e) {
            System.out.println("Unexcepted Exception");
            e.printStackTrace();
        }
        return tile;
    }
    
    public int[][] mapaas(){
         mapTileNum = new int [maxScreenCol][maxScreenLin];
        //System.out.println( maxScreenLin);
        try {
            InputStream is = getClass().getResourceAsStream("/mapas/mundo.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0; 
            int linha = 0;
            int x = 0;
            

            while( linha < maxScreenLin){
                String line = br.readLine();
                //System.out.println(line);

                int[] vetor = new int[maxScreenCol];
                for (int i = 0; i < maxScreenCol; i++) {
                    vetor[i] = Character.getNumericValue(line.charAt(i));
                    x = vetor[i];
                    //System.out.print(vetor[i]);
                    mapTileNum[i][linha] = x;
                    //System.out.print(mapTileNum[i][linha]);
                }
                linha++;
                //System.out.println("");
            
            }
            br.close();
        } catch (Exception e) {
        }
        return mapTileNum;
    }



    public void draw(Graphics2D g2) {

        int col = 0; 
        int linha = 0;
        int x = 0;
        int y=0;
        
        while(col < maxScreenCol && linha < maxScreenLin){
            int tileNum = mapTileNum[col][linha];
           // System.out.println(tile[tileNum]);
            x = col * tileSize;
            y = linha * tileSize;
             
            int screenX = x - tecla.getPosicaoX() + colScreen/2 - tileSize/2;
            int screenY = y - tecla.getPosicaoY() + linScreen/2 - tileSize/2;

            //System.out.println(screenX);
            
             g2.drawImage(tile[tileNum].imagem,screenX,screenY,tileSize,tileSize,null);
            
            col ++;
            

            if(col == maxScreenCol){
                col = 0;
                linha ++;
                //System.out.println("");

            }
        }
    }
}