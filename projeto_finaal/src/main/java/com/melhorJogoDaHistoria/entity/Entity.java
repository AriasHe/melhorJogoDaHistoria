package com.melhorJogoDaHistoria.entity;
import java.awt.image.BufferedImage;


public abstract class Entity {
  //protected AcertoContas acerto = new AcertoContas();
  protected BufferedImage boneco;
  protected int forca,vida,defesa,ataque,x,y;
  protected String nome,texto;
  public abstract BufferedImage PlayerImage();
  public abstract void atributos();
  public abstract void ataque();
  public abstract void defesa();
  public abstract  void interacao();
  public abstract String apresentacao();
}


