package com.melhorJogoDaHistoria.view;

import com.melhorJogoDaHistoria.entity.Bardo;
import com.melhorJogoDaHistoria.entity.Bruxo;
import com.melhorJogoDaHistoria.entity.Entity;
import com.melhorJogoDaHistoria.entity.Guerreiro;

public class EscPersonage {
    Entity personagem;
    public Entity teste(int escolha){
        //escolha = teste.pegEscolha();
        if(escolha == 1){
            //System.out.println("teste2");
            this.personagem = new Bruxo();
        }else{
            if(escolha == 2){
                //System.out.println("ladino");
                 this.personagem = new Guerreiro();
            }else{
            if(escolha == 3){
                //System.out.println("ladino");
                 this.personagem = new Bardo();
            }
        }
        }
        
        personagem.atributos();
        //System.out.println(escolha);
        return personagem;
    
    }
}
