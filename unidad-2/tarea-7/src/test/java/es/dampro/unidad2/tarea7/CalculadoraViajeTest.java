package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de CalculadoraViaje. */
class CalculadoraViajeTest {
    @Test void caso01() { assertEquals(LocalDateTime.of(2026,6,16,4,15), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,6,15,22,30),5,45)); }
    @Test void caso02() { assertEquals(LocalDateTime.of(2026,1,1,8,0), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,1,1,8,0),0,0)); }
    @Test void caso03() { assertEquals(LocalDateTime.of(2027,1,1,0,10), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,12,31,23,50),0,20)); }
    @Test void caso04() { assertEquals(LocalDateTime.of(2024,3,1,0,0), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2024,2,28,23,0),25,0)); }
    @Test void caso05() { assertEquals(LocalDateTime.of(2026,1,3,0,0), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,1,1,0,0),48,0)); }
    @Test void caso06() { assertEquals(LocalDateTime.of(2026,3,1,15,45), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,3,1,12,15),2,90)); }
    @Test void caso07() { assertEquals(LocalDateTime.of(2026,5,1,6,1), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,5,1,5,0),1,1)); }
    @Test void caso08() { assertEquals(LocalDateTime.of(2026,5,5,9,0), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,5,1,5,0),100,0)); }
    @Test void caso09() { assertEquals(LocalDateTime.of(2026,5,2,5,0), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,5,1,5,0),0,1440)); }
    @Test void caso10() { assertThrows(IllegalArgumentException.class, () -> CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,5,1,5,0),-1,0)); }
    @Test void caso11() { assertThrows(IllegalArgumentException.class, () -> CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,5,1,5,0),0,-1)); }
    @Test void caso12() { assertEquals(LocalDateTime.of(2026,11,7,2,15), CalculadoraViaje.calcularLlegada(LocalDateTime.of(2026,11,6,18,40),7,35)); }
}
