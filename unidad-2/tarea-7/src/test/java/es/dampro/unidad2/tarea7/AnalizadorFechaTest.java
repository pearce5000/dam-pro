package es.dampro.unidad2.tarea7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;
import java.time.format.*;

/** Doce casos funcionales independientes de AnalizadorFecha. */
class AnalizadorFechaTest {
    @Test void caso01() { assertEquals("2024-02-29|THURSDAY|60|true|29", AnalizadorFecha.analizarFecha(LocalDate.of(2024,2,29))); }
    @Test void caso02() { assertEquals("2025-02-28|FRIDAY|59|false|28", AnalizadorFecha.analizarFecha(LocalDate.of(2025,2,28))); }
    @Test void caso03() { assertEquals("2026-01-01|THURSDAY|1|false|31", AnalizadorFecha.analizarFecha(LocalDate.of(2026,1,1))); }
    @Test void caso04() { assertEquals("2026-12-31|THURSDAY|365|false|31", AnalizadorFecha.analizarFecha(LocalDate.of(2026,12,31))); }
    @Test void caso05() { assertEquals("2000-01-01|SATURDAY|1|true|31", AnalizadorFecha.analizarFecha(LocalDate.of(2000,1,1))); }
    @Test void caso06() { assertEquals("1900-02-28|WEDNESDAY|59|false|28", AnalizadorFecha.analizarFecha(LocalDate.of(1900,2,28))); }
    @Test void caso07() { assertEquals("2000-12-31|SUNDAY|366|true|31", AnalizadorFecha.analizarFecha(LocalDate.of(2000,12,31))); }
    @Test void caso08() { assertEquals("2026-11-06|FRIDAY|310|false|30", AnalizadorFecha.analizarFecha(LocalDate.of(2026,11,6))); }
    @Test void caso09() { assertEquals("2023-03-01|WEDNESDAY|60|false|31", AnalizadorFecha.analizarFecha(LocalDate.of(2023,3,1))); }
    @Test void caso10() { assertEquals("2024-12-31|TUESDAY|366|true|31", AnalizadorFecha.analizarFecha(LocalDate.of(2024,12,31))); }
    @Test void caso11() { assertEquals("2025-06-15|SUNDAY|166|false|30", AnalizadorFecha.analizarFecha(LocalDate.of(2025,6,15))); }
    @Test void caso12() { assertEquals("2020-02-01|SATURDAY|32|true|29", AnalizadorFecha.analizarFecha(LocalDate.of(2020,2,1))); }
}
