package es.dampro.unidad2.tarea7;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Clase que tiene como función analizar una fecha
 *
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class AnalizadorFecha {
    private AnalizadorFecha() { }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(analizarFecha(null));

    }
    /**
     * Analiza una fecha dada
     *
     * @param fecha LocalDate Fecha de entrada para el analisis
     * @return String formateado
     */
    public static String analizarFecha(LocalDate fecha) {
        if (fecha == null) {
            fecha = LocalDate.now();
        }

        String resultado ="";
        resultado = resultado + fecha +"|"+ fecha.getDayOfWeek() +"|"+
                fecha.getDayOfYear() +"|"+ fecha.isLeapYear() +"|"+
                fecha.lengthOfMonth();

        return resultado;
    }
}
