package es.dampro.unidad2.tarea6;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas del programa principal utilizado para demostrar los algoritmos. */
class MainTest {
    private String ejecutarMain() {
        PrintStream salidaOriginal = System.out;
        ByteArrayOutputStream capturador = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(capturador, true, StandardCharsets.UTF_8));
            Main.main(new String[0]);
        } finally {
            System.setOut(salidaOriginal);
        }
        return capturador.toString(StandardCharsets.UTF_8);
    }

    /** Comprueba que el programa muestra un ejemplo por cada uno de los diez algoritmos. */
    @Test void diezEjemplosTest() {
        assertEquals(10, ejecutarMain().lines().filter(linea -> !linea.isBlank()).count());
    }

    /** Comprueba las etiquetas de los cinco primeros algoritmos. */
    @Test void primerasCincoEtiquetasTest() {
        String[] etiquetas={"InvertirCadena:","Palindromo:","ContadorVocales:","SumaDigitos:","MayorNumero:"};
        String[] lineas=ejecutarMain().lines().toArray(String[]::new);
        assertTrue(lineas.length >= 10);
        for (int indice=0; indice<5; indice++) assertTrue(lineas[indice].startsWith(etiquetas[indice]));
    }

    /** Comprueba las etiquetas de los cinco últimos algoritmos. */
    @Test void ultimasCincoEtiquetasTest() {
        String[] etiquetas={"BinarioDecimal:","Factorial:","NumeroPrimo:","EcuacionCuadratica:","MediaNumeros:"};
        String[] lineas=ejecutarMain().lines().toArray(String[]::new);
        assertTrue(lineas.length >= 10);
        for (int indice=0; indice<5; indice++) assertTrue(lineas[indice+5].startsWith(etiquetas[indice]));
    }

    /** Comprueba que cada línea contiene un resultado no vacío tras su etiqueta. */
    @Test void ejemplosContienenResultadosTest() {
        String[] lineas=ejecutarMain().lines().toArray(String[]::new);
        assertTrue(lineas.length >= 10);
        for (int indice=0; indice<10; indice++) {
            assertTrue(lineas[indice].contains(":"));
            assertFalse(lineas[indice].substring(lineas[indice].indexOf(':')+1).trim().isEmpty());
        }
    }
}
