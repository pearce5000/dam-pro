package es.dampro.unidad2.tarea6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas automáticas del contrato funcional de la clase.Factorial . */
class FactorialTest {

    /** Comprueba el caso cinco del algoritmo Factorial. */
    @Test
    void cincoTest() {
        assertEquals(120, Factorial.calcularFactorial("5"));
    }

    /** Comprueba el caso cero del algoritmo Factorial. */
    @Test
    void ceroTest() {
        assertEquals(1, Factorial.calcularFactorial("0"));
    }

    /** Comprueba el caso uno del algoritmo Factorial. */
    @Test
    void unoTest() {
        assertEquals(1, Factorial.calcularFactorial("1"));
    }

    /** Comprueba el caso dos del algoritmo Factorial. */
    @Test
    void dosTest() {
        assertEquals(2, Factorial.calcularFactorial("2"));
    }

    /** Comprueba el caso tres del algoritmo Factorial. */
    @Test
    void tresTest() {
        assertEquals(6, Factorial.calcularFactorial("3"));
    }

    /** Comprueba el caso diez del algoritmo Factorial. */
    @Test
    void diezTest() {
        assertEquals(3628800, Factorial.calcularFactorial("10"));
    }

    /** Comprueba el caso doce del algoritmo Factorial. */
    @Test
    void doceTest() {
        assertEquals(479001600, Factorial.calcularFactorial("12"));
    }

    /** Comprueba el caso negativo del algoritmo Factorial. */
    @Test
    void negativoTest() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calcularFactorial("-1"));
    }

    /** Comprueba el caso trece del algoritmo Factorial. */
    @Test
    void treceTest() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calcularFactorial("13"));
    }

    /** Comprueba el caso vacio del algoritmo Factorial. */
    @Test
    void vacioTest() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calcularFactorial(""));
    }

    /** Comprueba el caso nulo del algoritmo Factorial. */
    @Test
    void nuloTest() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calcularFactorial(null));
    }

    /** Comprueba el caso texto del algoritmo Factorial. */
    @Test
    void textoTest() {
        assertThrows(NumberFormatException.class, () -> Factorial.calcularFactorial("abc"));
    }
}
