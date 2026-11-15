package es.educacion.arrays;

import java.util.Arrays;

// Devuelve una copia desde inicio (incluido) hasta fin (excluido). Usa índices válidos con 0 <= inicio <= fin <= length. Intervalo inválido: IllegalArgumentException. Null: IllegalArgumentException.
// 
// TODO: implementar el método y documentar la clase y el método mediante Javadoc.
public final class Ejercicio08CopiarRango {
    private Ejercicio08CopiarRango() { }

    // Devuelve una copia desde inicio (incluido) hasta fin (excluido). Usa índices válidos con 0 <= inicio <= fin <= length. Intervalo inválido: IllegalArgumentException. Null: IllegalArgumentException.
    public static int[] copiarRango(int[] numeros, int inicio, int fin) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] resultado = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            if (numero >= inicio) {
                if (numero <= fin) {
                    break;
                }
                resultado[i] = numero;
            }
        }

        return resultado;
    }
}
