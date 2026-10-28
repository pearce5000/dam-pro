package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class Vocales {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la cadena de texto: ");
        String cadena = teclado.nextLine();
        int resultado = contarVocales(cadena);
        System.out.println("El numero de vocales es: "+resultado);

    }


    static int contarVocales(String sCadena) {
        if (sCadena == null || sCadena.isEmpty()) {
            return 0;
        }
        int resultado = 0;
        sCadena = sCadena.toLowerCase();
        for (int i = 0; i < sCadena.length(); i++) {
            char caracter = sCadena.charAt(i);
            if (caracter == 'a' || caracter == 'á'  || caracter == 'e' || caracter == 'é' || caracter == 'i'
            || caracter == 'í' ||  caracter == 'o' || caracter == 'ó'  || caracter == 'u' || caracter == 'ú') {
                resultado = resultado + 1;
            }
        }

        return resultado;
    }


    static int contarVocales2(String sCadena) {
        if (sCadena == null || sCadena.isEmpty()) {
            return 0;
        }
        int resultado = 0;
        sCadena = sCadena.toLowerCase();
        for (int i = 0; i < sCadena.length(); i++) {
            char caracter = sCadena.charAt(i);
            switch (caracter) {
                case 'a','á','e','é','i','í','o','ó','u','ú':
                    resultado++;
            }
        }

        return resultado;
    }
}
