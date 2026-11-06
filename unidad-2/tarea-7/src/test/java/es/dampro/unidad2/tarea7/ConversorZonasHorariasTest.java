package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de ConversorZonasHorarias. */
class ConversorZonasHorariasTest {
    @Test void caso01() { assertEquals(ZonedDateTime.of(2026,1,15,13,0,0,0,ZoneId.of("Europe/Madrid")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-01-15T12:00").atZone(ZoneId.of("Atlantic/Canary")),ZoneId.of("Europe/Madrid"))); }
    @Test void caso02() { assertEquals(ZonedDateTime.of(2026,7,15,13,0,0,0,ZoneId.of("Europe/Madrid")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-07-15T12:00").atZone(ZoneId.of("Atlantic/Canary")),ZoneId.of("Europe/Madrid"))); }
    @Test void caso03() { assertEquals(ZonedDateTime.of(2026,1,15,11,0,0,0,ZoneId.of("Atlantic/Canary")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-01-15T12:00").atZone(ZoneId.of("Europe/Madrid")),ZoneId.of("Atlantic/Canary"))); }
    @Test void caso04() { assertEquals(ZonedDateTime.of(2026,1,15,12,0,0,0,ZoneId.of("UTC")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-01-15T12:00").atZone(ZoneId.of("UTC")),ZoneId.of("UTC"))); }
    @Test void caso05() { assertEquals(ZonedDateTime.of(2026,1,15,21,0,0,0,ZoneId.of("Asia/Tokyo")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-01-15T12:00").atZone(ZoneId.of("UTC")),ZoneId.of("Asia/Tokyo"))); }
    @Test void caso06() { assertEquals(ZonedDateTime.of(2026,7,15,8,0,0,0,ZoneId.of("America/New_York")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-07-15T12:00").atZone(ZoneId.of("UTC")),ZoneId.of("America/New_York"))); }
    @Test void caso07() { assertEquals(ZonedDateTime.of(2026,1,15,7,0,0,0,ZoneId.of("America/New_York")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-01-15T12:00").atZone(ZoneId.of("UTC")),ZoneId.of("America/New_York"))); }
    @Test void caso08() { assertEquals(ZonedDateTime.of(2026,1,16,8,30,0,0,ZoneId.of("Asia/Tokyo")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-01-15T23:30").atZone(ZoneId.of("Atlantic/Canary")),ZoneId.of("Asia/Tokyo"))); }
    @Test void caso09() { assertEquals(ZonedDateTime.of(2026,3,29,3,30,0,0,ZoneId.of("Europe/Madrid")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-03-29T01:30").atZone(ZoneId.of("Atlantic/Canary")),ZoneId.of("Europe/Madrid"))); }
    @Test void caso10() { assertEquals(ZonedDateTime.of(2026,11,6,12,0,0,0,ZoneId.of("Europe/Madrid")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-11-06T12:00").atZone(ZoneId.of("Europe/Madrid")),ZoneId.of("Europe/Madrid"))); }
    @Test void caso11() { assertEquals(ZonedDateTime.of(2026,5,31,23,0,0,0,ZoneId.of("UTC")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-06-01T08:00").atZone(ZoneId.of("Asia/Tokyo")),ZoneId.of("UTC"))); }
    @Test void caso12() { assertEquals(ZonedDateTime.of(2027,1,1,12,0,0,0,ZoneId.of("Pacific/Auckland")), ConversorZonasHorarias.convertirZona(LocalDateTime.parse("2026-12-31T23:00").atZone(ZoneId.of("UTC")),ZoneId.of("Pacific/Auckland"))); }
}
