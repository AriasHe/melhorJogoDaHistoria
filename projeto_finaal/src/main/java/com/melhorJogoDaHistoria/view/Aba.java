package com.melhorJogoDaHistoria.view;

import java.awt.Color;

import javax.swing.JFrame;


public class Aba {
    protected final int tileSize = 48;
    protected final int maxScreenCol = 16;
    protected final int maxScreenLin = 12;
    protected final int linScreen = tileSize*maxScreenLin;
    protected final int colScreen = tileSize*maxScreenCol;
    protected JFrame frame;

  public Aba() {

  }
  public void painel(){
    Mecanica mecanica = new Mecanica();
    mecanica.inicializacao();
    frame.add(mecanica);
    frame.pack();
    mecanica.inicioThread();
  }

  public void cirar() {
    
    frame = new JFrame("titulo");
    frame.setBackground(Color.black);
    frame.setVisible(true);
    frame.setSize(colScreen, linScreen);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

}
