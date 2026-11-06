package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de ComprobadorReservas. */
class ComprobadorReservasTest {
    @Test void caso01() { assertEquals(true, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T11:30"),LocalDateTime.parse("2026-01-01T11:00"),LocalDateTime.parse("2026-01-01T12:00"))); }
    @Test void caso02() { assertEquals(false, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T11:30"),LocalDateTime.parse("2026-01-01T11:30"),LocalDateTime.parse("2026-01-01T12:00"))); }
    @Test void caso03() { assertEquals(false, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T12:00"),LocalDateTime.parse("2026-01-01T09:00"),LocalDateTime.parse("2026-01-01T10:00"))); }
    @Test void caso04() { assertEquals(true, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T12:00"),LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T12:00"))); }
    @Test void caso05() { assertEquals(true, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T12:00"),LocalDateTime.parse("2026-01-01T10:30"),LocalDateTime.parse("2026-01-01T11:00"))); }
    @Test void caso06() { assertEquals(true, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:30"),LocalDateTime.parse("2026-01-01T11:00"),LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T12:00"))); }
    @Test void caso07() { assertEquals(false, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T11:00"),LocalDateTime.parse("2026-01-01T12:00"),LocalDateTime.parse("2026-01-01T13:00"))); }
    @Test void caso08() { assertEquals(true, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T23:00"),LocalDateTime.parse("2026-01-02T01:00"),LocalDateTime.parse("2026-01-02T00:00"),LocalDateTime.parse("2026-01-02T02:00"))); }
    @Test void caso09() { assertThrows(IllegalArgumentException.class, () -> ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T11:00"),LocalDateTime.parse("2026-01-01T12:00"))); }
    @Test void caso10() { assertThrows(IllegalArgumentException.class, () -> ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T11:00"),LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T11:00"),LocalDateTime.parse("2026-01-01T12:00"))); }
    @Test void caso11() { assertThrows(IllegalArgumentException.class, () -> ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T12:00"),LocalDateTime.parse("2026-01-01T11:00"),LocalDateTime.parse("2026-01-01T11:00"))); }
    @Test void caso12() { assertEquals(false, ComprobadorReservas.haySolapamiento(LocalDateTime.parse("2026-01-01T10:00"),LocalDateTime.parse("2026-01-01T12:00"),LocalDateTime.parse("2026-01-01T12:00"),LocalDateTime.parse("2026-01-01T13:00"))); }
}
