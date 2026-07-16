package com.melhorJogoDaHistoria.entity;

public class Bardo extends  Entity {
  public Bardo(){
    forca = 2;
    vida = 30;
    defesa = 2;
    ataque = 8;
    nome = "CLAUDINEI";

    this.imageResourcePath = "/jogador/bardo.png";
  }

  @Override
  public String apresentacao(){
      String texto = "Eu sou um grande músico, o grande "+ nome+ "!!!";
      //System.out.println(texto);
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
    System.out.println("Com minhas harmônicas e melodias construo a música da destruição com um tom de dó perante a ti!");
    
  }
  
  @Override
  public void defesa(){
    System.out.println("Você tem "+defesa+" de defesa diminuindo o ataque do monstro!");
  }

}
