/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.task.puzzle8;

import java.util.Random;

/**
 *
 * @author willi
 */
public class JogoPuzzle {
 
    public int[] tabuleiro;
    public int casaVazia;
    public boolean completo;

    public JogoPuzzle() {
        this.completo = false;
        this.casaVazia = 8;
        this.tabuleiro = new int[9];
        this.IniciarJogo();
    }

    public boolean isCompleto() {
        return completo;
    }
    
    private void IniciarJogo() {
        int[] marc = new int[9];
        for(int i=0; i<9; i++){
            marc[i]=0;
            this.tabuleiro[i]=0;
        }
        Random random = new Random();
        for(int i=0; i<8; i++){
            int num = 0;
            do{
                num = random.nextInt(9);
                if(num != 0 && marc[num] == 0){                    
                    marc[num] = 1;
                    this.tabuleiro[i] = num;
                }
            } while(this.tabuleiro[i] == 0);
        }
    }
    
    public void ImprimeTabuleiro(){
        String[] imprime = new String[9];
        for(int i=0; i<9; i++){
            if(this.tabuleiro[i] == 0) imprime[i]=" ";
            else imprime[i] = String.valueOf(tabuleiro[i]);
        }
        for(int i=0; i<9; i+=3){
            System.out.println("| "+imprime[i]+"   "+imprime[i+1]+"   "+imprime[i+2]+" |");
        }
    }

    void Mover(String comando) {
        switch (comando) {
            case "d":
                if(casaVazia == 0 || casaVazia == 3 || casaVazia == 6) break;
                this.tabuleiro[casaVazia] = this.tabuleiro[casaVazia-1];
                this.tabuleiro[casaVazia-1] = 0;
                this.casaVazia -= 1;
                break;
            case "e":
                if(casaVazia == 2 || casaVazia == 5 || casaVazia == 8) break;
                this.tabuleiro[casaVazia] = this.tabuleiro[casaVazia+1];
                this.tabuleiro[casaVazia+1] = 0;
                this.casaVazia += 1;
                break;
            case "c":
                if(casaVazia > 5) break;
                this.tabuleiro[casaVazia] = this.tabuleiro[casaVazia+3];
                this.tabuleiro[casaVazia+3] = 0;
                this.casaVazia += 3;
                break;
            case "b":
                if(casaVazia < 3) break;
                this.tabuleiro[casaVazia] = this.tabuleiro[casaVazia-3];
                this.tabuleiro[casaVazia-3] = 0;
                this.casaVazia -= 3;
                break;
            default:
                System.out.println("\nComando inválido!\n");
        }
    }

    int verificaCompletude() {
        for(int i=0; i<8; i++){
            if(this.tabuleiro[i] != i+1) return 0;
        }
        this.completo = true;
        return 1;
    }
}
