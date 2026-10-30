package es.dampro.unidad2.tarea6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas automáticas del contrato funcional de la clase.SumaDigitos . */
class SumaDigitosTest {

    /** Comprueba el caso normal del algoritmo SumaDigitos. */
    @Test
    void normalTest() {
        assertEquals(18, SumaDigitos.sumarDigitos("5832"));
    }

    /** Comprueba el caso cero del algoritmo SumaDigitos. */
    @Test
    void ceroTest() {
        assertEquals(0, SumaDigitos.sumarDigitos("0"));
    }

    /** Comprueba el caso variosCeros del algoritmo SumaDigitos. */
    @Test
    void variosCerosTest() {
        assertEquals(0, SumaDigitos.sumarDigitos("00000"));
    }

    /** Comprueba el caso cifrasNueve del algoritmo SumaDigitos. */
    @Test
    void cifrasNueveTest() {
        assertEquals(27, SumaDigitos.sumarDigitos("999"));
    }

    /** Comprueba el caso unDigito del algoritmo SumaDigitos. */
    @Test
    void unDigitoTest() {
        assertEquals(5, SumaDigitos.sumarDigitos("5"));
    }

    /** Comprueba el caso cerosIniciales del algoritmo SumaDigitos. */
    @Test
    void cerosInicialesTest() {
        assertEquals(3, SumaDigitos.sumarDigitos("0012"));
    }

    /** Comprueba el caso numeroLargo del algoritmo SumaDigitos. */
    @Test
    void numeroLargoTest() {
        assertEquals(45, SumaDigitos.sumarDigitos("1234567890"));
    }

    /** Comprueba el caso vacio del algoritmo SumaDigitos. */
    @Test
    void vacioTest() {
        assertThrows(IllegalArgumentException.class, () -> SumaDigitos.sumarDigitos(""));
    }

    /** Comprueba el caso nulo del algoritmo SumaDigitos. */
    @Test
    void nuloTest() {
        assertThrows(IllegalArgumentException.class, () -> SumaDigitos.sumarDigitos(null));
    }

    /** Comprueba el caso negativo del algoritmo SumaDigitos. */
    @Test
    void negativoTest() {
        assertThrows(IllegalArgumentException.class, () -> SumaDigitos.sumarDigitos("-12"));
    }

    /** Comprueba el caso letras del algoritmo SumaDigitos. */
    @Test
    void letrasTest() {
        assertThrows(IllegalArgumentException.class, () -> SumaDigitos.sumarDigitos("12a"));
    }

    /** Comprueba el caso espacios del algoritmo SumaDigitos. */
    @Test
    void espaciosTest() {
        assertThrows(IllegalArgumentException.class, () -> SumaDigitos.sumarDigitos(" 12"));
    }
}
