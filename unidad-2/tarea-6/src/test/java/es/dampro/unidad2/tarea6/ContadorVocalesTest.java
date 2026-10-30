package es.dampro.unidad2.tarea6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/** Verifica los valores habituales, límites y excepciones del algoritmo. */
class ContadorVocalesTest {
    /** Comprueba el escenario textoNormal del algoritmo. */
    @Test void textoNormalTest() { assertEquals(2, ContadorVocales.contarVocales("Hola")); }
    /** Comprueba el escenario mayusculas del algoritmo. */
    @Test void mayusculasTest() { assertEquals(5, ContadorVocales.contarVocales("AEIOU")); }
    /** Comprueba el escenario acentos del algoritmo. */
    @Test void acentosTest() { assertEquals(5, ContadorVocales.contarVocales("áéíóú")); }
    /** Comprueba el escenario dieresis del algoritmo. */
    @Test void dieresisTest() { assertEquals(4, ContadorVocales.contarVocales("pingüino")); }
    /** Comprueba el escenario sinVocales del algoritmo. */
    @Test void sinVocalesTest() { assertEquals(0, ContadorVocales.contarVocales("xyz")); }
    /** Comprueba el escenario cadenaVacia del algoritmo. */
    @Test void cadenaVaciaTest() { assertEquals(0, ContadorVocales.contarVocales("")); }
    /** Comprueba el escenario espacios del algoritmo. */
    @Test void espaciosTest() { assertEquals(0, ContadorVocales.contarVocales("   ")); }
    /** Comprueba el escenario numeros del algoritmo. */
    @Test void numerosTest() { assertEquals(0, ContadorVocales.contarVocales("123")); }
    /** Comprueba el escenario simbolos del algoritmo. */
    @Test void simbolosTest() { assertEquals(0, ContadorVocales.contarVocales("!?")); }
    /** Comprueba el escenario varias del algoritmo. */
    @Test void variasTest() { assertEquals(5, ContadorVocales.contarVocales("Murciélago")); }
    /** Comprueba el escenario unicode del algoritmo. */
    @Test void unicodeTest() { assertEquals(1, ContadorVocales.contarVocales("ñÁ")); }
    /** Comprueba el escenario nulo del algoritmo. */
    @Test void nuloTest() { assertThrows(IllegalArgumentException.class, () -> ContadorVocales.contarVocales(null)); }
}
