package Aula06_DOWHILE;

import java.util.Scanner;

/**
 *
 * @author LUISGUILHERMEDESOUZA
 */
public class MenuJogo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcaoEscolhida;

        System.out.println("\n ++ BEM-VINDO AO SISTEMA DO JOGO ++ ");

        //Inicio do ciclio DO (FAÇA)
        do {
            System.out.println("\n == MENU PRINCIPAL == ");
            System.out.println("1. Iniciar Nova Partida");
            System.out.println("2. Ver Recordes");
            System.out.println("0. Sair do Jogo");
            System.out.println("Escolha uma opção: ");

            opcaoEscolhida = sc.nextInt();

            if (opcaoEscolhida == 1) {
                System.out.println("Carregando a fase 1 ...");
            } else if (opcaoEscolhida == 2) {
                System.out.println("Seu Recorde: 999999 pontos");
            }
            //A condição WHILE (ENQUANTO) fica no final 
            //Repetir tudo ENQUANTO a opção for DIFERENTE de zero
        } while (opcaoEscolhida != 0); //
        
        System.out.println("Até mais.");
    }
}