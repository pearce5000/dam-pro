package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

/**
 * TODO: Describe la finalidad de ProximoCumpleanios.
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class ProximoCumpleanios {
    private ProximoCumpleanios() { }

    /**
     * Calcula la fecha del proximo cumpleanios de una persona
     *
     * @param nacimiento LocalDate Fecha de nacimiento de una persona
     * @param hoy LocalDate Fecha actual
     * @return LocalDate Fecha del proximo cumpleanios
     */
    public static LocalDate calcularProximoCumpleanios(LocalDate nacimiento, LocalDate hoy) {
        if (nacimiento.isBefore(hoy)) {
            throw new IllegalArgumentException();
        }

        return LocalDate.MIN;
    }
}
