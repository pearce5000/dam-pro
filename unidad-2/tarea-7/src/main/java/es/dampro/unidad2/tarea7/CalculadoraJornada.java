package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Calcula el tiempo total que se ha trabajado en un dia
 *
 * @author
 * @version
 */
public final class CalculadoraJornada {
    private CalculadoraJornada() { }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los minutos de descanso: ");
        int descanso = teclado.nextInt();
        LocalTime entrada = LocalTime.of(9, 00);
        LocalTime salida = LocalTime.of(16, 00);
        Duration jornada = calcularTiempoTrabajado(entrada, salida, descanso);
        System.out.println(jornada);
    }

    /**
     * Calcula el tiempo de la jornada del dia descontando el descanso
     *
     * @param entrada LocalTime Hora de entrada
     * @param salida LocalTime Hora de salida
     * @param descansoMinutos int Cantidad de minutos de descanso
     * @return Duration Tiempo total de trabajo
     */
    public static Duration calcularTiempoTrabajado(LocalTime entrada, LocalTime salida, int descansoMinutos) {
        if (entrada == null || salida == null) {
            return Duration.ZERO;
        }
        Duration jornada = Duration.between(entrada, salida);
        jornada = jornada.minusMinutes(descansoMinutos);
        boolean negativo = salida.isBefore(entrada);
        if (negativo || descansoMinutos < 0 || descansoMinutos > 60 || salida == entrada) {
            throw new IllegalArgumentException();
        }
        return jornada;
    }
}
