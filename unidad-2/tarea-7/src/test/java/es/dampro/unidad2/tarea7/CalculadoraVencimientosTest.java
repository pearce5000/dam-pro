package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de CalculadoraVencimientos. */
class CalculadoraVencimientosTest {
    @Test void caso01() { assertEquals(LocalDate.of(2026,2,28), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2026,1,31),0,1,0)); }
    @Test void caso02() { assertEquals(LocalDate.of(2025,2,28), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2024,2,29),0,0,1)); }
    @Test void caso03() { assertEquals(LocalDate.of(2026,1,11), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2026,1,1),10,0,0)); }
    @Test void caso04() { assertEquals(LocalDate.of(2026,1,1), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2025,12,31),1,0,0)); }
    @Test void caso05() { assertEquals(LocalDate.of(2026,2,28), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2026,3,31),0,-1,0)); }
    @Test void caso06() { assertEquals(LocalDate.of(2024,3,2), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2024,1,30),2,1,0)); }
    @Test void caso07() { assertEquals(LocalDate.of(2026,6,15), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2026,6,15),0,0,0)); }
    @Test void caso08() { assertEquals(LocalDate.of(2026,5,31), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2026,6,15),-15,0,0)); }
    @Test void caso09() { assertEquals(LocalDate.of(2024,2,29), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2020,2,29),0,0,4)); }
    @Test void caso10() { assertEquals(LocalDate.of(2026,2,1), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2024,12,31),1,1,1)); }
    @Test void caso11() { assertEquals(LocalDate.of(2027,1,1), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2026,1,1),0,12,0)); }
    @Test void caso12() { assertEquals(LocalDate.of(2026,2,28), CalculadoraVencimientos.calcularVencimiento(LocalDate.of(2026,8,31),0,6,-1)); }
}
