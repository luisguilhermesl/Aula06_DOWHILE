package Aula06_DOWHILE;

import java.util.Scanner;

/**
 *
 * @author LUISGUILHERMEDESOUZA
 */
public class Papagaio {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num;
        
        do {
            System.out.println("Diga um número para o papagaio: ");
            num = sc.nextInt();
            
            if(num != 999){
                System.out.println("Papagaio diz: "+num+"!");
            }
        } while (num != 999);
        System.out.println("O papagaio foi dormir ... zzz");
    }
}