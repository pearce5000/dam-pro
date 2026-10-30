package es.dampro.unidad2.tarea6;

/**
 * TODO: documenta el propósito y la responsabilidad de la clase Palindromo.
 */
public final class Palindromo {

    private Palindromo() {
        // Clase de algoritmos estáticos.
    }

    /**
     * TODO: explica el algoritmo y su comportamiento con datos límite.
     * @param texto Dato de entrada que debe cumplir el contrato del enunciado.
     * @return Resultado de la comprobación sin distinguir mayúsculas ni espacios.
     */
    public static boolean esPalindromo(String texto) {
        // TODO: implementa el algoritmo sin sustituirlo por una función que lo resuelva directamente.
        // throw new UnsupportedOperationException("Método pendiente de implementar: esPalindromo");

        if (texto == null || texto.isEmpty()) {
            return false;
        }

        texto = texto.toLowerCase(); // Transforma el contenido a minúscula
        texto = texto.replace(" ",""); // Hace que los espacios no existan

        for (int i = 0; i < texto.length(); i++) {
            char letraIzquieda = texto.charAt(i);
            char letraDerecha = texto.charAt(texto.length()-1-i);
            if (letraIzquieda != letraDerecha) {
                return false;
            }
        }
        return true;
    }
}
