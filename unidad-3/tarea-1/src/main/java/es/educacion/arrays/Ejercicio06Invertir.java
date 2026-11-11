package es.educacion.arrays;

// Devuelve un array nuevo con los elementos en orden inverso. No modifica el original. Null: IllegalArgumentException.
// 
// TODO: implementar el método y documentar la clase y el método mediante Javadoc.
public final class Ejercicio06Invertir {
    private Ejercicio06Invertir() { }

    public static void main(String[] args) {
        int[] numeros = {4,5,8,10,15,75,2};
        int[] inversa = invertir(numeros);
        System.out.println("Lista original: "+numeros);
        System.out.println("Lista inversa: "+inversa);
    }

    // Devuelve un array nuevo con los elementos en orden inverso. No modifica el original. Null: IllegalArgumentException.
    public static int[] invertir(int[] numeros) {
        if (numeros == null) {
            return new int[]{0,0};
        }
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}
