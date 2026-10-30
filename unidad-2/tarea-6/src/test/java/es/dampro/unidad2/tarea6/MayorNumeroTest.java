package es.dampro.unidad2.tarea6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas automáticas del contrato funcional de la clase.MayorNumero . */
class MayorNumeroTest {

    /** Comprueba el caso ejemplo del algoritmo MayorNumero. */
    @Test
    void ejemploTest() {
        assertEquals(89, MayorNumero.obtenerMayor("12,5,89,-3,45"));
    }

    /** Comprueba el caso unico del algoritmo MayorNumero. */
    @Test
    void unicoTest() {
        assertEquals(7, MayorNumero.obtenerMayor("7"));
    }

    /** Comprueba el caso negativos del algoritmo MayorNumero. */
    @Test
    void negativosTest() {
        assertEquals(-1, MayorNumero.obtenerMayor("-3,-1,-10"));
    }

    /** Comprueba el caso repetidos del algoritmo MayorNumero. */
    @Test
    void repetidosTest() {
        assertEquals(5, MayorNumero.obtenerMayor("5,5,5"));
    }

    /** Comprueba el caso espacios del algoritmo MayorNumero. */
    @Test
    void espaciosTest() {
        assertEquals(20, MayorNumero.obtenerMayor(" 10 , 20 , 3 "));
    }

    /** Comprueba el caso cero del algoritmo MayorNumero. */
    @Test
    void ceroTest() {
        assertEquals(0, MayorNumero.obtenerMayor("-1,0,-2"));
    }

    /** Comprueba el caso minimoInt del algoritmo MayorNumero. */
    @Test
    void minimoIntTest() {
        assertEquals(-1, MayorNumero.obtenerMayor("-2147483648,-1"));
    }

    /** Comprueba el caso maximoInt del algoritmo MayorNumero. */
    @Test
    void maximoIntTest() {
        assertEquals(2147483647, MayorNumero.obtenerMayor("0,2147483647"));
    }

    /** Comprueba el caso vacio del algoritmo MayorNumero. */
    @Test
    void vacioTest() {
        assertThrows(IllegalArgumentException.class, () -> MayorNumero.obtenerMayor(""));
    }

    /** Comprueba el caso nulo del algoritmo MayorNumero. */
    @Test
    void nuloTest() {
        assertThrows(IllegalArgumentException.class, () -> MayorNumero.obtenerMayor(null));
    }

    /** Comprueba el caso elementoVacio del algoritmo MayorNumero. */
    @Test
    void elementoVacioTest() {
        assertThrows(IllegalArgumentException.class, () -> MayorNumero.obtenerMayor("1,,2"));
    }

    /** Comprueba el caso malFormado del algoritmo MayorNumero. */
    @Test
    void malFormadoTest() {
        assertThrows(NumberFormatException.class, () -> MayorNumero.obtenerMayor("1,tres,2"));
    }
}
