package es.dampro.unidad2.tarea6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/** Verifica los valores habituales, límites y excepciones del algoritmo. */
class EcuacionCuadraticaTest {
    /** Comprueba el escenario dosRaices del algoritmo. */
    @Test void dosRaicesTest() { assertEquals(1.0, EcuacionCuadratica.calcularDiscriminante("1","-5","6"), 1e-6); }
    /** Comprueba el escenario raizDoble del algoritmo. */
    @Test void raizDobleTest() { assertEquals(0.0, EcuacionCuadratica.calcularDiscriminante("1","2","1"), 1e-6); }
    /** Comprueba el escenario sinRaices del algoritmo. */
    @Test void sinRaicesTest() { assertEquals(-4.0, EcuacionCuadratica.calcularDiscriminante("1","0","1"), 1e-6); }
    /** Comprueba el escenario decimales del algoritmo. */
    @Test void decimalesTest() { assertEquals(4.0, EcuacionCuadratica.calcularDiscriminante("0.5","0","-2"), 1e-6); }
    /** Comprueba el escenario negativos del algoritmo. */
    @Test void negativosTest() { assertEquals(25.0, EcuacionCuadratica.calcularDiscriminante("-1","5","0"),1e-6); }
    /** Comprueba el escenario coeficienteCero del algoritmo. */
    @Test void coeficienteCeroTest() { assertEquals(9.0, EcuacionCuadratica.calcularDiscriminante("2","3","0"),1e-6); }
    /** Comprueba el escenario blancosExtremos del algoritmo. */
    @Test void blancosExtremosTest() { assertEquals(1.0, EcuacionCuadratica.calcularDiscriminante(" 1 ","-5","6"),1e-6); }
    /** Comprueba el escenario anulo del algoritmo. */
    @Test void anuloTest() { assertThrows(IllegalArgumentException.class, () -> EcuacionCuadratica.calcularDiscriminante(null,"2","1")); }
    /** Comprueba el escenario acero del algoritmo. */
    @Test void aceroTest() { assertThrows(IllegalArgumentException.class, () -> EcuacionCuadratica.calcularDiscriminante("0","2","1")); }
    /** Comprueba el escenario cadenaVacia del algoritmo. */
    @Test void cadenaVaciaTest() { assertThrows(IllegalArgumentException.class, () -> EcuacionCuadratica.calcularDiscriminante("","2","1")); }
    /** Comprueba el escenario malFormado del algoritmo. */
    @Test void malFormadoTest() { assertThrows(NumberFormatException.class, () -> EcuacionCuadratica.calcularDiscriminante("uno","2","1")); }
    /** Comprueba el escenario noFinito del algoritmo. */
    @Test void noFinitoTest() { assertThrows(IllegalArgumentException.class, () -> EcuacionCuadratica.calcularDiscriminante("NaN","2","1")); }
}
