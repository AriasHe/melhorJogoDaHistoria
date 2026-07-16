package com.melhorJogoDaHistoria.entity;

public class Bardo extends  Entity {
  int tileSize,x,y;

  public Bardo(){
    //this.tileSize = tileSize;
    this.imageResourcePath = "/jogador/bardo.png";
  }

  @Override
  public  void atributos(){
   // x = (int)(tileSize * 1.31);
    //y = 2*tileSize;
    forca = 2;
    vida = 30;
    defesa = 2;
    ataque = 8;
  }
 
  public String apresentacao(){
    return "morra java morra";
  }
  public void  ataque(){

    
  }
  public  void defesa(){

  }
  public void interacao(){

  }

}
