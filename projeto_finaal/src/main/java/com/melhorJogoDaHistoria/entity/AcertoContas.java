package com.melhorJogoDaHistoria.entity;
import java.util.Random;

import com.melhorJogoDaHistoria.Dialogos;

public class AcertoContas {
    Random gerador = new Random();
    Entity monstro = new Monstro();
    Dialogos dialogo;
    int tileSize;

    public AcertoContas(Dialogos dialogo){
        this.dialogo = dialogo;
    }

    
  
    public void encontro_monstro(Entity personagem){
        monstro.atributos();
       
        dialogo.escrever(personagem.apresentacao());  
         //dialogo.atualizarTexto((personagem.texto));
        //System.out.println(personagem);
        System.out.println("");
        System.out.println("Você encontra um monstro, mas não um simples monstro você encontra " + monstro.nome );
        System.out.println("");
        monstro.apresentacao();
        tempo(5000);
        System.out.println("");
        System.out.println("Assim começaremos a baralha, o numero de dados que você irá jogar será a sua forca no caso " + personagem.forca );
        tempo(5000);
        int acertos = dados(personagem.forca);
        System.out.println("");
        if(acertos >= monstro.defesa){
            tempo(4000);
            System.out.println("O seu numero de acertos é maior ou igual a defesa do "+ monstro.nome +", então voce ataca com "+personagem.ataque+" dano");
            personagem.ataque();
            tempo(4000);
            monstro.vida = monstro.vida - (personagem.ataque - monstro.defesa);
            System.out.println("Você acaba deixando "+ monstro.nome+ "com "+monstro.vida+ " de vida");
            tempo(10000);
        }else{
            System.out.println("Você erra o ataque!!! Deixando nas mãos de " + monstro.nome + " o próximo ataque" );
        } 
        tempo(5000); 
        System.out.println("Agora é a vez de " + monstro.nome + " realizar seu ataque");
        tempo(4000);
        System.out.println("Ele tem " + monstro.forca + " de força");
        tempo(4000);
        int acertos_monstro = dados(monstro.forca);
        if(acertos_monstro >= personagem.defesa){
            System.out.println("O numero de acertos é maior ou igual a sua defesa, então ele te ataca com "+monstro.ataque+" dano");
            tempo(4000);
            monstro.ataque();
            personagem.vida = personagem.vida - (monstro.ataque - personagem.defesa);
            System.out.println( monstro.nome+ " te deixa com "+personagem.vida+ " de vida");

        }else{
            System.out.println(monstro.nome+"Erra o ataque!!! Não te dando dano!" );
        } 
    }   

        
    public  int dados(int atributo){
        int dado;
        int acertos = 0;
        boolean passou;
        for(int i=0; i<atributo; i++){
            dado = gerador.nextInt(6)+1;
            if(dado > 4){
                acertos++;
                passou = true;
            }else{
                passou = false;
            }
            System.out.println("tirou "+ dado+" no seu dado n°" + (i+1));
            tempo(3000);
        }
        System.out.println("teve "+ acertos + " acertos");
        return acertos;
    }

    public void tempo(int tempo){
         try {
            Thread.sleep(tempo); // 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
