package Aula06_DOWHILE;

import java.util.Scanner;

/**
 *
 * @author LUISGUILHERMEDESOUZA
 */
public class BiscoitoDaSorte {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int continuar;
        int contador = 0;
        
        do {
            if(contador == 0){
                System.out.println("Com grandes poderes, vem grandes responsabilidades");
            }else if(contador == 1){
                System.out.println("Não importa o quando você bata, mas o quanto você aguenta apanhar");
            }else if(contador == 2){
                System.out.println("fala 300");
            }else if(contador == 3){
                System.out.println("... um pouco mais");
            }else{
                System.out.println("não tem mais mensagem aqui");
            }
            
            contador++;
            
            System.out.println("Deseja abrir outro biscoito? 1-sim 2-não");
            continuar = sc.nextInt();
        } while (continuar == 1 || contador < 4);
        
        System.out.println("e todo mundo morreu! acabo");
        
    }
    
}
