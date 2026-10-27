package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */

public class Palindrome {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la palabra o frase a analizar: ");
        String sFrase = teclado.nextLine();
        boolean bPalindrome = esPalindrome(sFrase);
        System.out.println("La palabra/frase es palindrome = "+bPalindrome);
    }

    /**
     * Funcion que recibe una palabra o frase y comprueba si es palindrome
     * @param frase String que guarda la palabra/frase
     * @return boolean que indica si una palabra/frase es palindrome
     */
    static boolean esPalindrome(String frase) {
        if (frase == null || frase.isEmpty()) {
            return false;
        }

        frase = frase.toLowerCase(); // Transforma el contenido a minúscula
        frase = frase.replace(" ",""); // Hace que los espacios no existan

        for (int i = 0; i < frase.length(); i++) {
            char letraIzquieda = frase.charAt(i);
            char letraDerecha = frase.charAt(frase.length()-1-i);
            if (letraIzquieda != letraDerecha) {
                return false;
            }
            i++;
        }

        return true;
    }
}
