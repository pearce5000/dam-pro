package es.educacion.arrays;

// Ejercicio 12. Devuelve una copia rotada a la derecha el número no negativo de posiciones. Vacío devuelve vacío. No modifica el original. Null o posiciones negativas: IllegalArgumentException.
// TODO: escribir el Javadoc de la clase, del método, sus parámetros y retorno.
public final class Ejercicio12RotarDerecha {
    private Ejercicio12RotarDerecha() { }

    // Contrato: Devuelve una copia rotada a la derecha el número no negativo de posiciones. Vacío devuelve vacío. No modifica el original. Null o posiciones negativas: IllegalArgumentException.
    public static int[] rotar(int[] numeros, int posiciones) {
        if (numeros == null) {
            throw new IllegalArgumentException();
        }
        if (numeros.length == 0) {
            return new int[]{};
        }
        int[] resultado = new int[numeros.length +2];
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            resultado[i+2] = numero;
        }

        return resultado;
    }
}
