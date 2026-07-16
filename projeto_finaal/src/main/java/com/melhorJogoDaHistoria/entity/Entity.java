package com.melhorJogoDaHistoria.entity;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class Entity {
  protected int forca,vida,defesa,ataque,x,y;
  protected String nome,texto;
  protected String imageResourcePath;

  public BufferedImage getPlayerImage(){
    BufferedImage boneco = null;
    try{
        boneco = ImageIO.read(getClass().getResourceAsStream(imageResourcePath));
    }catch(IOException e) {
        e.printStackTrace();
    }
    return boneco;
  }

  public abstract void atributos();
  public abstract void ataque();
  public abstract void defesa();
  public abstract  void interacao();
  public abstract String apresentacao();
}


