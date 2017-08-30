/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodedamas;

/**
 *
 * @author hgcgo
 */
public class Regra {
    public static Peca PecaBrancaNoJogo()
    {
        return new Peca(ECorDaPeca.BRANCA,ESituacaoDaPeca.ESTAH_NO_JOGO);
    }
    
    public static Peca PecaPretaNoJogo()
    {
        return new Peca(ECorDaPeca.PRETA,ESituacaoDaPeca.ESTAH_NO_JOGO);
    }
    
    public static void ConstruirTabuleiro(Tabuleiro tabuleiro)
    {
        if(tabuleiro == null)
            return;
        
        if(tabuleiro.Pecas == null)
            return;
        
        // x + y = 2n é par então tem peça
        // Linhas 3 e 4 não tem peças
        // Se linha <= 3 peça branca diferente é peça preta
        
        for(int x = 0; x<Tabuleiro.Tamanho; x++)
            for(int y = 0; y<Tabuleiro.Tamanho; y++)
            {
                if( (x + y)%2 > 0 ) // x + y = 2n é par então tem peça
                    continue;
                else if( x > 2 && x < 5) // Linhas 3 e 4 não tem peças
                    continue;
                else // Se linha <= 3 peça branca diferente é peça preta
                    tabuleiro.Pecas[x][y] 
                            = (x > 3) ? Regra.PecaBrancaNoJogo() : Regra.PecaPretaNoJogo();
            }
    }
    
    public static void ConstruirTabuleiro()
    {
        //x + y = 2n é par então tem peça
        // Linhas 3 e 4 não tem peças
        // Se linha <= 3 peça branca diferente é peça preta
    }
    
    public static void JogadaDoComputador(Tabuleiro tabuleiro)
    {
        System.out.println(" Computador jogando...");
        
        int jogada = 0;
        
        int xo;
        int yo;
        int xd;
        int yd; 
        
        // procurar uma peça preta
        
        for(int x = 0; x < Tabuleiro.Tamanho; x++)
            for(int y = 0; y < Tabuleiro.Tamanho; y++)
                if(tabuleiro.Pecas[x][y].Cor == ECorDaPeca.PRETA && 
                        tabuleiro.Pecas[x][y].Situacao == ESituacaoDaPeca.ESTAH_NO_JOGO)
                {
                    
                    
                    Peca peca = new Peca();
                    peca.Cor = tabuleiro.Pecas[x][y].Cor;
                    peca.Situacao = tabuleiro.Pecas[x][y].Situacao;
                    
                    boolean jogou = false;
                    
                    // Primeira tentativa, mover para baixo e direita
                    jogou = tabuleiro.MoverPeca(x, y, x+1, y-1);
                    
                    System.out.println(x+" "+y);
                    
                    if(jogou) return;
                    
                    jogou = tabuleiro.MoverPeca(x, y, x-1, y-1);
                    
                    if(jogou) return;
                    
                }
        
        
    }
}
