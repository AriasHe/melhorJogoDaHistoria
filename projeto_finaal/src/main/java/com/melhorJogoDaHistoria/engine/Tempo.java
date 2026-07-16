package com.melhorJogoDaHistoria.engine;

public class Tempo {
    
    public void tempo(int tempo){
         try {
            Thread.sleep(tempo); // 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
