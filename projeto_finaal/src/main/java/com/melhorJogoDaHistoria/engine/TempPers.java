package com.melhorJogoDaHistoria.engine;

public class TempPers {
    public void tempo(double  nextDrawTime, double  drawInterval){
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

    }
    
}
