package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

/**
 * TODO: Describe la finalidad de CuentaAtrasEvento.
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class CuentaAtrasEvento {
    private CuentaAtrasEvento() { }

    public static void main(String[] args) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaEvento = LocalDate.of(2026, 11, 25);
        long diasRestantes = calcularDiasRestantes(fechaActual, fechaEvento);
        System.out.println(diasRestantes);
    }

    /**
     * Calcula la diferencia de dias de la fecha actual a una fecha establecida
     *
     * @param hoy LocalDate Fecha actual
     * @param evento LocalDate Fecha del evento
     * @return long Diferencia en dias de las dos fechas
     */
    public static long calcularDiasRestantes(LocalDate hoy, LocalDate evento) {
        if (hoy == null) {
            hoy = LocalDate.now();
        }
        if (evento == null) {
            return 0;
        }
        long diasRestantes = evento.compareTo(hoy);
        return diasRestantes;
    }
}
