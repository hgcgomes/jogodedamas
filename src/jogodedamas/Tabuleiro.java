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
public class Tabuleiro {
    static int Tamanho = 8;
    static int QuantidadePecas = 12;
    Peca[][] Pecas = new Peca[Tamanho][Tamanho];
    
    public Tabuleiro()
    {
        for(int x = 0; x<Tamanho; x++)
            for(int y = 0; y<Tamanho; y++)
                Pecas[x][y] = new Peca();
    }
    
    public void ConstruirTabuleiro()
    {
        // Constroi o tabuleiro do tamanho necessário
        
        // 1. x + y = 2n é par então tem peça
        // 2. Linhas 3 e 4 não tem peças
        // 3. Se linha <= 3 peça branca; diferente é peça preta
        
        for(int x = 0; x<Tamanho; x++)
            for(int y = 0; y<Tamanho; y++)
                if((x + y)%2 == 0 && y != 3 && y != 4)
                {
                    Pecas[x][y].Situacao = ESituacaoDaPeca.ESTAH_NO_JOGO;
                    if(y < 3) Pecas[x][y].Cor = ECorDaPeca.BRANCA;
                    else Pecas[x][y].Cor = ECorDaPeca.PRETA;
                    
                    // Pecas[x][y].Cor = (y <= 3) ? ECorDaPeca.BRANCA : ECorDaPeca.PRETA;
                }
        
        
        //Regra.ConstruirTabuleiro(this);
    }
    
    public void LimparTabuleiro()
    {
        for(int x = 0; x<Tamanho; x++)
            for(int y = 0; y<Tamanho; y++)
                Pecas[x][y] = new Peca();
    }
    
    public void AdicionarPeca(int x, int y, Peca peca)
    {
        // Colocar a peça no tabuleiro
    }
    
    public void MostrarPecas()
    {
        // Mostrar peças
        
        for(int y = Tamanho - 1; y>= 0; y--)
        {
            for(int x = 0; x < Tamanho; x++)
            {
                if(Pecas[x][y].Situacao == ESituacaoDaPeca.ESTAH_NO_JOGO)
                {
                    if(Pecas[x][y].Cor == ECorDaPeca.PRETA)
                        System.out.print(" P");
                    else if(Pecas[x][y].Cor == ECorDaPeca.BRANCA)
                        System.out.print(" B");
                }
                else
                    System.out.print(" *");
                
                System.out.print("["+x+y+"]");
            }
            
            System.out.println("");
        }
    }
    
    public boolean MoverPeca(int xo, int yo, int xd, int yd)
    {
        // 1. Coordenadas precisam estar nos limites do tabuleiro
        // 2. Precisa saltar uma casa na diagonal 
        // 3. Precisa existir um local vago
        // 4.1. Se for Branca, se move para cima (y aumenta)
        // 4.2. Se for Preta, se move para baixo (y diminui)
        // 5. Diferente disso tudo não se move
        
        if(Pecas[xo][yo].Cor == ECorDaPeca.BRANCA)
        {
            if(yo + 1 == yd && (xo + 1 == xd || xo - 1 == xd))
            {
                Pecas[xd][yd].Cor = Pecas[xo][yo].Cor;
                Pecas[xd][yd].Situacao = Pecas[xo][yo].Situacao;
                
                Pecas[xo][yo].Cor = ECorDaPeca.INDEFINIDA;
                Pecas[xo][yo].Situacao = ESituacaoDaPeca.INDEFINIDA;
                
                return true;
            }
        }
        
        if(Pecas[xo][yo].Cor == ECorDaPeca.PRETA)
        {
            if(yo - 1 == yd && (xo + 1 == xd || xo - 1 == xd))
            {
                Pecas[xd][yd].Cor = Pecas[xo][yo].Cor;
                Pecas[xd][yd].Situacao = Pecas[xo][yo].Situacao;
                
                Pecas[xo][yo].Cor = ECorDaPeca.INDEFINIDA;
                Pecas[xo][yo].Situacao = ESituacaoDaPeca.INDEFINIDA;
                
                return true;
            }
        }
        
        return false;
        
    }
    
    public void MoverEhCapturarPeca(int xo, int yo, int xd, int yd)
    {
        // 1. Coordenadas precisam estar nos limites do tabuleiro
        // 2. Precisa saltar uma casa na diagonal 
        // 3. Precisa existir um local vago
        // 4.1. Se for Branca, se move para cima (y aumenta)
        // 4.2. Se for Preta, se move para baixo (y diminui)
        // 5. Diferente disso tudo não se move
        
        int flag = 2;
        
        if(
                Pecas[xo][yo].Cor == ECorDaPeca.BRANCA && 
                Pecas[(xo+xd)/2][(yo+yd)/2].Cor == ECorDaPeca.PRETA && 
                Pecas[(xo+xd)/2][(yo+yd)/2].Situacao == ESituacaoDaPeca.ESTAH_NO_JOGO)
        {
            if(yo + flag == yd && (xo + flag == xd || xo - flag == xd))
            {
                Pecas[xd][yd].Cor = Pecas[xo][yo].Cor;
                Pecas[xd][yd].Situacao = Pecas[xo][yo].Situacao;
                
                Pecas[xo][yo].Cor = ECorDaPeca.INDEFINIDA;
                Pecas[xo][yo].Situacao = ESituacaoDaPeca.INDEFINIDA;
                
                Pecas[(xo+xd)/2][(yo+yd)/2].Situacao = ESituacaoDaPeca.FORA_DO_JOGO;
            }
        }
        
        if(
                Pecas[xo][yo].Cor == ECorDaPeca.PRETA && 
                Pecas[(xo+xd)/2][(yo+yd)/2].Cor == ECorDaPeca.BRANCA && 
                Pecas[(xo+xd)/2][(yo+yd)/2].Situacao == ESituacaoDaPeca.ESTAH_NO_JOGO)
        {
            if(yo - flag == yd && (xo + flag == xd || xo - flag == xd))
            {
                Pecas[xd][yd].Cor = Pecas[xo][yo].Cor;
                Pecas[xd][yd].Situacao = Pecas[xo][yo].Situacao;
                
                Pecas[xo][yo].Cor = ECorDaPeca.INDEFINIDA;
                Pecas[xo][yo].Situacao = ESituacaoDaPeca.INDEFINIDA;
                
                Pecas[(xo+xd)/2][(yo+yd)/2].Situacao = ESituacaoDaPeca.FORA_DO_JOGO;
            }
        }
        
    }
}
