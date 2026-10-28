package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class PalabraInversa {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce una palabra");
        String sPalabra = teclado.nextLine();
        String sInvertida = reverse(sPalabra);
        System.out.println("Palabra invertida: "+sInvertida);
    }

    /**
     * Genera una palabra o texto invertida a la original
     * @param palabra String Palabra/texto original
     * @return String Cadena invertida
     */
    static String reverse(String palabra) {
        StringBuilder resultado = new StringBuilder();
        if (palabra == null || palabra.isEmpty()) {
            return resultado.toString();
        }
        for (int i = palabra.length() -1; i >= 0; i--) {
            char caracter = palabra.charAt(i);
            resultado.append(caracter);
        }
        //palabra = almendra -> ardnemla
        return resultado.toString();
    }


    static String reverse2(String palabra) {
        StringBuilder resultado = new StringBuilder(palabra);
        return resultado.reverse().toString();
    }
}
