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
        int cantidad = 0;
        int[] resultado = new int[numeros.length];
        for (int numero : numeros) {
            boolean repetido = false;
            for (int i = 0; i < cantidad; i++) {
                if (numero == resultado[i]) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                resultado[cantidad] = numero;
                cantidad++;
            }
        }
        return Arrays.copyOf(resultado,cantidad);
    }
}
