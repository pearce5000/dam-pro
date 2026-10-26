package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class AnalizadorContrasena {

    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la contraseña: ");
        String sContrasenna = teclado.nextLine();

    }

    /**
     * Función que indica cuantas mayúsculas tiene la contraseña
     * @param sContrasenna String que guarda la contraseña
     * @return int que recoge el numero de mayúsculas
     */
    static int contarMayusculas(String sContrasenna) {
        if (sContrasenna == null || sContrasenna.isEmpty()) {
            return 0;
        }
        int contadorMayus = 0;
        for (int i = 0; i < sContrasenna.length(); i++) {
            if (Character.isLowerCase(sContrasenna.charAt(i))) {
                contadorMayus++;
            }
        }
        return contadorMayus;
    }
}
