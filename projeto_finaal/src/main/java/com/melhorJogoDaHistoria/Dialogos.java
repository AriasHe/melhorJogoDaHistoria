package com.melhorJogoDaHistoria;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.InputStream;

public class Dialogos {
    Graphics2D g2;
    int tileSize,x,X,Y;
    Font fonte;
    public void caixaDialogos(Graphics2D g2, int tileSize,int colScreen){
        x = 60;
        this.g2 = g2;
        this.tileSize = tileSize;
        Color c = new Color(0,0,0,200);
        g2.setColor(c);
        g2.fillRoundRect(x, (8*x) - 20, colScreen - 2*x, 4*x, 32, 32);
        
        
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, (8*x)+5 - 20, colScreen - 2*x -10, 4*x - 10, 25, 25);
      
    }
    public void escrever(String texto){
        
        configuraFont();

        X=0;
        Y=420;
        g2.setFont(fonte);        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50F));

        X += tileSize;
        Y += tileSize;
        g2.drawString(texto, X, Y);
    }

    
    public void configuraFont() {
    try {
        InputStream is = getClass().getResourceAsStream("/fontes/x12y16pxMaruMonica.ttf");
        fonte = Font.createFont(Font.TRUETYPE_FONT, is);
    } catch (Exception e) {
        e.printStackTrace();
    }

    
    g2.setFont(fonte);        
    
     }  
}
