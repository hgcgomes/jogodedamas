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
public class Peca {
    ECorDaPeca Cor;
    ESituacaoDaPeca Situacao;
    
    public Peca()
    {
        Cor = ECorDaPeca.INDEFINIDA;
        Situacao = ESituacaoDaPeca.INDEFINIDA;
    }
    
    public Peca(ECorDaPeca cor, ESituacaoDaPeca situacao)
    {
        Cor = cor;
        Situacao = situacao;
    }
    
    
}
