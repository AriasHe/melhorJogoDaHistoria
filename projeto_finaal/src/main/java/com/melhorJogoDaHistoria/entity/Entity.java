package com.melhorJogoDaHistoria.entity;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entity {
  protected int forca,vida,defesa,ataque;
  protected String nome;
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

  public void tomarDano(Entity inimigo) {
    this.vida = this.vida - (inimigo.ataque - this.defesa);
  }

  public abstract void ataque();
  public abstract String atributo();
  public abstract String apresentacao();
  public abstract void defesa();
}


