package com.melhorJogoDaHistoria.view;

import com.melhorJogoDaHistoria.entity.Bardo;
import com.melhorJogoDaHistoria.entity.Bruxo;
import com.melhorJogoDaHistoria.entity.Entity;
import com.melhorJogoDaHistoria.entity.Guerreiro;

public class EscPersonage {
    Entity personagem;
    public Entity teste(int escolha){

        if(escolha == 1){
            this.personagem = new Bruxo();
        }else{
            if(escolha == 2){
                 this.personagem = new Guerreiro();
            }else{
            if(escolha == 3){
                 this.personagem = new Bardo();
            }
            }
        }
        return personagem;
    }
}
