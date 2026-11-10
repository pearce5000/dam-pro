package es.educacion.arrays;

/**
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio01Sumar {
    private Ejercicio01Sumar() { }

    public static void main(String[] args) {
        int [] elementos = new int[6]; // |0|0|0|0|0|0|
        elementos[0] = 7; // [0] (posicion) = 7 (valor)
        elementos[1] = 8; // [1] (posicion) = 8 (valor)
        elementos[2] = 2; // [2] (posicion) = 2 (valor)
        elementos[3] = 3; // [3] (posicion) = 3 (valor)
        elementos[4] = 414; // [4] (posicion) = 414 (valor)
        elementos[5] = 280; // [5] (posicion) = 280 (valor)
        // elementos = |7|8|2|3|414|280|

        int [] numeros = {7,8,2,3,414,280}; // numeros = |7|8|2|3|414|280|
        int sumaElementos = sumar(elementos);
        System.out.println("La suma de los elementos es = "+sumaElementos);
    }

    /**
     * Calcula la suma de todos los numeros de un array
     * @param numeros int[] de enteros
     * @return int suma de todos los numeros
     * @exception IllegalArgumentException
     */
    public static int sumar(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("El array es nulo o vacio");
        }
        if (numeros.length == 0) {
            return 0;
        }
        int suma = 0;
        for (int numero : numeros) {
            suma = suma + numero;
        }

        return suma;
    }
}
