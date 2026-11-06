package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de CalculadoraJornada. */
class CalculadoraJornadaTest {
    @Test void caso01() { assertEquals(Duration.ofMinutes(480), CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(8,30),LocalTime.of(17,0),30)); }
    @Test void caso02() { assertEquals(Duration.ofMinutes(480), CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(9,0),LocalTime.of(17,0),0)); }
    @Test void caso03() { assertEquals(Duration.ofMinutes(1), CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(8,0),LocalTime.of(8,1),0)); }
    @Test void caso04() { assertEquals(Duration.ofMinutes(1380), CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(0,0),LocalTime.of(23,59),59)); }
    @Test void caso05() { assertEquals(Duration.ofMinutes(255), CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(10,15),LocalTime.of(14,45),15)); }
    @Test void caso06() { assertEquals(Duration.ofMinutes(0), CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(8,0),LocalTime.of(9,0),60)); }
    @Test void caso07() { assertThrows(IllegalArgumentException.class, () -> CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(8,0),LocalTime.of(9,0),61)); }
    @Test void caso08() { assertThrows(IllegalArgumentException.class, () -> CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(8,0),LocalTime.of(8,0),0)); }
    @Test void caso09() { assertThrows(IllegalArgumentException.class, () -> CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(17,0),LocalTime.of(8,0),0)); }
    @Test void caso10() { assertThrows(IllegalArgumentException.class, () -> CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(8,0),LocalTime.of(17,0),-1)); }
    @Test void caso11() { assertEquals(Duration.ofMinutes(15), CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(12,0),LocalTime.of(12,30),15)); }
    @Test void caso12() { assertEquals(Duration.ofMinutes(465), CalculadoraJornada.calcularTiempoTrabajado(LocalTime.of(6,45),LocalTime.of(15,15),45)); }
}
