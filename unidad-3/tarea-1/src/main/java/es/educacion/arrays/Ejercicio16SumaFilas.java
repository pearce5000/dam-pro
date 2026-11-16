package es.educacion.arrays;

/**
 * Se suman las filas de una matriz
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio16SumaFilas {
    private Ejercicio16SumaFilas() { }

    /**
     * Suma las filas de una matriz y las guarda en un nuevo int []
     * @param matriz int[][] que guarda la matriz
     * @return int [] que guarda las sumas de los valores
     */
    public static int[] sumarFilas(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException();
        }
        int[] resultado = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            int[] fila = matriz[i];
            if (fila == null) {
                throw new IllegalArgumentException();
            }
            /**
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += j;
            }
             **/
            for (int columna : fila) {
                sumaFila += columna;
            }
            resultado[i] = sumaFila;
        }

        return resultado;
    }
}
