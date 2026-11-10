package es.educacion.arrays;

// Ejercicio 15: documentación Javadoc. Añade Javadoc descriptivo a la clase y ambos métodos.
// Describe su finalidad y documenta cada parámetro y valor de retorno.
public final class Ejercicio15Documentar {
    private Ejercicio15Documentar() { }

    // Número de elementos (un array nulo no está permitido).
    public static int longitud(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("Array nulo");
        }
        return numeros.length;
    }

    // Indica si el array contiene algún elemento (un array nulo no está permitido).
    public static boolean tieneElementos(int[] numeros) {
        return longitud(numeros) > 0;
    }
}
