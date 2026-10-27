package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */

public class Anagrama {

    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la primera palabra: ");
        String sPalabra1 = teclado.nextLine();
        System.out.println("Introduce la segunda palabra: ");
        String sPalabra2 = teclado.nextLine();
        boolean bAnagrama = esAnagrama(sPalabra1, sPalabra2);
        System.out.println("Las palabras son anagramas= "+bAnagrama);
    }

    /**
     * Funcion que verifica si dos palabras son anagramas
     * @param palabra1 String palabra 1 del anagrama
     * @param palabra2 String palabra 2 del anagrama
     * @return true/false
     */
    static boolean esAnagrama(String palabra1, String palabra2) {
        if (palabra1 == null || palabra1.isEmpty() || palabra2 == null || palabra2.isEmpty()) {
            return false;
        }

        // Las palabras se transorman a minúsculas y se eliminan los espacios para poder compararlos con más exactitud.
        palabra1 = palabra1.toLowerCase();
        palabra2 = palabra2.toLowerCase();
        palabra1 = palabra1.replace(" ", "");
        palabra2 = palabra2.replace(" ","");

        if (palabra1.length() != palabra2.length()) {
            return false;
        }

        for (int i = 0; i < palabra1.length(); i++) {
            char letraPalabra1 = palabra1.charAt(i);
            char letraPalabra2 = palabra2.charAt(palabra2.length()-1-i);
            if (letraPalabra1 != letraPalabra2) {
                return false;
            }
        }

        return true;
    }
}
