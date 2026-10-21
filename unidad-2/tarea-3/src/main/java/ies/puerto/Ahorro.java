package ies.puerto;

import java.sql.SQLOutput;
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
        float ahorroInicial = 0;
        do {
            System.out.print("¿Cuánto dinero tienes ahorrado? ");
            ahorroInicial = teclado.nextFloat();
            if (ahorroInicial < 0) {
                System.out.println("Error: el ahorro no puede ser negativo");
            }
        } while (ahorroInicial < 0);


        float ahorroActual = ahorroInicial;
        float aportacion = 0;
        float totalAportado = 0;
        int numeroAportaciones = 0;

        System.out.println("Hola, "+nombre);
        String opcion;
        do {
            do {
                System.out.println("Introduce una cantidad para ahorrar: ");
                aportacion = teclado.nextFloat();
                if (aportacion > 0) {
                    break;
            }
                System.out.println("Cantidad no válida");
            } while (aportacion <= 0);

            ahorroActual = ahorroActual+aportacion;
            totalAportado = totalAportado+aportacion;
            numeroAportaciones++;

            System.out.println("Aportación registrada. Ahorro actual: "+ahorroActual+" euros");
            System.out.println("¿Desea hacer otra aportación? (S/N): ");
            opcion = teclado.nextLine();

        } while (opcion.equalsIgnoreCase("S"));

        System.out.println("===================");
        System.out.println("RESUMEN DEL AHORRO");
        System.out.println("===================");
        System.out.println("Usuario: "+nombre);
        System.out.println("Ahorro inicial: "+ahorroInicial+ " euros");
        System.out.println("Aportaciones realizadas: "+numeroAportaciones);
        System.out.println("Total aportado: "+totalAportado+ " euros");
        System.out.println("Ahorro final: "+ahorroActual+ " euros");

        // Pedir nombre y ahorro inicial.
        // Preparar acumuladores y contador.
        // Repetir aportaciones mediante do-while.
        // Mostrar resumen.

        teclado.close();
    }
}
