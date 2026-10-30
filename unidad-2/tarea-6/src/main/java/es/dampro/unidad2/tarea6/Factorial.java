package es.dampro.unidad2.tarea6;

/**
 * TODO: documenta el propósito y la responsabilidad de la clase Factorial.
 */
public final class Factorial {

    private Factorial() {
        // Clase de algoritmos estáticos.
    }

    /**
     * TODO: explica el algoritmo y su comportamiento con datos límite.
     * @param numero Dato de entrada que debe cumplir el contrato del enunciado.
     * @return Factorial del número indicado.
     */
    public static int calcularFactorial(String numero) {
        // TODO: implementa el algoritmo sin sustituirlo por una función que lo resuelva directamente.
        // throw new UnsupportedOperationException("Método pendiente de implementar: calcularFactorial");

        int iNumero = Integer.
        if (iNumero <= 1) {
            return 1;
        }
        int resultado = 1;
        for (int i = 2; i <= iNumero ; i++) {
            resultado = resultado * i;
        }
        return resultado;    }
}
