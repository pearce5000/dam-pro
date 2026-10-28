package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class ClaveSecreta {
    static void main() {
        //o O = 0
        //i I = 2
        //u U = 3
        //e E = *
        //a A = ?
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca la clave: ");
        String sPalabra = teclado.nextLine();
        String contrasenia = generarClaveSegura(sPalabra);
        System.out.println(contrasenia);

    }

    /**
     * Funcion que cambia ciertas letras por otros caracteres
     * @param sPalabra String que contiene la palabra
     * @return String
     */
    static String generarClaveSegura(String sPalabra) {

        if (sPalabra == null || sPalabra.isEmpty()) {
            return "";
        }
        sPalabra = sPalabra.replace("a", "?");
        sPalabra = sPalabra.replace("e", "*");
        sPalabra = sPalabra.replace("i", "2");
        sPalabra = sPalabra.replace("o", "0");
        sPalabra = sPalabra.replace("u", "3");
        sPalabra = sPalabra.replace("A", "?");
        sPalabra = sPalabra.replace("E", "*");
        sPalabra = sPalabra.replace("I", "2");
        sPalabra = sPalabra.replace("O", "0");
        sPalabra = sPalabra.replace("U", "3");

        return sPalabra;
    }
}
