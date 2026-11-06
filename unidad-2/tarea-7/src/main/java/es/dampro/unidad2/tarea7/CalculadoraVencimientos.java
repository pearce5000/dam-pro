package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * TODO: Describe la finalidad de CalculadoraVencimientos.
 *
 * @author
 * @version
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

        LocalDate vencimiento = calcularVencimiento(fechaActual,anios,meses,dias);
        System.out.println(vencimiento);
    }

    /**
     * TODO: Describe lo que hace el método.
     *
     * @param fecha
     * @param dias
     * @param meses
     * @param anios
     * @return
     */
    public static LocalDate calcularVencimiento(LocalDate fecha, int dias, int meses, int anios) {
        if (fecha == null) {
            fecha = LocalDate.now();
        }
        LocalDate vencimiento = fecha.plusYears(anios);
        vencimiento = fecha.plusMonths(meses);
        vencimiento = fecha.plusDays(dias);

        return vencimiento;
    }
}
