package ies.puerto.es;

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
    }

    /**
     * Funcion que
     * @param sPalabra String que contiene la palabra
     * @return String
     */
    static String generarClaveSegura(String sPalabra) {
        String clave = "";

        if (sPalabra == null || sPalabra.isEmpty()) {
            return "";
        }
        sPalabra.replace("a|A", "?");
        sPalabra.replace("e|E", "*");
        sPalabra.replace("i|I", "2");
        sPalabra.replace("o|O", "0");
        sPalabra.replace("u|U", "3");


        return clave;
    }
}
