package es.dampro.unidad2.tarea6;

/**
 * TODO: documenta el propósito y la responsabilidad de la clase MayorNumero.
 */
public final class MayorNumero {

    private MayorNumero() {
        // Clase de algoritmos estáticos.
    }

    /**
     * TODO: explica el algoritmo y su comportamiento con datos límite.
     * @param numeros Dato de entrada que debe cumplir el contrato del enunciado.
     * @return Valor máximo de la secuencia.
     */
    public static int obtenerMayor(String numeros) {
        // TODO: implementa el algoritmo sin sustituirlo por una función que lo resuelva directamente.
        // throw new UnsupportedOperationException("Método pendiente de implementar: obtenerMayor");

        if (numeros == null || numeros.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < numeros.length(); i++) {
            char numero = numeros.charAt(i);

        }
        throw new UnsupportedOperationException("Método pendiente de implementar: obtenerMayor");
    }
}
