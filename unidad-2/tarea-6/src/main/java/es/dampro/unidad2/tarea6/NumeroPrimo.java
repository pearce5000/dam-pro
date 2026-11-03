package es.dampro.unidad2.tarea6;

import java.util.Scanner;

/**
 * TODO: documenta el propósito y la responsabilidad de la clase NumeroPrimo.
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class NumeroPrimo {

    private NumeroPrimo() {
        // Clase de algoritmos estáticos.
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el numero: ");
        String sNumero = teclado.nextLine();
        boolean Primo = esPrimo(sNumero);
        System.out.println("El numero es primo: "+Primo);
    }

    /**
     * TODO: explica el algoritmo y su comportamiento con datos límite.
     * @param numero String que guarda el numero.
     * @return Verdadero si es primo; falso en otro caso.
     */
    public static boolean esPrimo(String numero) {
        // TODO: implementa el algoritmo sin sustituirlo por una función que lo resuelva directamente.
        if (numero == null || numero.isEmpty()) {
            return false;
        }
        int iNumero = Integer.parseInt(numero);

        if (iNumero < 2) {
            return false;
        }
        if (iNumero == 2 || iNumero == 3) {
            return true;
        }

        if (iNumero % 2 == 0 || iNumero % 3 == 0 || iNumero % 5 == 0 || iNumero % 7 == 0) {
            return false;
        }

        return true;

        // throw new UnsupportedOperationException("Método pendiente de implementar: esPrimo");
    }
}
