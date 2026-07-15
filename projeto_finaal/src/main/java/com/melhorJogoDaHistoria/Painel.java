package com.melhorJogoDaHistoria;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Painel {
    Graphics2D g2;
    Font fonte;
    String texto;
    int colScreen, x,y;
    BufferedImage bruxo, guerreiro, bardo;
    public void draw(Graphics2D g2, int colScreen, int tileSize){
        y = 0;
        this.g2 = g2;
        this.colScreen = colScreen;
        try {
            InputStream is = getClass().getResourceAsStream("/fontes/x12y16pxMaruMonica.ttf");
            fonte = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        g2.setFont(fonte);        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 75F));
        

        texto = "Escolha seu personagem: ";
        x = xcentro(texto, g2);
        y += tileSize;
        g2.setColor(Color.gray);
        g2.drawString(texto,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(texto, x, y);

        try{
            bruxo = ImageIO.read(getClass().getResourceAsStream("/jogador/bruxo.png"));
        }catch(IOException e) {
           e.printStackTrace();
        }
        try{
            guerreiro = ImageIO.read(getClass().getResourceAsStream("/jogador/guerreiro.png"));
        }catch(IOException e) {
           e.printStackTrace();
        }
        try{
            bardo = ImageIO.read(getClass().getResourceAsStream("/jogador/bardo.png"));
        }catch(IOException e) {
           e.printStackTrace();
        }

        g2.drawImage(bardo,300,150,tileSize*3,tileSize*3,null);
        g2.drawImage(guerreiro,700,200,170,tileSize*2,null);
        g2.drawImage(bruxo,900,200,tileSize*2,tileSize*2,null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50F));

        y = 500;

        texto = "Bardo";
        x = xcentro(texto, g2);
        y = y +50;
        g2.drawString(texto, x, y);

        texto = "Guerreiro";
        x = xcentro(texto, g2);
        y = y + 50;
        g2.drawString(texto, x, y);

        texto = "Bruxo";
        x = xcentro(texto, g2);
        y = y + 50;
        g2.drawString(texto, x, y);
        
       
    }    
    public int xcentro(String texto,Graphics2D g2) {
        FontMetrics metrics = g2.getFontMetrics();
        int textWidth = metrics.stringWidth(texto);
        return (colScreen - textWidth) / 2;
    }
        

    }

