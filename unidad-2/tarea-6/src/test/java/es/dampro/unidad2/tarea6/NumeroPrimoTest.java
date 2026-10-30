package es.dampro.unidad2.tarea6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas automáticas del contrato funcional de la clase.NumeroPrimo . */
class NumeroPrimoTest {

    /** Comprueba el caso diecisiete del algoritmo NumeroPrimo. */
    @Test
    void diecisieteTest() {
        assertTrue(NumeroPrimo.esPrimo("17"));
    }

    /** Comprueba el caso veinte del algoritmo NumeroPrimo. */
    @Test
    void veinteTest() {
        assertFalse(NumeroPrimo.esPrimo("20"));
    }

    /** Comprueba el caso uno del algoritmo NumeroPrimo. */
    @Test
    void unoTest() {
        assertFalse(NumeroPrimo.esPrimo("1"));
    }

    /** Comprueba el caso cero del algoritmo NumeroPrimo. */
    @Test
    void ceroTest() {
        assertFalse(NumeroPrimo.esPrimo("0"));
    }

    /** Comprueba el caso negativo del algoritmo NumeroPrimo. */
    @Test
    void negativoTest() {
        assertFalse(NumeroPrimo.esPrimo("-7"));
    }

    /** Comprueba el caso dos del algoritmo NumeroPrimo. */
    @Test
    void dosTest() {
        assertTrue(NumeroPrimo.esPrimo("2"));
    }

    /** Comprueba el caso tres del algoritmo NumeroPrimo. */
    @Test
    void tresTest() {
        assertTrue(NumeroPrimo.esPrimo("3"));
    }

    /** Comprueba el caso cuatro del algoritmo NumeroPrimo. */
    @Test
    void cuatroTest() {
        assertFalse(NumeroPrimo.esPrimo("4"));
    }

    /** Comprueba el caso cuadradoDePrimo del algoritmo NumeroPrimo. */
    @Test
    void cuadradoDePrimoTest() {
        assertFalse(NumeroPrimo.esPrimo("49"));
    }

    /** Comprueba el caso primoGrande del algoritmo NumeroPrimo. */
    @Test
    void primoGrandeTest() {
        assertTrue(NumeroPrimo.esPrimo("9973"));
    }

    /** Comprueba el caso nulo del algoritmo NumeroPrimo. */
    @Test
    void nuloTest() {
        assertThrows(IllegalArgumentException.class, () -> NumeroPrimo.esPrimo(null));
    }

    /** Comprueba el caso texto del algoritmo NumeroPrimo. */
    @Test
    void textoTest() {
        assertThrows(NumberFormatException.class, () -> NumeroPrimo.esPrimo("abc"));
    }
}
