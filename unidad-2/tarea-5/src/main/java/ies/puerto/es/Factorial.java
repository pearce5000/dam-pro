package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class Factorial {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int numero = teclado.nextInt();
        int resultado = calcular(numero);
        System.out.println("El factorial es: "+resultado);
    }

    /**
     * Calcula el factorial de un numero dado
     * @param numero int para el calculo del factorial
     * @return int con el resultado
     */
    static int calcular(int numero) {
        if (numero <= 1) {
            return 1;
        }
        int resultado = 1;
        for (int i = 2; i <= numero ; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }
}
