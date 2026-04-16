package Aula06_DOWHILE;

import java.util.Scanner;

/**
 *
 * @author LUISGUILHERMEDESOUZA
 */
public class Somador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int soma = 0;
        char resp;
        do{
            System.out.print("Digite um valor para ser somado: ");
            int num = sc.nextInt();
            soma += num;
            System.out.println("Você quer continuar? [s ou n]");
            resp = sc.next().toLowerCase().charAt(0);
        }while(resp != 'n');
        System.out.println("A soma de todos os valores é: "+soma);
    }
}