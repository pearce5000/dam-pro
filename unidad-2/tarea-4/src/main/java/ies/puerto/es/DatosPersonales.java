package ies.puerto.es;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class DatosPersonales {
    static String nombre;
    static int edad;
    static double altura;
    static boolean matricula;
    static boolean mayorDeEdad;
    static Integer edadObjeto;
    static int edadPrimitiva;
    static void main() {
        nombre = "Ana";
        String sEdad = "21";
        String sAltura = "1.68";
        String sMatricula = "true";
        int edad = 0;
        convertirEdad(sEdad);
        convertirAltura(sAltura);
        convertirMatricula(sMatricula);
        esMayorDeEdad(edad);
        convertirEdadEnvolvente();
        recuperarEdadPrimitiva();
        formatearFicha();
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
        edad = Integer.valueOf(sEdad);
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
        altura = Double.valueOf(sAltura);
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
        matricula = Boolean.parseBoolean(sMatricula);
        return matricula;
    }

    /**
     * Funcion que procesa la edad e indica si se es mayor de edad
     * @param edad int que almacena la edad
     * @return boolean que indica si se es mayor de edad
     */
    static boolean esMayorDeEdad(int edad) {
        if (edad < 18) {
            mayorDeEdad = false;
        }
        mayorDeEdad = true;
        return mayorDeEdad;
    }

    /**
     * Funcion que transforma la edad en int a Integer
     * @param edad int que almacena la edad
     */
    static void convertirEdadEnvolvente() {
        edadObjeto = edad;
    }

    /**
     * Funcion que transforma la edad en Integer a int
     * @param edadObjeto Integer que almacena la edad
     * @return Int que almacena la edad
     */
    static void recuperarEdadPrimitiva() {
        edadPrimitiva = edadObjeto;
    }

    /**
     * Funcion que muestra
     */
    static String formatearFicha() {
        String ficha = "Nombre: " +nombre +
                "Edad: "+edad +

                "Altura: "+altura +

                "Matricula: "+matricula +

                "Mayor de edad: "+mayorDeEdad +

                "Edad como Integer: "+edadObjeto +

                "Edad como int: "+edadPrimitiva;
        System.out.println(ficha);
        return ficha;
    }
}
