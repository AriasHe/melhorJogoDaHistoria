package com.melhorJogoDaHistoria.engine;

import java.util.Random;

public class Dados {
    
    Random gerador = new Random();
    public  int dados(int atributo, Tempo time,int tempo){
        int dado;
        int acertos = 0;
        for(int i=0; i<atributo; i++){
            dado = gerador.nextInt(6)+1;
            if(dado > 4){
                acertos++;
            }else{
            }
            System.out.println("tirou "+ dado+" no seu dado n°" + (i+1));
            time.tempo(tempo);
        }
            System.out.println("teve "+ acertos + " acertos");
            return acertos;
    }
}
