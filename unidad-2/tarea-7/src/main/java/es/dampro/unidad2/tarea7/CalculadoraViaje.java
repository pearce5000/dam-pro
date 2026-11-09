package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Calcula la fecha y hora de llegada de un viaje
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class CalculadoraViaje {
    private CalculadoraViaje() { }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


    }

    /**
     * Calcula la fecha y hora de la llegada de un viaje
     *
     * @param salida LocalDateTime Hora de salida del viaje
     * @param horas long Horas de viaje
     * @param minutos long Minutos de viaje
     * @return LocalDateTime Hora de llegada
     */
    public static LocalDateTime calcularLlegada(LocalDateTime salida, long horas, long minutos) {
        LocalDateTime llegada = salida.plusHours(horas);
        llegada = llegada.plusMinutes(minutos);
        boolean negativo = llegada.isBefore(salida);
        if (negativo) {
            throw new IllegalArgumentException();
        }
        return llegada;
    }
}
