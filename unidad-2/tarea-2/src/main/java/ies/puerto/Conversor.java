package ies.puerto;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */

public class Conversor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float resultado = 0;
        float numeroKilometro = 0;
        int opcion = 0;
        System.out.println("==================");
        System.out.println("CONVERSOR DAM-PRO");
        System.out.println("==================");
        System.out.print("Introduce tu nombre: ");
        String nombre = teclado.nextLine();

        while (opcion != 4) {
            System.out.println("Bienvenida/o, "+nombre);
            System.out.println("1. Kilómetros a metros");
            System.out.println("2. Metros a centímetros");
            System.out.println("3. Kilómetros a millas");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el numero de kilómetros");
                    numeroKilometro = teclado.nextFloat();
                    resultado = kilometroAMetro(numeroKilometro);
                    System.out.println(resultado+" metros");
                case 2:

                case 3:

            }
        }
        // 1. Solicitar el nombre del usuario.
        // 2. Declarar opción y contador de conversiones.
        // 3. Crear el bucle while del menú.
        // 4. Seleccionar y realizar cada conversión.
        // 5. Validar las distancias negativas.
        // 6. Mostrar el resumen al salir.

        teclado.close();
    }

    /**
     *
     * @param numeroKilometro
     * @return
     */
    static float kilometroAMetro(float numeroKilometro) {return numeroKilometro*1000;}
}