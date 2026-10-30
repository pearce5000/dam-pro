package es.dampro.unidad2.tarea6;

/** TODO: documenta la finalidad de la clase. */
public final class MediaNumeros {
    private MediaNumeros() { }

    /**
     * TODO: describe cómo se realiza el algoritmo.
     * @param numeros Documenta el parámetro.
     * @return Documenta el valor devuelto.
     */
    public static double calcularMedia(String numeros) {
        //throw new UnsupportedOperationException("Método pendiente de implementar: calcularMedia");

        if (numeros == null || numeros.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < numeros.length(); i++) {
            char cNumero = numeros.charAt(i);
            suma = suma + cNumero;
        }
        return suma / numeros.length();
    }
}
