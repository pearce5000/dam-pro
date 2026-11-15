package es.educacion.arrays;

// Ejercicio 11. Cuenta los elementos pares, incluidos cero y negativos. Array vacío: 0. Null: IllegalArgumentException.
// TODO: escribir el Javadoc de la clase, del método, sus parámetros y retorno.
public final class Ejercicio11ContarPares {
    private Ejercicio11ContarPares() { }

    // Contrato: Cuenta los elementos pares, incluidos cero y negativos. Array vacío: 0. Null: IllegalArgumentException.
    public static int contarPares(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException();
        }
        if (numeros.length == 0) {
            return 0;
        }

        int numerosPares = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                numerosPares++;
            }
        }
        return numerosPares;
    }
}
