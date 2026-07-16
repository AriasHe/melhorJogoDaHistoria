package com.melhorJogoDaHistoria.entity;

public class Guerreiro extends  Entity {
  public Guerreiro(){
    forca = 2;
    vida = 30;
    defesa = 2;
    ataque = 8;
    nome = "GLADUS";

    this.imageResourcePath = "/jogador/guerreiro.png";
  }

  @Override
  public String apresentacao(){
    String texto = "Eu sou um grandioso guerreiro!!! Meu nome é " + nome;
    //System.out.println("Eu sou um grandioso guerreiro, já lutei por inúmeras batalhas!!! Meu nome é" + nome);
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
    System.out.println("Eu "+nome+" te ataco brutalmente seu monstro vindo ddas catacumbas do inferno!");
    
  }

  @Override
  public void defesa(){
    System.out.println("Você tem "+defesa+" de defesa diminuindo o ataque do monstro!");
  }


}
