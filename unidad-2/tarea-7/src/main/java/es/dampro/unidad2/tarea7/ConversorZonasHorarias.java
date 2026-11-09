package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

/**
 * Cambia la zona horaria de la fecha de origen a otra zona horaria
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class ConversorZonasHorarias {
    private ConversorZonasHorarias() { }

    public static void main(String[] args) {
        ZonedDateTime fechaOrigen = ZonedDateTime.now();
        ZoneId zonaDestino = ZoneId.of("America/New_York");
        ZonedDateTime fechaDestino = convertirZona(fechaOrigen, zonaDestino);
        System.out.println(fechaOrigen);
        System.out.println(fechaDestino);
    }

    /**
     * Cambia la zona horaria de la fecha de origen a la zona fijada
     *
     * @param fechaOrigen ZonedDateTime Fecha de origen
     * @param zonaDestino ZoneId Zona a la que se va a convertir la fecha
     * @return
     */
    public static ZonedDateTime convertirZona(ZonedDateTime fechaOrigen, ZoneId zonaDestino) {
        if (fechaOrigen == null) {
            fechaOrigen = ZonedDateTime.now();
        }
        ZonedDateTime fechaDestino = fechaOrigen.withZoneSameInstant(zonaDestino);
        return fechaDestino;
    }
}
