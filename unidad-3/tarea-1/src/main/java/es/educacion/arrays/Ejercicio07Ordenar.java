package es.educacion.arrays;

/**
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio07Ordenar {
    private Ejercicio07Ordenar() { }

    /**
     * Ordena los valores de un int[]
     * @param numeros int[] que guarda los numeros a ordenar
     * @return int[] con los valores ordenados
     */
    public static int[] ordenar(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            return new int[]{};
        }
        int[] resultado = new int [numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            resultado[i] = numeros[i];
        }
        for (int i = 0; i < numeros.length -1; i++) {
            if (resultado[i] > resultado[i+1]) {
                int numero = resultado[i];
                resultado[i] = resultado[i+1];
                resultado[i+1] = numero;
            }
        }

        return resultado;
    }
}
