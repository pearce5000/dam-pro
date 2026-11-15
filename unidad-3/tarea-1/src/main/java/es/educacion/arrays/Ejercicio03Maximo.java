package es.educacion.arrays;

/**
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio03Maximo {
    private Ejercicio03Maximo() { }

    /**
     * Identifica el numero de mayor valor de un int[]
     * @param numeros int[] que guarda los numeros
     * @return int que guarda el numero de mayor valor
     */
    public static int maximo(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException();
        }
        int numeroMayor = numeros[0];
        for (int numero : numeros) {
            if (numeroMayor < numero) {
                numeroMayor = numero;
            }
        }
        return numeroMayor;
    }
}
