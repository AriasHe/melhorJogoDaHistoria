package com.melhorJogoDaHistoria;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.melhorJogoDaHistoria.entity.Player;
import com.melhorJogoDaHistoria.tijolos.Gerenciadortijolos;
import com.melhorJogoDaHistoria.tijolos.Tijolos;


public class Mecanica extends JPanel{

    protected  int tileSize = 130;
    protected  int maxScreenCol =20;
    protected  int maxScreenLin = 12;
    protected  int linScreen = tileSize*maxScreenLin;
    protected  int colScreen = tileSize*maxScreenCol;

    protected int maxWorldCol = 68;
    protected int maxWorldRow = 32;
    protected int worldWith = tileSize * maxWorldCol;
    protected int wordHeight = tileSize * maxWorldRow; 
    int mapTileNum[][];
    Tijolos tile [];
    protected int FPS = 60;
    //protected int posicaoX = 100;
    //protected int posicaoY = 100;
    protected int posicaoX = tileSize * maxWorldCol/2;
    protected int posicaoY = tileSize * maxWorldRow/2;
    protected  int velocidade = 8;
    
    Thread thread_jogo;
    Movimento tecla = new Movimento(posicaoX,posicaoY,velocidade,tileSize); 
    Tijolos mapa = new Tijolos();
    Player player = new Player(this,linScreen,colScreen,tileSize);
    Gerenciadortijolos cenario = new Gerenciadortijolos(tileSize,maxWorldCol,maxWorldRow,linScreen,colScreen,tecla);
    
    public void inicializacao(){
        this.setPreferredSize(new Dimension(colScreen,linScreen));
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
                
            
                //update();
                
                repaint();
               
                
                try {
                    double remainingTime = nextDrawTime - System.nanoTime();
                    remainingTime = remainingTime/1000000;
                    if(remainingTime < 0){
                        remainingTime = 0;
                    }
                    remainingTime = 20;
                    Thread.sleep((long) remainingTime);
                    nextDrawTime += drawInterval;
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            //UPDATE: posição do personagem

            //DRAW: desenhar a cena com a informação atualizada
        }

    }

    public void update(){
       // player.update();
    }
    //Graphics contem muitas funções para desenhar objetos na cena
    // metodo para atualizar tela 
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        cenario.draw(g2);
        player.draw(g2, tileSize);
        
        //g2.setColor(Color.BLUE);
        //g2.fillRect(tecla.getPosicaoX(), tecla.getPosicaoY(), 48, 48);
        g2.dispose();

    }



}

