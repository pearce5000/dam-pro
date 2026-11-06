package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de CalculadoraEdad. */
class CalculadoraEdadTest {
    @Test void caso01() { assertEquals(Period.between(LocalDate.of(2000,5,20),LocalDate.of(2026,11,6)), CalculadoraEdad.calcularEdad(LocalDate.of(2000,5,20), LocalDate.of(2026,11,6))); }
    @Test void caso02() { assertEquals(Period.between(LocalDate.of(2026,11,6),LocalDate.of(2026,11,6)), CalculadoraEdad.calcularEdad(LocalDate.of(2026,11,6), LocalDate.of(2026,11,6))); }
    @Test void caso03() { assertEquals(Period.between(LocalDate.of(2000,1,1),LocalDate.of(2026,1,1)), CalculadoraEdad.calcularEdad(LocalDate.of(2000,1,1), LocalDate.of(2026,1,1))); }
    @Test void caso04() { assertEquals(Period.between(LocalDate.of(2000,12,31),LocalDate.of(2026,1,1)), CalculadoraEdad.calcularEdad(LocalDate.of(2000,12,31), LocalDate.of(2026,1,1))); }
    @Test void caso05() { assertEquals(Period.between(LocalDate.of(2024,2,29),LocalDate.of(2025,2,28)), CalculadoraEdad.calcularEdad(LocalDate.of(2024,2,29), LocalDate.of(2025,2,28))); }
    @Test void caso06() { assertEquals(Period.between(LocalDate.of(2004,2,29),LocalDate.of(2024,2,29)), CalculadoraEdad.calcularEdad(LocalDate.of(2004,2,29), LocalDate.of(2024,2,29))); }
    @Test void caso07() { assertEquals(Period.between(LocalDate.of(2020,5,15),LocalDate.of(2021,6,17)), CalculadoraEdad.calcularEdad(LocalDate.of(2020,5,15), LocalDate.of(2021,6,17))); }
    @Test void caso08() { assertEquals(Period.between(LocalDate.of(2010,10,10),LocalDate.of(2026,10,9)), CalculadoraEdad.calcularEdad(LocalDate.of(2010,10,10), LocalDate.of(2026,10,9))); }
    @Test void caso09() { assertEquals(Period.between(LocalDate.of(1999,12,31),LocalDate.of(2000,1,1)), CalculadoraEdad.calcularEdad(LocalDate.of(1999,12,31), LocalDate.of(2000,1,1))); }
    @Test void caso10() { assertEquals(Period.between(LocalDate.of(2025,6,30),LocalDate.of(2026,6,29)), CalculadoraEdad.calcularEdad(LocalDate.of(2025,6,30), LocalDate.of(2026,6,29))); }
    @Test void caso11() { assertEquals(Period.between(LocalDate.of(2025,12,30),LocalDate.of(2026,1,2)), CalculadoraEdad.calcularEdad(LocalDate.of(2025,12,30), LocalDate.of(2026,1,2))); }
    @Test void caso12() { assertThrows(IllegalArgumentException.class, () -> CalculadoraEdad.calcularEdad(LocalDate.of(2027,1,1), LocalDate.of(2026,1,1))); }
}
