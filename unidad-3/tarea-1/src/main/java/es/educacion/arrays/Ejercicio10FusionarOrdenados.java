package es.educacion.arrays;

// Fusiona dos arrays ya ordenados ascendentemente, conservando repetidos, en un array nuevo ordenado. Null: IllegalArgumentException.
// 
// TODO: implementar el método y documentar la clase y el método mediante Javadoc.
public final class Ejercicio10FusionarOrdenados {
    private Ejercicio10FusionarOrdenados() { }

    // Fusiona dos arrays ya ordenados ascendentemente, conservando repetidos, en un array nuevo ordenado. Null: IllegalArgumentException.
    public static int[] fusionar(int[] primero, int[] segundo) {
        if (primero == null || segundo == null) {
            throw new IllegalArgumentException();
        }
        int[] resultado = new int[primero.length + segundo.length];
        /**
        for (int i = 0; i < primero.length + segundo.length; i++) {
            if (primero[i] < segundo[i]) {
                resultado[i] = primero[i];
            }
            if (primero[i] > segundo[i]) {
                resultado[i] = segundo[i];
            }
        }
         //
        int posicionPrimero = 0;
        int posicionSegundo = 0;
        for (int i = 0; i < primero.length + segundo.length; i++) {
            if (primero[posicionPrimero] < segundo[posicionSegundo]) {
                resultado[i] = primero[posicionPrimero];
                posicionPrimero++;
            }
            if (primero[posicionPrimero] > segundo[posicionSegundo]) {
                resultado[i] = segundo[posicionSegundo];
                posicionSegundo++;
            }
            if (primero[posicionPrimero] == segundo[posicionSegundo]) {
                resultado[i] = primero[posicionPrimero];
                i++;
                resultado[i] = segundo[posicionSegundo];
                posicionPrimero++;
                posicionSegundo++;
            }
        }
         */


        return resultado;
    }
}
