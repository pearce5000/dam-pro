package ies.puerto.es;

import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class DatosPersonales {


    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre: ");
        String sNombre = teclado.nextLine();
        System.out.println("Introduce la edad: ");
        String sEdad = teclado.nextLine();
        System.out.println("Introduce la altura: ");
        String sAltura = teclado.nextLine();
        System.out.println("Introduce la matricula");
        String sMatricula = teclado.nextLine();

        int iEdad = convertirEdad(sEdad);
        double dAltura = convertirAltura(sAltura);
        boolean bMatricula = convertirMatricula(sMatricula);
        boolean bMayorEdad = esMayorDeEdad(iEdad);
        String ficha = formatearFicha(sNombre,iEdad,dAltura,bMatricula,bMayorEdad);

        System.out.println(ficha);
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
        return Integer.parseInt(sEdad);
    }

    /**
     * Funcion que transforma la altura en String a double
     * @param sAltura String que almacena la altura
     * @return double de la altura
     */
    static double convertirAltura(String sAltura) {
        if (sAltura == null || sAltura.isEmpty()) {
            return 0;
        }
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
        return Boolean.parseBoolean(sMatricula);
    }

    /**
     * Funcion que procesa la edad e indica si se es mayor de edad
     * @param edad int que almacena la edad
     * @return true/false
     */
    static boolean esMayorDeEdad(int edad) {
        if (edad < 18) {
            return false;
        }
        return true;
    }

    /**
     * Funcion que transforma la edad en int a Integer
     * @param iEdad int que almacena la edad
     */
    static Integer convertirEdadEnvolvente(int iEdad) {
        return Integer.valueOf(iEdad);
    }

    /**
     * Funcion que transforma la edad en Integer a int
     * @param iEdad Integer que almacena la edad
     * @return Int que almacena la edad
     */
    static int recuperarEdadPrimitiva(Integer iEdad) {
        if (iEdad == null) {
            return 0;
        }
        return iEdad.intValue();
    }

    /**
     * Funcio que formatea la ficha
     * @param sNombre String nombre de la ficha
     * @param iEdad Integer edad de la ficha
     * @param dAltura double altura de la ficha
     * @param bMatricula boolean matricula de la ficha
     * @param bMayorEdad boolean mayor de edad de la ficha
     * @return
     */
    static String formatearFicha(String sNombre, int iEdad, double dAltura
                ,boolean bMatricula, boolean bMayorEdad) {
        return "Ficha:"+sNombre+",edad:"+iEdad+",altura:"+dAltura
                +",matricula:"+bMatricula+",mayor de edad:"+bMayorEdad;
    }
}