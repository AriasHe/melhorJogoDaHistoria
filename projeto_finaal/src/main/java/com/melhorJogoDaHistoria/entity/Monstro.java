package com.melhorJogoDaHistoria.entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Monstro extends Entity {

@Override
  public  BufferedImage PlayerImage(){
    try{
        boneco = ImageIO.read(getClass().getResourceAsStream("/jogador/monsstro.png"));
    }catch(IOException e) {
        e.printStackTrace();
    }
    return boneco;
  }

  @Override
  public  void atributos(){
    forca = 5;
    vida = 10;
    defesa = 2;
    ataque =10;
    nome = "EUZIRACK";
  }
  public void apresentacao(){
    atributos();
    System.out.println("Eu sou " + nome + " Um mostro advindo das profundezas obcuras dos mares do norte." );
    System.out.println("Parei nessa pequena vila por um maldito herói que se meteu onde não devia");
    System.out.println("Agora eu quero VINGANÇA UAHAHAHHAH");
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


