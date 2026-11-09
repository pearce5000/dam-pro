package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

/**
 * TODO: Describe la finalidad de ComprobadorReservas.
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class ComprobadorReservas {
    private ComprobadorReservas() { }

    /**
     * Se indica si hay solapamiento de las fechas de los eventos
     *
     * @param inicio1 Fecha de inicio del primer evento
     * @param fin1 Fecha de finalizacion del primer evento
     * @param inicio2 Fecha de inicio del segundo evento
     * @param fin2 Fecha de finalizacion del segundo evento
     * @return true/false
     */
    public static boolean haySolapamiento(LocalDateTime inicio1, LocalDateTime fin1, LocalDateTime inicio2, LocalDateTime fin2) {
        if (inicio1.isAfter(fin1) || inicio2.isAfter(fin2)) {
            throw new IllegalArgumentException();
        }
        if (fin1.isAfter(inicio2)) {
            return true;
        }

        return false;
    }
}
