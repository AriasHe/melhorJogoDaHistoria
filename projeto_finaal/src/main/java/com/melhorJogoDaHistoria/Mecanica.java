package com.melhorJogoDaHistoria;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.melhorJogoDaHistoria.entity.AcertoContas;
import com.melhorJogoDaHistoria.entity.Entity;
import com.melhorJogoDaHistoria.entity.Player;
import com.melhorJogoDaHistoria.tijolos.Gerenciadortijolos;
import com.melhorJogoDaHistoria.tijolos.Tijolos;


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
    int mapTileNum[][];
    Tijolos tile [];
    int escolha;
    protected int FPS = 60;
    //protected int posicaoX = 100;
    //protected int posicaoY = 100;
    protected int posicaoX = tileSize * maxWorldCol/2;
    protected int posicaoY = tileSize * maxWorldRow/2;
    protected  int velocidade = 8;
    
    Entity personagem;
    Thread thread_jogo;
    Dialogos dialogo = new Dialogos();
    Movimento tecla = new Movimento(posicaoX,posicaoY,velocidade,tileSize,worldWith,wordHeight); 
    Painel painel = new Painel();
    //Escolha escolha = new Escolha();
    //Tijolos mapa = new Tijolos();
    AcertoContas jogo = new AcertoContas(tileSize);
    Player player = new Player(linScreen,colScreen,tileSize);
    Gerenciadortijolos cenario = new Gerenciadortijolos(tileSize,maxWorldCol,maxWorldRow,linScreen,colScreen,tecla);
    

    public void inicializacao(){
        this.setPreferredSize(new Dimension(colScreen,linScreen));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(tecla);
        //this.addKeyListener(escolha);
        this.setFocusable(true);
    }


    public void inicioThread(){
        //System.out.println(inicio);
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
        inicio = tecla.getc();
        //System.out.println(inicio);
        if(inicio){
            
            painel.draw(g2,colScreen,tileSize);
            tecla.getInicio(inicio);
            g2.drawString(">", 600, tecla.setposicao());
            

        }else{
            escolha = tecla.setescolha();
            personagem = jogo.teste(escolha);
            g2.clearRect(0, 0, linScreen, colScreen);
            cenario.draw(g2);
            player.draw(g2,personagem);
            dialogo.caixaDialogos(g2, tileSize,colScreen);
            dialogo.escrever("foda");
        }

        
        
        //g2.setColor(Color.BLUE);
        //g2.fillRect(tecla.getPosicaoX(), tecla.getPosicaoY(), 48, 48);
        g2.dispose();

    }



}

