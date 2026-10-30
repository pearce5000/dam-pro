package es.dampro.unidad2.tarea6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas automáticas del contrato funcional de la clase.BinarioDecimal . */
class BinarioDecimalTest {

    /** Comprueba el caso once del algoritmo BinarioDecimal. */
    @Test
    void onceTest() {
        assertEquals(11, BinarioDecimal.convertirBinario("1011"));
    }

    /** Comprueba el caso cero del algoritmo BinarioDecimal. */
    @Test
    void ceroTest() {
        assertEquals(0, BinarioDecimal.convertirBinario("0"));
    }

    /** Comprueba el caso uno del algoritmo BinarioDecimal. */
    @Test
    void unoTest() {
        assertEquals(1, BinarioDecimal.convertirBinario("1"));
    }

    /** Comprueba el caso variosCeros del algoritmo BinarioDecimal. */
    @Test
    void variosCerosTest() {
        assertEquals(0, BinarioDecimal.convertirBinario("0000"));
    }

    /** Comprueba el caso cerosIniciales del algoritmo BinarioDecimal. */
    @Test
    void cerosInicialesTest() {
        assertEquals(5, BinarioDecimal.convertirBinario("00101"));
    }

    /** Comprueba el caso ocho del algoritmo BinarioDecimal. */
    @Test
    void ochoTest() {
        assertEquals(8, BinarioDecimal.convertirBinario("1000"));
    }

    /** Comprueba el caso maxInt del algoritmo BinarioDecimal. */
    @Test
    void maxIntTest() {
        assertEquals(Integer.MAX_VALUE, BinarioDecimal.convertirBinario("1111111111111111111111111111111"));
    }

    /** Comprueba el caso vacio del algoritmo BinarioDecimal. */
    @Test
    void vacioTest() {
        assertThrows(IllegalArgumentException.class, () -> BinarioDecimal.convertirBinario(""));
    }

    /** Comprueba el caso nulo del algoritmo BinarioDecimal. */
    @Test
    void nuloTest() {
        assertThrows(IllegalArgumentException.class, () -> BinarioDecimal.convertirBinario(null));
    }

    /** Comprueba el caso digitoIncorrecto del algoritmo BinarioDecimal. */
    @Test
    void digitoIncorrectoTest() {
        assertThrows(IllegalArgumentException.class, () -> BinarioDecimal.convertirBinario("102"));
    }

    /** Comprueba el caso espacio del algoritmo BinarioDecimal. */
    @Test
    void espacioTest() {
        assertThrows(IllegalArgumentException.class, () -> BinarioDecimal.convertirBinario("10 1"));
    }

    /** Comprueba el caso desbordamiento del algoritmo BinarioDecimal. */
    @Test
    void desbordamientoTest() {
        assertThrows(IllegalArgumentException.class, () -> BinarioDecimal.convertirBinario("10000000000000000000000000000000"));
    }
}
