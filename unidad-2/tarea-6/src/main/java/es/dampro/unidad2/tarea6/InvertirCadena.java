package es.dampro.unidad2.tarea6;

/**
 * TODO: documenta el propósito y la responsabilidad de la clase InvertirCadena.
 */
public final class InvertirCadena {

    private InvertirCadena() {
        // Clase de algoritmos estáticos.
    }

    /**
     * TODO: explica el algoritmo y su comportamiento con datos límite.
     * @param texto Dato de entrada que debe cumplir el contrato del enunciado.
     * @return Cadena invertida, conservando espacios y mayúsculas.
     */
    public static String invertir(String texto) {
        // TODO: implementa el algoritmo sin sustituirlo por una función que lo resuelva directamente.
        //throw new UnsupportedOperationException("Método pendiente de implementar: invertir");

        StringBuilder resultado = new StringBuilder();
        if (texto == null || texto.isEmpty()) {
            return resultado.toString();
        }
        for (int i = texto.length() -1; i >= 0; i--) {
            char caracter = texto.charAt(i);
            resultado.append(caracter);
        }
        return resultado.toString();
    }
}
