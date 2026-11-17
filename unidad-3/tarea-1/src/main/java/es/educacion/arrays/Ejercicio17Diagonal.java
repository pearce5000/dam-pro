package es.educacion.arrays;

/**
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio17Diagonal {
    private Ejercicio17Diagonal() { }


    public static int sumarDiagonal(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException();
        }
        int filas = matriz.length;
        int resultado = 0;
        for (int i = 0; i < filas; i++) {
            int[] fila = matriz[i];
            if (fila == null || matriz[i].length != filas) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    resultado += matriz[i][j];
                    break;
                }
            }
        }

        return resultado;
    }
}
