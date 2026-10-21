package ies.puerto.es;

import static java.lang.Boolean.parseBoolean;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class DatosPersonales {
    static void main() {
        String nombre = "Ana";
        String sEdad = "21";
        String sAltura = "1.68";
        String sMatricula = "true";
    }

    /**
     * Funcion que transforma la edad en String a int
     * @param sEdad String que almacena la edad
     * @return int de la edad
     */
    static int convertirEdad(String sEdad) {
        if (sEdad == null) {
            return 0;
        }
        int valor = Integer.valueOf(sEdad);
        return Integer.parseInt(sEdad);
    }

    static double convertirAltura(String sAltura) {
        if (sAltura == null) {
            return 0;
        }
        double valor = Double.valueOf(sAltura);
        return Double.parseDouble(sAltura);
    }

    static boolean convertirMatricula(String sMatricula) {
        if (sMatricula == null) {
            return false;
        }
        boolean matricula = Boolean.parseBoolean(sMatricula);
        return matricula;
    }

    static boolean esMayorDeEdad(int edad) {
        boolean mayor;
        if (edad < 18) {
            mayor = false;
        }
        mayor = true;
        return mayor;
    }


    static Integer convertirEdadEnvolvente(int edad) {
        Integer edadObjeto = Integer.valueOf(edad);
        return edadObjeto;
    }


    static int recuperarEdadPrimitiva(Integer edadObjeto) {
        int edadPrimitiva = edadObjeto.intValue();
        return edadPrimitiva;
    }
}
