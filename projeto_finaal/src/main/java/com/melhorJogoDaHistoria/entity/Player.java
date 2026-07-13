package com.melhorJogoDaHistoria.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.melhorJogoDaHistoria.Mecanica;
import com.melhorJogoDaHistoria.Movimento;

public class Player {
    Mecanica painel;
    Movimento teclas;
    BufferedImage boneco;
    int x;
    int y; 
    int linScreen,colScreen,tileSize;
    //protected Rectangle soidArea = new Rectangle(8,16,32,32);
    //protected boolean areaColisao = false;

    public Player(Mecanica painel ,int linScreen, int colScreen,int tileSize){
        this.painel = painel;
        this.linScreen = linScreen;
        this.colScreen = colScreen;
        this.tileSize = tileSize;
       
    }
    
    public BufferedImage PlayerImage(){
        try{
            boneco = ImageIO.read(getClass().getResourceAsStream("/jogador/teste.png"));
        }catch(IOException e) {
            System.out.println("Unexcepted Exception");
            e.printStackTrace();
        }
        return boneco;
    }

  
    public void draw(Graphics2D g2, int tileSize){
        
         //g2.setColor(Color.blue);
        //g2.fillRect(x, y, 48, 48);
       // System.out.println(teclas.getPosicaoX());
        //g2.drawImage(PlayerImage(),teclas.getPosicaoX(),teclas.getPosicaoY(),tileSize,tileSize,null);
        g2.drawImage(PlayerImage(),(colScreen/2-tileSize/2),(linScreen/2-tileSize/2),tileSize,tileSize,null);
        //System.out.println("foda");
    }
}
