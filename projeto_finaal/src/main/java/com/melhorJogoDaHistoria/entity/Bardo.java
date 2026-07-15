package com.melhorJogoDaHistoria.entity;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bardo extends  Entity {
  int tileSize,x,y;

  public Bardo(int tileSize){
    this.tileSize = tileSize;
  }

  @Override
  public  BufferedImage PlayerImage(){
    try{
        boneco = ImageIO.read(getClass().getResourceAsStream("/jogador/bardo.png"));
    }catch(IOException e) {
        e.printStackTrace();
    }
    return boneco;
  }

  @Override
  public  void atributos(){
    x = (int)(tileSize * 1.31);
    y = 2*tileSize;
    forca = 2;
    vida = 30;
    defesa = 2;
    ataque = 8;
  }
 
  public void apresentacao(){
    
  }
  public void  ataque(){

    
  }
  public  void defesa(){

  }
  public void interacao(){

  }

}
