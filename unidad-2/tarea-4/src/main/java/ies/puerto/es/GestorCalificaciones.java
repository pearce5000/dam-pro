package ies.puerto.es;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class GestorCalificaciones {

    static void main() {

    }

    /**
     *
     * @param sNumero
     * @return
     */
    static int convertirNumeroNotas(String sNumero) {
        int numero = 0;
        if (sNumero == null || sNumero.isEmpty()) {
            return 0;
        }

        //return Integer.parseInt(sNumero);
        numero = Integer.parseInt(sNumero);
        return numero;
    }

    /**
     *
     * @param sNumero
     * @return
     */
    static double convertirNota(String sNumero) {
        double numero = 0;

        if (sNumero == null || sNumero.isEmpty()) {
            return 0;
        }
        numero = Double.parseDouble(sNumero);
        return numero;
    }

    /**
     *
     * @param dNumero
     * @return
     */
    static boolean esNotaValida(Double dNumero) {
        if (dNumero == null) {
            return false;
        }
        if (dNumero < 0 || dNumero >10) {
            return false;
        }


        return true;
    }

}
