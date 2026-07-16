package com.melhorJogoDaHistoria.view;

import java.awt.Graphics2D;

import com.melhorJogoDaHistoria.entity.Entity;

public class Player{
    
    int linScreen,colScreen,tileSize;
    
  

    public Player(int linScreen, int colScreen,int tileSize){
        this.linScreen = linScreen;
        this.colScreen = colScreen;
        this.tileSize = tileSize;
        //jogo.encontro_monstro();
       
    }


  
    public void draw(Graphics2D g2,Entity personagem){
        int tamanho;
        tamanho = (int) 1.9*tileSize;
      
         //g2.setColor(Color.blue);
        //g2.fillRect(x, y, 48, 48);
       // System.out.println(teclas.getPosicaoX());
        //g2.drawImage(PlayerImage(),teclas.getPosicaoX(),teclas.getPosicaoY(),tileSize,tileSize,null);
        //System.out.println(personagem.nome);

        g2.drawImage(personagem.PlayerImage(),(colScreen/2-tileSize),(linScreen/2-tamanho),tileSize*3/2,tileSize*3/2,null);
        //System.out.println("foda");
    }
}
