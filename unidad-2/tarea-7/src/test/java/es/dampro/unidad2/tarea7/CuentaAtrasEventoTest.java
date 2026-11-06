package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de CuentaAtrasEvento. */
class CuentaAtrasEventoTest {
    @Test void caso01() { assertEquals(24L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2026,12,1),LocalDate.of(2026,12,25))); }
    @Test void caso02() { assertEquals(-24L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2026,12,25),LocalDate.of(2026,12,1))); }
    @Test void caso03() { assertEquals(0L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2026,11,6),LocalDate.of(2026,11,6))); }
    @Test void caso04() { assertEquals(2L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2024,2,28),LocalDate.of(2024,3,1))); }
    @Test void caso05() { assertEquals(1L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2025,2,28),LocalDate.of(2025,3,1))); }
    @Test void caso06() { assertEquals(1L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2026,12,31),LocalDate.of(2027,1,1))); }
    @Test void caso07() { assertEquals(365L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2025,1,1),LocalDate.of(2026,1,1))); }
    @Test void caso08() { assertEquals(366L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2024,1,1),LocalDate.of(2025,1,1))); }
    @Test void caso09() { assertEquals(7L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2026,1,1),LocalDate.of(2026,1,8))); }
    @Test void caso10() { assertEquals(-7L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2026,1,8),LocalDate.of(2026,1,1))); }
    @Test void caso11() { assertEquals(30L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2026,6,15),LocalDate.of(2026,7,15))); }
    @Test void caso12() { assertEquals(365L, CuentaAtrasEvento.calcularDiasRestantes(LocalDate.of(2026,11,6),LocalDate.of(2027,11,6))); }
}
