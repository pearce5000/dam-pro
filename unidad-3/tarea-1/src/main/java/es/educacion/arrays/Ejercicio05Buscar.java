package es.educacion.arrays;

/**
 * Muestra la posicion de un numero especifico en una lista
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class Ejercicio05Buscar {
    private Ejercicio05Buscar() { }

    public static void main(String[] args) {
        int[] numeros = {1,5,7,9,10};
        int objetivo = 9;
        int posicion = buscar(numeros, objetivo);
        System.out.println("La posicion del numero es: "+posicion);
    }

    /**
     * Encuentra la posicion de un numero especifico en una lista
     * @param numeros int[] lista de numeros
     * @param objetivo int numero a buscar
     * @return int posicion del numero
     */
    public static int buscar(int[] numeros, int objetivo) {
        if (numeros == null || numeros.length == 0) {
            return -1;
        }
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            if (numero == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
