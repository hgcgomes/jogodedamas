/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodedamas;

import java.util.Scanner;

/**
 *
 * @author hgcgo
 */
public class JogoDeDamas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.ConstruirTabuleiro();
        //tabuleiro.MoverEhCapturarPeca(3, 5, 5, 3);
        tabuleiro.MostrarPecas();
        
        int jogada;
        int xo;
        int yo;
        int xd;
        int yd;        
        
        Scanner scanner;
        
        while(true)
        {
            // Capturar as coordenadas e tipo de jogada do branco
            // Tipo de Jogada, xo, yo, xd, yd
            
            System.out.println(" BRANCO ");
            
            System.out.print("   J: ");
            scanner = new Scanner(System.in);
            jogada = scanner.nextInt();
            
            System.out.print("   XO: ");
            scanner = new Scanner(System.in);
            xo = scanner.nextInt();
                        
            System.out.print("   YO: ");
            scanner = new Scanner(System.in);
            yo = scanner.nextInt();
                        
            System.out.print("   XD: ");
            scanner = new Scanner(System.in);
            xd = scanner.nextInt();
                        
            System.out.print("   YD: ");
            scanner = new Scanner(System.in);
            yd = scanner.nextInt();
            
            if(jogada == 0)
            {
                tabuleiro.MoverPeca(xo, yo, xd, yd);
                tabuleiro.MostrarPecas();
            }
            else if (jogada == 1)
            {
                tabuleiro.MoverEhCapturarPeca(xo, yo, xd, yd);
                tabuleiro.MostrarPecas();
            }
            else 
            {
                return;
            }
            
            
            
            // Capturar as coordenadas e tipo de jogada do preto
            // Tipo de Jogada, xo, yo, xd, yd
            
            System.out.println(" PRETO ");
            
            Regra.JogadaDoComputador(tabuleiro);
            tabuleiro.MostrarPecas();
            
            /*
            System.out.print("   J: ");
            scanner = new Scanner(System.in);
            jogada = scanner.nextInt();
            
            System.out.print("   XO: ");
            scanner = new Scanner(System.in);
            xo = scanner.nextInt();
                        
            System.out.print("   YO: ");
            scanner = new Scanner(System.in);
            yo = scanner.nextInt();
                        
            System.out.print("   XD: ");
            scanner = new Scanner(System.in);
            xd = scanner.nextInt();
                        
            System.out.print("   YD: ");
            scanner = new Scanner(System.in);
            yd = scanner.nextInt();
            
            if(jogada == 0)
            {
                tabuleiro.MoverPeca(xo, yo, xd, yd);
                tabuleiro.MostrarPecas();
            }
            else if (jogada == 1)
            {
                tabuleiro.MoverEhCapturarPeca(xo, yo, xd, yd);
                tabuleiro.MostrarPecas();
            }
            else 
            {
                return;
            }
            */
        }
        
        
    }
    
}
