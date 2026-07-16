package com.melhorJogoDaHistoria.entity;

public class Guerreiro extends  Entity {
  public Guerreiro(){
    forca = 2;
    vida = 30;
    defesa = 2;
    ataque = 8;

    this.imageResourcePath = "/jogador/guerreiro.png";
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
