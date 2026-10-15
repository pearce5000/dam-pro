package ies.puerto;

import java.util.Scanner;

/**
 * @author Daniel Morales González
 * @version 1.0.0
 */
public class Ahorro {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("====================");
        System.out.println("Simulador de ahorro");
        System.out.println("====================");
        System.out.print("Introduce tu nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Hola, "+nombre);
        System.out.print("¿Cuánto dinero tienes ahorrado? ");
        float ahorro = teclado.nextFloat();
        do {
            System.out.println("¿Desea hacer una aportación? (S/N): ");
            String opcion;
            if ()


        } while ()






        // Pedir nombre y ahorro inicial.
        // Preparar acumuladores y contador.
        // Repetir aportaciones mediante do-while.
        // Mostrar resumen.

        teclado.close();
    }
}
