package com.melhorJogoDaHistoria.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.melhorJogoDaHistoria.engine.map.Tijolos;
import com.melhorJogoDaHistoria.entity.AcertoContas;
import com.melhorJogoDaHistoria.entity.Entity;
import com.melhorJogoDaHistoria.view.EscPersonage;


public class Movimento implements KeyListener {
    protected boolean seta_cima, seta_baixo, seta_direita, seta_esquerda;
    protected int posicaoX, posicaoY, velocidade,tileSize, monstro,worldWith,wordHeight;
    AcertoContas jogo;
    EscPersonage per = new EscPersonage();
    int mapTileNum[][],x = 550,escolha = 0;
    boolean inicio = true;
    Tijolos tile[];
    Entity personagem;
    String [] texto1; 
    public Movimento (int posicaoX,int posicaoY,int velocidade, int tileSize,int worldWith, int wordHeight, AcertoContas jogo){
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.velocidade = velocidade;
        this.tileSize = tileSize;
        this.wordHeight = wordHeight;
        this.worldWith = worldWith;
        this.jogo = jogo;
    }    
    @Override
    //quando setas e teclas de controles são utilizados
    public void keyPressed(KeyEvent setas){ 
         if(escolha!= 0){
                inicio = false;
                getc();
            }
        if(posicaoX < tileSize ){
            posicaoX = tileSize;
        }
        if(posicaoY <tileSize ){
            posicaoY = tileSize;
        }
        if(posicaoX>(worldWith - 2*tileSize)){
            posicaoX = worldWith - 2*tileSize;
        }
        if(posicaoY>(wordHeight - 2*tileSize)){
            posicaoY = wordHeight - 2*tileSize;
        }
        if((setas.getKeyCode() == KeyEvent.VK_W) || (setas.getKeyCode() == KeyEvent.VK_UP)){

            if(inicio){
                if(x == 650){
                    x = 600;
                }else{
                    if(x == 600){
                        x = 550;
                    }
                }
            }else{
                monstro = mapTileNum[getcorx()][getcory()];
                if(!(tile[mapTileNum[getcorx()][getcory()]].colisao)){
                    seta_cima = true;
                    posicaoY -= velocidade;
                }
            }   
        }  
        if((setas.getKeyCode() == KeyEvent.VK_D) || (setas.getKeyCode() == KeyEvent.VK_RIGHT)){
    
            monstro = mapTileNum[getcorx()+1][getcory()+1];
            if(!(tile[mapTileNum[getcorx()+1][getcory()+1]].colisao)){
                seta_direita = true;
                posicaoX += velocidade;
            }
            
        }
        
        if((setas.getKeyCode() == KeyEvent.VK_A) || (setas.getKeyCode() == KeyEvent.VK_LEFT)){
          
            monstro = mapTileNum[getcorx()][getcory()+1];
            if(!(tile[mapTileNum[getcorx()][getcory()+1]].colisao)){
                seta_esquerda = true;
                posicaoX -= velocidade;
            }     
        }

        if((setas.getKeyCode() == KeyEvent.VK_S) || (setas.getKeyCode() == KeyEvent.VK_DOWN)){
          
            if(inicio){
                if(x == 550){
                    x = 600;
                }else{
                    if(x == 600){
                        x = 650;
                    }
                }
            }else{ 
            monstro = mapTileNum[getcorx()][getcory()+1];
            if(!(tile[mapTileNum[getcorx()][getcory()+1]].colisao)){
                seta_baixo = true;
                posicaoY += velocidade;
            }    
        }
    }
          if(setas.getKeyCode() == KeyEvent.VK_SPACE){
            if(monstro == 4){
               jogo.encontro_monstro(personagem);
                saida();
            }
        }
        if(setas.getKeyCode() == KeyEvent.VK_ENTER){
            if(inicio){
                if(x == 550){
                    escolha = 3;
                }else{
                    if(x == 600){
                        escolha = 2;
                    }else{
                        if(x == 650){
                            escolha = 1;
                        }
                    }
                }
                personagem = per.teste(escolha);
                setepersonagem();
               
                inicio = false;
                getc();
            } 
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
    public String[] saida(){
     
        return texto1;
    }

    public void getInicio(boolean inicio){
        this.inicio = inicio;
    }


    public Entity setepersonagem(){
        return personagem;
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
    public void setipersonagem(Entity personagem){
        this.personagem = personagem;
    }
    public int getPosicaoY() {
        return posicaoY;
    }
    public int setposicao(){
        return x;
    }
    public boolean getSeta(){
        return seta_baixo;
    }   
    public boolean getc(){
        
        return inicio;
    }
    public boolean getrue(){
        return true;
    }

    public void getescolha(int escolha){
        this.escolha = escolha;
    }
}
