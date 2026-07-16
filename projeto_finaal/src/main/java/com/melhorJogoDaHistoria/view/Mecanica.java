package com.melhorJogoDaHistoria.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.melhorJogoDaHistoria.engine.Movimento;
import com.melhorJogoDaHistoria.engine.TempPers;
import com.melhorJogoDaHistoria.engine.map.Gerenciadortijolos;
import com.melhorJogoDaHistoria.engine.map.Tijolos;
import com.melhorJogoDaHistoria.entity.AcertoContas;
import com.melhorJogoDaHistoria.entity.Entity;

public class Mecanica extends JPanel{

    protected boolean inicio = true;


    protected  int tileSize = 130;
    protected  int maxScreenCol =12;
    protected  int maxScreenLin = 6;
    protected  int linScreen = tileSize*maxScreenLin;
    protected  int colScreen = tileSize*maxScreenCol;
    protected int maxWorldCol = 68;
    protected int maxWorldRow = 32;
    protected int worldWith = tileSize * maxWorldCol;
    protected int wordHeight = tileSize * maxWorldRow; 
    protected int mapTileNum[][];
    protected Tijolos tile [];
    protected int escolha;
    protected int FPS = 60;
    protected int posicaoX = 3000;
    protected int posicaoY = 3500;
    protected  int velocidade = 8;
    
    Entity personagem;
    Thread thread_jogo;

    TempPers temp = new TempPers();
    Dialogos dialogo = new Dialogos();
    Painel painel = new Painel();
    EscPersonage pers = new EscPersonage();
    AcertoContas jogo = new AcertoContas(dialogo);
    Movimento tecla = new Movimento(posicaoX,posicaoY,velocidade,tileSize,worldWith,wordHeight,jogo);
    Player player = new Player(linScreen,colScreen,tileSize);
    Gerenciadortijolos cenario = new Gerenciadortijolos(tileSize,maxWorldCol,maxWorldRow,linScreen,colScreen,tecla);
    

    public void inicializacao(){
        this.setPreferredSize(new Dimension(colScreen,linScreen));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(tecla);
        this.setFocusable(true);
    }


    public void inicioThread(){
        mapTileNum = cenario.mapaas();
        tecla.setmapTileNum(mapTileNum);
        tile = cenario.mapa();
        tecla.setijolos(tile);
        thread_jogo = new Thread();
        thread_jogo.start();
        rodar();
    }
    public void rodar(){
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(thread_jogo != null){    

            repaint();
            temp.tempo(nextDrawTime, drawInterval); 
        }

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        inicio = tecla.getc();
        if(inicio){
            
            painel.draw(g2,colScreen,tileSize);
            tecla.getInicio(inicio);
            g2.drawString(">", 600, tecla.setposicao());
        
        }else{
            personagem = tecla.setepersonagem();
            g2.clearRect(0, 0, linScreen, colScreen);
            cenario.draw(g2);
            player.draw(g2,personagem);
            dialogo.caixaDialogos(g2, tileSize,colScreen);
            dialogo.escrever(personagem.apresentacao()+"\n"+ personagem.atributo());
        }
    }
}

