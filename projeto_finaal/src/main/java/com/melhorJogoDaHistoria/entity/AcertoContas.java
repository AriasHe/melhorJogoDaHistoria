package com.melhorJogoDaHistoria.entity;
import java.util.Random;

import com.melhorJogoDaHistoria.Movimento;

public class AcertoContas {
    Random gerador = new Random();
    Entity personagem;
    Entity monstro = new Monstro();
    //Escolha teste = new Escolha();
    int escolha = 2,tileSize;
    Movimento a;

    public AcertoContas(int tileSize){
        this.tileSize = tileSize;
    }

    public Entity teste(int escolha){
        this.escolha = escolha;
        //escolha = teste.pegEscolha();
        if(escolha == 1){
            //System.out.println("teste2");
            personagem = new Bruxo(tileSize);
        }else{
            if(escolha == 2){
                //System.out.println("ladino");
                 personagem = new Guerreiro(tileSize);
            }else{
            if(escolha == 3){
                //System.out.println("ladino");
                 personagem = new Bardo(tileSize);
            }
        }
        }
        personagem.atributos();
        //System.out.println(escolha);
        return personagem;
    }
    public Entity retorno(){
        return teste(escolha);
    }

    public void encontro_monstro(){
        monstro.atributos();
        retorno().atributos();
        System.out.println("");
        System.out.println("Você encontra um monstro, mas não um simples monstro você encontra " + monstro.nome );
        System.out.println("");
        monstro.apresentacao();
        tempo(5000);
        System.out.println("");
        System.out.println("Assim começaremos a baralha, o numero de dados que você irá jogar será a sua forca no caso " + retorno().forca );
        tempo(5000);
        int acertos = dados(retorno().forca);
        System.out.println("");
        if(acertos >= monstro.defesa){
            tempo(4000);
            System.out.println("O seu numero de acertos é maior ou igual a defesa do "+ monstro.nome +", então voce ataca com "+retorno().ataque+" dano");
            retorno().ataque();
            tempo(4000);
            monstro.vida = monstro.vida - (retorno().ataque - monstro.defesa);
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
        if(acertos_monstro >= retorno().defesa){
            System.out.println("O numero de acertos é maior ou igual a sua defesa, então ele te ataca com "+monstro.ataque+" dano");
            tempo(4000);
            monstro.ataque();
            retorno().vida = retorno().vida - (monstro.ataque - retorno().defesa);
            System.out.println( monstro.nome+ " te deixa com "+retorno().vida+ " de vida");

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
