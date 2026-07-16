package com.melhorJogoDaHistoria.entity;

public class Monstro extends Entity {

  public Monstro() {
    this.imageResourcePath = "/jogador/monsstro.png";
  }

  @Override
  public  void atributos(){
    forca = 5;
    vida = 10;
    defesa = 2;
    ataque =10;
    nome = "EUZIRACK";
  }
  @Override
  public String apresentacao(){
    atributos();
    System.out.println("Eu sou " + nome + " Um mostro advindo das profundezas obcuras dos mares do norte." );
    System.out.println("Parei nessa pequena vila por um maldito herói que se meteu onde não devia");
    System.out.println("Agora eu quero VINGANÇA UAHAHAHHAH");
    return "Agora eu quero VINGANÇA UAHAHAHHAH";
  }
  @Override
  public void ataque(){
      System.out.println("UAGH UAGH Esses heróis são gostosos UAGH UAGH");
  }
  public  void defesa(){

  }
  public void interacao(){

  }
}


