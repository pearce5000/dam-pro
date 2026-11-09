package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * TODO: Describe la finalidad de CalculadoraJornada.
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
     * TODO: Describe lo que hace el método.
     *
     * @param entrada
     * @param salida
     * @param descansoMinutos
     * @return
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
