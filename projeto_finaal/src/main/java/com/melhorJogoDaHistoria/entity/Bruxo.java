package com.melhorJogoDaHistoria.entity;

public class Bruxo extends  Entity {
  public Bruxo(){
    forca = 3;
    vida = 20;
    defesa = 1;
    ataque = 4;
    nome = "AVALON";

    this.imageResourcePath = "/jogador/bruxo.png";
  }
  
  public String apresentacao(){
    String texto = "Eu sou um grandioso mago, o grande "+ nome+ "!!!";
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
