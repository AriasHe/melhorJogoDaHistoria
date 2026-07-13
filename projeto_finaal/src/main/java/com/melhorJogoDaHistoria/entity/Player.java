package com.melhorJogoDaHistoria.entity;

import java.awt.Graphics2D;


public class Player{
    
    int linScreen,colScreen,tileSize;
    
    AcertoContas jogo = new AcertoContas();
  

    public Player(int linScreen, int colScreen,int tileSize){
        this.linScreen = linScreen;
        this.colScreen = colScreen;
        this.tileSize = tileSize;
        //jogo.encontro_monstro();
       
    }


  
    public void draw(Graphics2D g2){
        
      
         //g2.setColor(Color.blue);
        //g2.fillRect(x, y, 48, 48);
       // System.out.println(teclas.getPosicaoX());
        //g2.drawImage(PlayerImage(),teclas.getPosicaoX(),teclas.getPosicaoY(),tileSize,tileSize,null);
        g2.drawImage(jogo.teste().PlayerImage(),(colScreen/2-tileSize/2),(linScreen/2-tileSize/2),tileSize*3/2,tileSize*3/2,null);
        //System.out.println("foda");
    }
}
