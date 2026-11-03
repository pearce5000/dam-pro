package es.dampro.unidad2.tarea6;

/**
 * TODO: documenta el propósito y la responsabilidad de la clase SumaDigitos.
 */
public final class SumaDigitos {

    private SumaDigitos() {
        // Clase de algoritmos estáticos.
    }

    /**
     * TODO: explica el algoritmo y su comportamiento con datos límite.
     * @param numero Dato de entrada que debe cumplir el contrato del enunciado.
     * @return Suma numérica de sus dígitos.
     */
    public static int sumarDigitos(String numero) {
        // TODO: implementa el algoritmo sin sustituirlo por una función que lo resuelva directamente.
        if (numero == null || numero.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (int i = 0; i < numero.length(); i++) {
            char cNumero = numero.charAt(i);
            String sNumero = String.valueOf(cNumero);
            int iNumero = Integer.parseInt(sNumero);
            suma = suma + iNumero;
        }
        return suma;
        // throw new UnsupportedOperationException("Método pendiente de implementar: sumarDigitos");
    }
}
