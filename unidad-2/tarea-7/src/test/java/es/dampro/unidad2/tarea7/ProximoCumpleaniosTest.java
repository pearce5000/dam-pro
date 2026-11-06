package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de ProximoCumpleanios. */
class ProximoCumpleaniosTest {
    @Test void caso01() { assertEquals(LocalDate.of(2027,5,20), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2000,5,20),LocalDate.of(2026,11,6))); }
    @Test void caso02() { assertEquals(LocalDate.of(2026,5,20), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2000,5,20),LocalDate.of(2026,5,20))); }
    @Test void caso03() { assertEquals(LocalDate.of(2026,12,31), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2000,12,31),LocalDate.of(2026,1,1))); }
    @Test void caso04() { assertEquals(LocalDate.of(2027,1,1), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2000,1,1),LocalDate.of(2026,1,2))); }
    @Test void caso05() { assertEquals(LocalDate.of(2025,2,28), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2004,2,29),LocalDate.of(2025,1,1))); }
    @Test void caso06() { assertEquals(LocalDate.of(2025,2,28), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2004,2,29),LocalDate.of(2025,2,28))); }
    @Test void caso07() { assertEquals(LocalDate.of(2024,2,29), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2004,2,29),LocalDate.of(2024,2,28))); }
    @Test void caso08() { assertEquals(LocalDate.of(2024,2,29), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2004,2,29),LocalDate.of(2024,2,29))); }
    @Test void caso09() { assertEquals(LocalDate.of(2025,2,28), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2004,2,29),LocalDate.of(2024,3,1))); }
    @Test void caso10() { assertThrows(IllegalArgumentException.class, () -> ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2020,8,10),LocalDate.of(2020,8,9))); }
    @Test void caso11() { assertEquals(LocalDate.of(2020,8,10), ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2020,8,10),LocalDate.of(2020,8,10))); }
    @Test void caso12() { assertThrows(IllegalArgumentException.class, () -> ProximoCumpleanios.calcularProximoCumpleanios(LocalDate.of(2027,1,1),LocalDate.of(2026,1,1))); }
}
