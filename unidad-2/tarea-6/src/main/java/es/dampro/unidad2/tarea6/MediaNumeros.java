package es.dampro.unidad2.tarea6;

import java.util.Scanner;

/** TODO: documenta la finalidad de la clase.
 * @author Daniel Morales
 * @version 1.0.0
 */
public final class MediaNumeros {
    private MediaNumeros() { }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        String sNumero = teclado.nextLine();
        double resultado = calcularMedia(sNumero);
        System.out.println("La media es = "+resultado);
    }

    /**
     * TODO: describe cómo se realiza el algoritmo.
     * @param numeros String que guarda la cadena de numeros
     * @return double que guarda la media
     */
    public static double calcularMedia(String numeros) {
        if (numeros == null || numeros.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < numeros.length(); i++) {
            char cNumero = numeros.charAt(i);
            String sNumero = String.valueOf(cNumero);
            int numero = Integer.parseInt(sNumero);
            suma = suma + numero;
        }
        return suma / numeros.length();
        //throw new UnsupportedOperationException("Método pendiente de implementar: calcularMedia");
    }
}
