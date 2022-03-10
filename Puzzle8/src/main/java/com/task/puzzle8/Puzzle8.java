/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.task.puzzle8;

import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Puzzle8 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Começando 8-Puzzle");
        JogoPuzzle jogo = new JogoPuzzle();
        while(!jogo.isCompleto()){
            System.out.println("");
            jogo.ImprimeTabuleiro();
            System.out.println("\n[d] Direita\t[e] Esquerda\n[c] Acima\t[b] Abaixo");
            System.out.println("Próxima ação:");
            jogo.Mover(scan.nextLine());
            jogo.verificaCompletude();
        }
    }
}
