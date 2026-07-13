package com.melhorJogoDaHistoria;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.melhorJogoDaHistoria.tijolos.Tijolos;


public class Movimento implements KeyListener {
    protected boolean seta_cima, seta_baixo, seta_direita, seta_esquerda;
    protected int posicaoX, posicaoY, velocidade,tileSize;
    int mapTileNum[][];
    Tijolos tile[];

    public Movimento (int posicaoX,int posicaoY,int velocidade, int tileSize){
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.velocidade = velocidade;
        this.tileSize = tileSize;
    }    
    @Override
    //quando setas e teclas de controles são utilizados
    public void keyPressed(KeyEvent setas){ 
        if((setas.getKeyCode() == KeyEvent.VK_W) || (setas.getKeyCode() == KeyEvent.VK_UP)){
            System.out.print(getcory() + " ");
            System.out.println(getcorx());
            System.out.println(mapTileNum[getcorx()][getcory()]);
            seta_cima = true;
            posicaoY -= velocidade;
            
            
           
        }
        if((setas.getKeyCode() == KeyEvent.VK_D) || (setas.getKeyCode() == KeyEvent.VK_RIGHT)){
            System.out.print(getcory() + " ");
            System.out.println(getcorx());
            System.out.println(mapTileNum[getcorx()+1][getcory()+1]);
            seta_direita = true;
            posicaoX += velocidade;
           
            
        }
        
        if((setas.getKeyCode() == KeyEvent.VK_A) || (setas.getKeyCode() == KeyEvent.VK_LEFT)){
            System.out.print(getcory() + " ");
            System.out.println(getcorx());
            System.out.println(mapTileNum[getcorx()][getcory()+1]);
            seta_esquerda = true;
            posicaoX -= velocidade;
        
        }

        if((setas.getKeyCode() == KeyEvent.VK_S) || (setas.getKeyCode() == KeyEvent.VK_DOWN)){
            System.out.print(getcory() + " ");
            System.out.println(getcorx());
            System.out.println(mapTileNum[getcorx()][getcory()+1]);
            seta_baixo = true;
            posicaoY += velocidade;
           
        }
        
    }
    @Override
    //quando teclas são soltas
    public void keyReleased(KeyEvent soltas){
        if((soltas.getKeyCode() == KeyEvent.VK_W) || (soltas.getKeyCode() == KeyEvent.VK_UP)){
            seta_cima = false;
        }
        if((soltas.getKeyCode() == KeyEvent.VK_D) || (soltas.getKeyCode() == KeyEvent.VK_RIGHT)){
            seta_direita = false;
        }
        
        if((soltas.getKeyCode() == KeyEvent.VK_A) || (soltas.getKeyCode() == KeyEvent.VK_LEFT)){
            seta_esquerda = false;
        }

        if((soltas.getKeyCode() == KeyEvent.VK_S) || (soltas.getKeyCode() == KeyEvent.VK_DOWN)){
            seta_baixo = false;
        }
    
    
    }
    @Override
    //resulta em um caractere
    public void keyTyped(KeyEvent caractere){
        
    }
    public int getcorx(){
        return posicaoX/tileSize;
    }
    public int getcory(){
        return posicaoY/tileSize;
    }
    public void setmapTileNum(int mapTileNum[][]){
        this.mapTileNum = mapTileNum;
    }
    public void setijolos(Tijolos tile[]){
        this.tile = tile;
    }
    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public boolean getSeta(){
        return seta_baixo;
    }   
}
