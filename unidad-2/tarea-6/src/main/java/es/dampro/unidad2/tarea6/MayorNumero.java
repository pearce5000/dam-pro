package es.dampro.unidad2.tarea6;

import java.util.Scanner;

/**
 * TODO: documenta el propósito y la responsabilidad de la clase MayorNumero.
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class MayorNumero {

    private MayorNumero() {
        // Clase de algoritmos estáticos.
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca los numeros: ");
        String sNumeros = teclado.nextLine();
        int mayor = obtenerMayor(sNumeros);
        System.out.println("El numero mayor es: "+mayor);
    }

    /**
     * TODO: explica el algoritmo y su comportamiento con datos límite.
     * @param numeros String que guarda la secuencia de numeros.
     * @return int que guarda el mayor valor de la secuencia.
     */
    public static int obtenerMayor(String numeros) {
        // TODO: implementa el algoritmo sin sustituirlo por una función que lo resuelva directamente.

        if (numeros == null || numeros.isEmpty()) {
            return 0;
        }
        int mayor = 0;
        for (int i = 0; i < numeros.length(); i++) {
            char cNumero = numeros.charAt(i);
            String sNumero = String.valueOf(cNumero);
            int iNumero = Integer.parseInt(sNumero);
            if (mayor < iNumero) {
                mayor = iNumero;
            }
        }
        return mayor;
        // throw new UnsupportedOperationException("Método pendiente de implementar: obtenerMayor");
    }
}
