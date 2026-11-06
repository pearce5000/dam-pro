package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de ValidadorFechas. */
class ValidadorFechasTest {
    @Test void caso01() { assertEquals(LocalDate.of(2024,2,29), ValidadorFechas.validarFecha("29/02/2024")); }
    @Test void caso02() { assertEquals(LocalDate.of(2025,2,28), ValidadorFechas.validarFecha("28/02/2025")); }
    @Test void caso03() { assertEquals(LocalDate.of(2026,12,31), ValidadorFechas.validarFecha("31/12/2026")); }
    @Test void caso04() { assertEquals(LocalDate.of(2000,1,1), ValidadorFechas.validarFecha("01/01/2000")); }
    @Test void caso05() { assertEquals(LocalDate.of(2026,6,15), ValidadorFechas.validarFecha("15/06/2026")); }
    @Test void caso06() { assertEquals(LocalDate.of(2000,2,29), ValidadorFechas.validarFecha("29/02/2000")); }
    @Test void caso07() { assertThrows(DateTimeParseException.class, () -> ValidadorFechas.validarFecha("29/02/2025")); }
    @Test void caso08() { assertThrows(DateTimeParseException.class, () -> ValidadorFechas.validarFecha("31/04/2026")); }
    @Test void caso09() { assertThrows(DateTimeParseException.class, () -> ValidadorFechas.validarFecha("32/01/2026")); }
    @Test void caso10() { assertThrows(DateTimeParseException.class, () -> ValidadorFechas.validarFecha("1/01/2026")); }
    @Test void caso11() { assertThrows(DateTimeParseException.class, () -> ValidadorFechas.validarFecha("01-01-2026")); }
    @Test void caso12() { assertThrows(DateTimeParseException.class, () -> ValidadorFechas.validarFecha("texto")); }
}
