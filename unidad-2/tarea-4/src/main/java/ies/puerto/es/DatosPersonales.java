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
        convertirEdadEnvolvente();
        esMayorDeEdad(edad);
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
     */
    static void convertirEdadEnvolvente() {
        edadObjeto = edad;
    }

    /**
     * Funcion que transforma la edad en Integer a int
     * @param edadObjeto Integer que almacena la edad
     * @return Int que almacena la edad
     */
    static int recuperarEdadPrimitiva(edadObjeto) {
        edadPrimitiva = edadObjeto.intValue();
        return edadPrimitiva;
    }


    static void formatearFicha() {
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad);
        System.out.println("Altura: "+altura);
        System.out.println("Mayor de edad: "+matricula);
        System.out.println("Edad como Integer: "+edadObjeto);
        System.out.println("Edad como int: "+edadPrimitiva);
    }
}
