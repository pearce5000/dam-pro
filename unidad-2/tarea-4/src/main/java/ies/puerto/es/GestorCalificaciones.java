package ies.puerto.es;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Daniel Morales
 * @version 1.0.0
 */
public class GestorCalificaciones {

    static void main() {
        List<Double> notas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        do {
            Double nota = solicitarNotaValida();
            notas.add(nota);
            System.out.println("¿Quieres añadir otra nota? (true/false)");
            String sSalir = teclado.nextLine();
            salir = Boolean.parseBoolean(sSalir);
        } while (salir);


        System.out.println("Lista de notas: "+notas);
        double media = calcularMedia(notas);
        System.out.println("La nota media es: "+media);
        double maximo = obtenerMaxima(notas);
        System.out.println("El valor máximo es: "+maximo);
        double minimo = obtenerMinimo(notas);
        System.out.println("El valor minimo es: "+minimo);
    }

    /**
     * Función que convierte los numeros en String a enteros primitivos
     * @param sNumero String que guarda el numero
     * @return int que guarda el numero
     */
    static int convertirNumeroNotas(String sNumero) {
        int numero = 0;
        if (sNumero == null || sNumero.isEmpty()) {
            return 0;
        }

        //return Integer.parseInt(sNumero);
        numero = Integer.parseInt(sNumero);
        return numero;
    }

    /**
     * Función que pasa los numeros guardados en String a double
     * @param sNumero String que guarda el numero
     * @return double que contiene el numero
     */
    static double convertirNota(String sNumero) {
        double numero = 0;

        if (sNumero == null || sNumero.isEmpty()) {
            return 0;
        }
        numero = Double.parseDouble(sNumero);
        return numero;
    }

    /**
     * Función que determina si un numero es válido o no
     * @param dNumero double que guarda el numero
     * @return boolean que muestra si el numero es válido o no
     */
    static boolean esNotaValida(Double dNumero) {
        if (dNumero == null) {
            return false;
        }
        if (dNumero < 0 || dNumero >10) {
            return false;
        }
        return true;
    }

    /**
     * Función que procesa la nota introducida y comprueba que sea válida
     * @return double que guarda el numero de la nota
     */
    static Double solicitarNotaValida() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la nota: ");
        String sNota = teclado.nextLine();
        Double dNumero = null;
        try {
            dNumero = convertirNota(sNota);
        } catch (NumberFormatException e) {
            throw new RuntimeException("El numero insertado es incorrecto");
        }

        boolean bValida = esNotaValida(dNumero);
        return dNumero;
    }

    /**
     * Función que calcula la media de la lista de notas
     * @param lNotas List que guarda las diferentes notas
     * @return double que guarda la media de las notas
     */
    static double calcularMedia(List<Double> lNotas) {
        double media = 0;
        double suma = 0;
        for (int i = 0; i < lNotas.size(); i++) {
            suma = suma + lNotas.get(i);
        }
        media = suma/lNotas.size();
        return media;
    }

    /**
     * Función que recorre la lista y obtiene la nota máxima
     * @param lNotas List que recoge las notas
     * @return double que guarda la nota máxima de la lista
     */
    static double obtenerMaxima(List<Double> lNotas) {
        double maximo = 0;
        for (int i = 0; i < lNotas.size(); i++) {
            if(lNotas.get(i)>maximo) {
                maximo = lNotas.get(i);
            }
            if (maximo == 10) {
                return maximo;
            }
        }
        return maximo;
    }


    /**
     * Función que recorre la lista y obtiene la nota mínima
     * @param lNotas List que guarda las notas
     * @return double que guarda la nota mínima de la lista
     */
    static double obtenerMinimo(List<Double> lNotas) {
        double minimo = 10;
        for (int i = 0; i < lNotas.size(); i++) {
            if(lNotas.get(i) < minimo) {
                minimo = lNotas.get(i);
            }
            if (minimo == 0) {
                return minimo;
            }
        }
        return minimo;
    }
}
