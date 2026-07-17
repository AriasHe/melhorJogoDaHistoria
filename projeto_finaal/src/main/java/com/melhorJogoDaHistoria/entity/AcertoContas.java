package com.melhorJogoDaHistoria.entity;

import com.melhorJogoDaHistoria.engine.Dados;
import com.melhorJogoDaHistoria.engine.SaidaDeTexto;
import com.melhorJogoDaHistoria.engine.Tempo;

public class AcertoContas {
    Tempo time = new Tempo();
    Entity monstro = new Monstro();
    Dados dado = new Dados();
    SaidaDeTexto saidaDeTexto;
    String [] texto = new String[15];
    int tileSize;
    int tempo = 4000;
    public AcertoContas(SaidaDeTexto saidaDeTexto){
        this.saidaDeTexto = saidaDeTexto;
    }
    
  
    public void  encontro_monstro(Entity personagem){
        //texto[0] = "Você encontra um monstro, mas não um simples monstro \n você encontra " + monstro.nome;  
        //texto[1] = monstro.apresentacao();
        //texto[2] = "Assim começaremos a baralha, o numero de dados que você irá jogar será a sua forca no caso " + personagem.forca;

        System.out.println("Você encontra um monstro, mas não um simples monstro você encontra " + monstro.nome);
        time.tempo(tempo);
        System.out.println(monstro.apresentacao());
        time.tempo(tempo);
        System.out.println("Assim começaremos a baralha, o numero de dados que você irá jogar será a sua forca no caso " + personagem.forca);

        int acertos = dado.dados(personagem.forca,time,tempo);
        if(acertos >= monstro.defesa){
            
            System.out.println("O seu numero de acertos é maior ou igual a defesa do "+ monstro.nome +", então voce ataca com "+personagem.ataque+" dano");
            time.tempo(tempo);
            personagem.ataque();
            time.tempo(tempo);
            monstro.tomarDano(personagem);
            System.out.println("Você acaba deixando "+ monstro.nome+ "com "+monstro.vida+ " de vida");
           time.tempo(tempo);
        }else{
            System.out.println("Você erra o ataque!!! Deixando nas mãos de " + monstro.nome + " o próximo ataque" );
            time.tempo(tempo);
        } 
        
        System.out.println("Agora é a vez de " + monstro.nome + " realizar seu ataque");
        time.tempo(tempo);
        System.out.println("Ele tem " + monstro.forca + " de força");
        time.tempo(tempo);
        int acertos_monstro = dado.dados(monstro.forca,time,tempo);
        if(acertos_monstro >= personagem.defesa){
            System.out.println("O numero de acertos é maior ou igual a sua defesa, então ele te ataca com "+monstro.ataque+" dano");
            time.tempo(tempo);
            monstro.ataque();
            personagem.defesa();
            personagem.tomarDano(monstro);
            System.out.println( monstro.nome+ " te deixa com "+personagem.vida+ " de vida");
            time.tempo(tempo);
        }else{
            System.out.println(monstro.nome+"Erra o ataque!!! Não te dando dano!" );
            time.tempo(tempo);
        }  
    }   

}
