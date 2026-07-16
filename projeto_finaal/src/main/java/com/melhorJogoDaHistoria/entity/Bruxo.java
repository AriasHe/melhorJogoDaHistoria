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
  @Override
  public String apresentacao(){
    String texto = "Eu sou um grandioso mago, o grande "+ nome+ "!!!";
   // System.out.println(texto);
    return texto; 
  }

  @Override
  public String atributo(){
    String texto = "força:" + forca + " vida:" + vida + " defesa:" + defesa + " e ataque:"+ataque;
    //System.out.println(texto);
    return texto;
  }

  @Override
  public void  ataque(){
    System.out.println("Com meus poderes mágicos, eu te domino oh fera demoniaca!");
  }
  @Override
  public void defesa(){
    System.out.println("Você tem "+defesa+" de defesa diminuindo o ataque do monstro!");

  }
}
