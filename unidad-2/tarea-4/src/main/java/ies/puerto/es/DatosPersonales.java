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

    /**
     * Funcion que transforma la altura en String a double
     * @param sAltura String que almacena la altura
     * @return double de la altura
     */
    static double convertirAltura(String sAltura) {
        if (sAltura == null) {
            return 0;
        }
        double valor = Double.valueOf(sAltura);
        return Double.parseDouble(sAltura);
    }

    /**
     * Funcion que transforma la matricula en string a boolean
     * @param sMatricula String que almacena si la matricula existe
     * @return boolean que indica la existencia de la matricula
     */
    static boolean convertirMatricula(String sMatricula) {
        if (sMatricula == null) {
            return false;
        }
        boolean matricula = Boolean.parseBoolean(sMatricula);
        return matricula;
    }

    /**
     * Funcion que procesa la edad e indica si se es mayor de edad
     * @param edad int que almacena la edad
     * @return boolean que indica si se es mayor de edad
     */
    static boolean esMayorDeEdad(int edad) {
        boolean mayor;
        if (edad < 18) {
            mayor = false;
        }
        mayor = true;
        return mayor;
    }

    /**
     * Funcion que transforma la edad en int a Integer
     * @param edad int que almacena la edad
     * @return Integer que almacena la edad
     */
    static Integer convertirEdadEnvolvente(int edad) {
        Integer edadObjeto = Integer.valueOf(edad);
        return edadObjeto;
    }

    /**
     * Funcion que transforma la edad en Integer a int
     * @param edadObjeto Integer que almacena la edad
     * @return Int que almacena la edad
     */
    static int recuperarEdadPrimitiva(Integer edadObjeto) {
        int edadPrimitiva = edadObjeto.intValue();
        return edadPrimitiva;
    }


    static String formatearFicha() {

    }
}
