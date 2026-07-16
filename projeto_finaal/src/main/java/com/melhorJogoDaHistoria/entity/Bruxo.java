package com.melhorJogoDaHistoria.entity;

public class Bruxo extends  Entity {
  int tileSize,x,y;
  String texto;
  public Bruxo(){
    //this.tileSize = tileSize;
    this.imageResourcePath = "/jogador/bruxo.png";
  }

  @Override
  public  void atributos(){
    //x = 2*tileSize;
    //y = 2*tileSize;
    forca = 3;
    vida = 20;
    defesa = 1;
    ataque = 4;
    nome = "AVALON";
  }
  
  public String apresentacao(){
    
    texto = "Eu sou um grandioso mago, o grande "+ nome+ "!!!";
    return texto; 
     //System.out.println("Eu sou um grandioso mago, o grande "+ nome+ "!!!");
     
     //atributoss();
  }
  public void atributoss(){
    System.out.println("força:" + forca + " vida:" + vida + " defesa:" + defesa + " e ataque:"+ataque);
  }
  public void  ataque(){
  
      System.out.println("Com meus poderes mágicos, eu te domino oh fera demoniaca!");
  

  }
  public  void defesa(){

  }
  public void interacao(){

  }
}
