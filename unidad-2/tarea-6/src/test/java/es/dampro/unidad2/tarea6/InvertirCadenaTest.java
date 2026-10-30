package es.dampro.unidad2.tarea6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas automáticas del contrato funcional de la clase.InvertirCadena . */
class InvertirCadenaTest {

    /** Comprueba el caso holaJava del algoritmo InvertirCadena. */
    @Test
    void holaJavaTest() {
        assertEquals("avaJ aloH", InvertirCadena.invertir("Hola Java"));
    }

    /** Comprueba el caso textoVacio del algoritmo InvertirCadena. */
    @Test
    void textoVacioTest() {
        assertEquals("", InvertirCadena.invertir(""));
    }

    /** Comprueba el caso unCaracter del algoritmo InvertirCadena. */
    @Test
    void unCaracterTest() {
        assertEquals("Z", InvertirCadena.invertir("Z"));
    }

    /** Comprueba el caso espacios del algoritmo InvertirCadena. */
    @Test
    void espaciosTest() {
        assertEquals("  ab", InvertirCadena.invertir("ba  "));
    }

    /** Comprueba el caso palabra del algoritmo InvertirCadena. */
    @Test
    void palabraTest() {
        assertEquals("odnum", InvertirCadena.invertir("mundo"));
    }

    /** Comprueba el caso digitos del algoritmo InvertirCadena. */
    @Test
    void digitosTest() {
        assertEquals("321", InvertirCadena.invertir("123"));
    }

    /** Comprueba el caso signos del algoritmo InvertirCadena. */
    @Test
    void signosTest() {
        assertEquals("!?", InvertirCadena.invertir("?!"));
    }

    /** Comprueba el caso mayusculas del algoritmo InvertirCadena. */
    @Test
    void mayusculasTest() {
        assertEquals("bAa", InvertirCadena.invertir("aAb"));
    }

    /** Comprueba el caso acentos del algoritmo InvertirCadena. */
    @Test
    void acentosTest() {
        assertEquals("lóba", InvertirCadena.invertir("aból"));
    }

    /** Comprueba el caso saltosLinea del algoritmo InvertirCadena. */
    @Test
    void saltosLineaTest() {
        assertEquals("b\na", InvertirCadena.invertir("a\nb"));
    }

    /** Comprueba el caso dobleEspacio del algoritmo InvertirCadena. */
    @Test
    void dobleEspacioTest() {
        assertEquals("b  a", InvertirCadena.invertir("a  b"));
    }

    /** Comprueba el caso nulo del algoritmo InvertirCadena. */
    @Test
    void nuloTest() {
        assertThrows(IllegalArgumentException.class, () -> InvertirCadena.invertir(null));
    }
}
