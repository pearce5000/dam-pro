package es.educacion.arrays;

/**
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio06Invertir {
    private Ejercicio06Invertir() { }

    /**
     * Invierte un int[] y da el resultado
     * @param numeros int[] que guarda los numeros originales
     * @return int[] invertido
     */
    public static int[] invertir(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            return new int[]{};
        }
        int[] resultado = new int [numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            resultado[i] = numeros[numeros.length - 1 - i];
        }
        
        return resultado;
    }
}
