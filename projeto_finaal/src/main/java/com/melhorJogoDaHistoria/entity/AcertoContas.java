package com.melhorJogoDaHistoria.entity;

import java.util.Random;

public class AcertoContas {
    Random gerador = new Random();
    Entity personagem;
    Entity monstro = new Monstro();
    public Entity teste(){
        int a = 1;
        if(a == 1){
            personagem = new Bruxo();
        }else{
             personagem = new Ladino();
        }
        return personagem;
    }

    public void encontro_monstro(){
        System.out.println("entrou");
        int acertos = dados(teste().forca);
        if(acertos >= monstro.defesa){
            monstro.vida = monstro.vida - (teste().ataque - monstro.defesa);
            teste().ataque();

        }  
        
        int acertos_monstro = dados(monstro.forca);
        if(acertos_monstro >= personagem.defesa){
            personagem.vida = personagem.vida - (monstro.ataque - personagem.defesa);
        }
    }   

        
    public  int dados(int atributo){
        int dado;
        int acertos = 0;
        for(int i=0; i<atributo; i++){
            dado = gerador.nextInt(6)+1;
            if(dado > 4){
                acertos++;
            }
        }
        return acertos;
    }



}
