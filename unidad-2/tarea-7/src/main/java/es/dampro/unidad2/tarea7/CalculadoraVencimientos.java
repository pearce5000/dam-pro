package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Se calcula la fecha limite de un plazo con referencia a una fecha inicial.
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class CalculadoraVencimientos {
    private CalculadoraVencimientos() { }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LocalDate fechaActual = LocalDate.now();
        System.out.println("Introduzca los años: ");
        int anios = teclado.nextInt();
        System.out.println("Introduzca los meses: ");
        int meses = teclado.nextInt();
        System.out.println("Introduzca los dias: ");
        int dias = teclado.nextInt();

        LocalDate vencimiento = calcularVencimiento(fechaActual,dias,meses,anios);
        System.out.println("Fecha actual: "+fechaActual);
        System.out.println("Vencimiento: "+vencimiento);
    }

    /**
     * Se calcula la fecha limite de un plazo
     *
     * @param fecha LocalDate que indica la fecha inicial del plazo
     * @param dias int dias de diferencia entre la fecha inicial y la fecha limite
     * @param meses int meses de diferencia entre la fecha inicial y la fecha limite
     * @param anios int anios de diferencia entre la fecha inicial y la fecha limite
     * @return
     */
    public static LocalDate calcularVencimiento(LocalDate fecha, int dias, int meses, int anios) {
        if (fecha == null) {
            fecha = LocalDate.now();
        }
        LocalDate vencimiento = fecha.plusYears(anios);
        vencimiento = vencimiento.plusMonths(meses);
        vencimiento = vencimiento.plusDays(dias);

        return vencimiento;
    }
}
