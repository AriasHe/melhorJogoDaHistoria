package com.melhorJogoDaHistoria.entity;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ladino extends  Entity {
  

  @Override
  public  BufferedImage PlayerImage(){
    try{
        boneco = ImageIO.read(getClass().getResourceAsStream("/jogador/ladino.png"));
    }catch(IOException e) {
        e.printStackTrace();
    }
    return boneco;
  }

  @Override
  public  void atributos(){
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
