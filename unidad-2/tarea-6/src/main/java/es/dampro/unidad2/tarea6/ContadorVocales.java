package es.dampro.unidad2.tarea6;

/** TODO: documenta la finalidad de la clase. */
public final class ContadorVocales {
    private ContadorVocales() { }

    /**
     * TODO: describe cómo se realiza el algoritmo.
     * @param texto Documenta el parámetro.
     * @return Documenta el valor devuelto.
     */
    public static int contarVocales(String texto) {
        // throw new UnsupportedOperationException("Método pendiente de implementar: sumarDigitos");

        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        int resultado = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (caracter == 'a' || caracter == 'á'  || caracter == 'e' || caracter == 'é' || caracter == 'i'
                || caracter == 'í' ||  caracter == 'o' || caracter == 'ó'  || caracter == 'u' || caracter == 'ú') {
                resultado = resultado + 1;
            }
        }
        return resultado;
    }
}

