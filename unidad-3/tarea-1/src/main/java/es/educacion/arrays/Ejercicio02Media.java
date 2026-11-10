package es.educacion.arrays;

/**
 * Calcula la media de una lista de valores
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio02Media {
    private Ejercicio02Media() { }

    public static void main(String[] args) {
        int notas[] = {8,7,3,3,10};
        double resultado = media(notas);
        System.out.println("La media es = "+resultado);
    }

    /**
     * Calcula la media de un array de notas
     * @param notas int[] array de notas
     * @return double media de las notas
     * @exception IllegalArgumentException
     */
    public static double media(int[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("El array es nulo o vacio");
        }
        double suma = 0;
        for (int nota : notas) {
            suma = suma + nota;
        }
        double resultado = suma /notas.length;

        return resultado;
    }
}
