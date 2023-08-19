
package EstructurasDeControl;

import java.util.Scanner;

public class LabComp2Practicas_Soto_Martin {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] num = new int[3];
        int i = 0;
        System.out.println("||Este programa solicita tres numeros(ENTEROS) y los muestra"
        +" de manera ordenada||"
        +"\n--------------------------------------------------------------------------------");
        
            while(i<3){//Solicitud de valores al usuario.
                System.out.print("Ingrese un numero entero : >>> ");
                num[i] = sc.nextInt();
                i++;
            }
        int aux;
        
        for (i = 1; i <= num.length; i++) {//Ordenamiento de numero
            for (int j = 0; j< num.length -1; j++) {
                if (num[j] > num[j+1]) {
                    aux = num[j];
                    num[j] = num[j+1];
                    num[j+1] = aux;
                }
            
            }
        }
        System.out.println("\n||Numeros ordenados||"//Despliegue de numeros ordenados en pantalla
        +"\n---------------------");
        for(i = 0; i <= num.length-1; i++){
            System.out.println("Valor en posicion "+i+" : >>> "+num[i]);
        }
        System.out.println("\nFin\n");
    }
}
