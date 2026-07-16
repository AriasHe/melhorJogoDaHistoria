package com.melhorJogoDaHistoria.entity;

public class Monstro extends Entity {

  public Monstro() {
    forca = 5;
    vida = 10;
    defesa = 2;
    ataque =10;
    nome = "EUZIRACK";
    this.imageResourcePath = "/jogador/monsstro.png";
  }

  @Override
  public String apresentacao(){
    System.out.println("Eu sou " + nome + " Um mostro advindo das profundezas obcuras dos mares do norte." );
    System.out.println("Parei nessa pequena vila por um maldito herói que se meteu onde não devia");
    System.out.println("Agora eu quero VINGANÇA UAHAHAHHAH");
    return " ";
  }
  @Override
  public void ataque(){
      System.out.println("UAGH UAGH Esses heróis são gostosos UAGH UAGH");
  }
  @Override
  public String atributo(){
    String texto = "força:" + forca + " vida:" + vida + " defesa:" + defesa + " e ataque:"+ataque;
    System.out.println(texto);
    return texto;
  }
  @Override
  public void defesa(){
        System.out.println("O monstro tem "+defesa+" diminuindo o seu ataque em! "+defesa);
    
  }
}



