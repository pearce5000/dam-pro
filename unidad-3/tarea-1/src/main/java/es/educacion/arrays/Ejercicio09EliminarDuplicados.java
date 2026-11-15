package es.educacion.arrays;

import java.util.Arrays;

/**
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio09EliminarDuplicados {
    private Ejercicio09EliminarDuplicados() { }

    // Elimina los elementos repetidos preservando el orden de primera aparición. Devuelve array nuevo. Null: IllegalArgumentException.
    public static int[] sinDuplicados(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException();
        }
        if (numeros.length == 0) {
            return new int[]{};
        }

        int[] resultado = new int[0];
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];

        }
        return resultado;
    }
}
