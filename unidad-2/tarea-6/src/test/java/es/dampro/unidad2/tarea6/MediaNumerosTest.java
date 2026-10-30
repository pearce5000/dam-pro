package es.dampro.unidad2.tarea6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/** Verifica los valores habituales, límites y excepciones del algoritmo. */
class MediaNumerosTest {
    /** Comprueba el escenario mediaSimple del algoritmo. */
    @Test void mediaSimpleTest() { assertEquals(25.0, MediaNumeros.calcularMedia("10,20,30,40"),1e-6); }
    /** Comprueba el escenario unico del algoritmo. */
    @Test void unicoTest() { assertEquals(7.0, MediaNumeros.calcularMedia("7"),1e-6); }
    /** Comprueba el escenario negativos del algoritmo. */
    @Test void negativosTest() { assertEquals(-2.0, MediaNumeros.calcularMedia("-1,-2,-3"),1e-6); }
    /** Comprueba el escenario ceros del algoritmo. */
    @Test void cerosTest() { assertEquals(0.0, MediaNumeros.calcularMedia("0,0,0"),1e-6); }
    /** Comprueba el escenario fraccion del algoritmo. */
    @Test void fraccionTest() { assertEquals(1.5, MediaNumeros.calcularMedia("1,2"),1e-6); }
    /** Comprueba el escenario espacios del algoritmo. */
    @Test void espaciosTest() { assertEquals(2.0, MediaNumeros.calcularMedia(" 1 , 2 , 3 "),1e-6); }
    /** Comprueba el escenario extremos del algoritmo. */
    @Test void extremosTest() { assertEquals(2147483647.0, MediaNumeros.calcularMedia("2147483647,2147483647"),1e-6); }
    /** Comprueba el escenario compensacion del algoritmo. */
    @Test void compensacionTest() { assertEquals(-0.5, MediaNumeros.calcularMedia("-1,0"),1e-6); }
    /** Comprueba el escenario nulo del algoritmo. */
    @Test void nuloTest() { assertThrows(IllegalArgumentException.class, () -> MediaNumeros.calcularMedia(null)); }
    /** Comprueba el escenario vacio del algoritmo. */
    @Test void vacioTest() { assertThrows(IllegalArgumentException.class, () -> MediaNumeros.calcularMedia("")); }
    /** Comprueba el escenario comaFinal del algoritmo. */
    @Test void comaFinalTest() { assertThrows(IllegalArgumentException.class, () -> MediaNumeros.calcularMedia("1,2,")); }
    /** Comprueba el escenario malFormado del algoritmo. */
    @Test void malFormadoTest() { assertThrows(NumberFormatException.class, () -> MediaNumeros.calcularMedia("1,x,3")); }
}
