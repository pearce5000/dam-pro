package ies.puerto.es;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class DatosPersonales {
    static void main() {

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

}
