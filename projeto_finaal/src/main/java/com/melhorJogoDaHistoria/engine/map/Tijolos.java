package com.melhorJogoDaHistoria.engine.map;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tijolos {
    public BufferedImage imagem;
    public boolean colisao;
    protected int maxScreenCol;
    protected int maxScreenLin;
    protected int mapTileNum[][];



    
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

    public int[][] getMapTile(){
        return mapTileNum;
    }
    
}
