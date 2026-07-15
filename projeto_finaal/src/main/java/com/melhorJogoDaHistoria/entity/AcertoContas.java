package com.melhorJogoDaHistoria.entity;
import java.util.Random;

public class AcertoContas {
    Random gerador = new Random();
    Entity personagem;
    Entity monstro = new Monstro();
    int escolha = 2;
    

    public Entity teste(){
        System.out.println("teste");
        
        if(escolha == 1){
            System.out.println("teste2");
            personagem = new Bruxo();
        }
        if(escolha == 2){
             personagem = new Ladino();
        }
        personagem.atributos();
        return personagem;
    }

    public void encontro_monstro(){
        monstro.atributos();
        teste().atributos();
        System.out.println("");
        System.out.println("Você encontra um monstro, mas não um simples monstro você encontra " + monstro.nome );
        System.out.println("");
        monstro.apresentacao();
        tempo(5000);
        System.out.println("");
        System.out.println("Assim começaremos a baralha, o numero de dados que você irá jogar será a sua forca no caso " + teste().forca );
        tempo(5000);
        int acertos = dados(teste().forca);
        System.out.println("");
        if(acertos >= monstro.defesa){
            tempo(4000);
            System.out.println("O seu numero de acertos é maior ou igual a defesa do "+ monstro.nome +", então voce ataca com "+teste().ataque+" dano");
            teste().ataque();
            tempo(4000);
            monstro.vida = monstro.vida - (teste().ataque - monstro.defesa);
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
        if(acertos_monstro >= teste().defesa){
            System.out.println("O numero de acertos é maior ou igual a sua defesa, então ele te ataca com "+monstro.ataque+" dano");
            tempo(4000);
            monstro.ataque();
            teste().vida = teste().vida - (monstro.ataque - teste().defesa);
            System.out.println( monstro.nome+ " te deixa com "+teste().vida+ " de vida");

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
