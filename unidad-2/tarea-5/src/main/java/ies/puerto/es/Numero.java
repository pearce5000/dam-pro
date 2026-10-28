package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class Numero {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int numero1 = teclado.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int numero2 = teclado.nextInt();

        int resultado = mayor(numero1, numero2);
        System.out.println("El mayor es: "+resultado);

        int resultadoMenor = menor(numero1, numero2);
        System.out.println("El menor es: "+resultadoMenor);

        boolean igual = igual(numero1, numero2);
        System.out.println("Los numeros son iguales: "+igual);
    }


    static int mayor(int numero1, int numero2) {
        if (numero1 > numero2) {
            return numero1;
        }
        return numero2;
    }


    static int menor(int numero1, int numero2) {
        if (numero1 < numero2) {
            return numero1;
        }
        return numero2;
    }

    static boolean igual (int numero1, int numero2) {
        if (numero1 == numero2) {
            return true;
        }
        return false;
    }
}
