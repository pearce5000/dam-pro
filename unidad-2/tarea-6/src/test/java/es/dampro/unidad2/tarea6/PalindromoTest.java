package es.dampro.unidad2.tarea6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas automáticas del contrato funcional de la clase.Palindromo . */
class PalindromoTest {

    /** Comprueba el caso ana del algoritmo Palindromo. */
    @Test
    void anaTest() {
        assertTrue(Palindromo.esPalindromo("Ana"));
    }

    /** Comprueba el caso luzAzul del algoritmo Palindromo. */
    @Test
    void luzAzulTest() {
        assertTrue(Palindromo.esPalindromo("Luz azul"));
    }

    /** Comprueba el caso java del algoritmo Palindromo. */
    @Test
    void javaTest() {
        assertFalse(Palindromo.esPalindromo("Java"));
    }

    /** Comprueba el caso unCaracter del algoritmo Palindromo. */
    @Test
    void unCaracterTest() {
        assertTrue(Palindromo.esPalindromo("x"));
    }

    /** Comprueba el caso vacio del algoritmo Palindromo. */
    @Test
    void vacioTest() {
        assertFalse(Palindromo.esPalindromo(""));
    }

    /** Comprueba el caso espacios del algoritmo Palindromo. */
    @Test
    void espaciosTest() {
        assertFalse(Palindromo.esPalindromo("   "));
    }

    /** Comprueba el caso dosIguales del algoritmo Palindromo. */
    @Test
    void dosIgualesTest() {
        assertTrue(Palindromo.esPalindromo("AA"));
    }

    /** Comprueba el caso dosDistintos del algoritmo Palindromo. */
    @Test
    void dosDistintosTest() {
        assertFalse(Palindromo.esPalindromo("ab"));
    }

    /** Comprueba el caso mayusculas del algoritmo Palindromo. */
    @Test
    void mayusculasTest() {
        assertTrue(Palindromo.esPalindromo("AbBa"));
    }

    /** Comprueba el caso tildeImporta del algoritmo Palindromo. */
    @Test
    void tildeImportaTest() {
        assertFalse(Palindromo.esPalindromo("anÁ"));
    }

    /** Comprueba el caso puntuacionImporta del algoritmo Palindromo. */
    @Test
    void puntuacionImportaTest() {
        assertFalse(Palindromo.esPalindromo("ana!"));
    }

    /** Comprueba el caso nulo del algoritmo Palindromo. */
    @Test
    void nuloTest() {
        assertThrows(IllegalArgumentException.class, () -> Palindromo.esPalindromo(null));
    }
}
