package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio04ContarAprobadosTest {
    @Test
    void mezclaNotas() {
        assertEquals(3, Ejercicio04ContarAprobados.contarAprobados(new int[]{4, 5, 7, 2, 10}));
    }

    @Test
    void todosSuspendidos() {
        assertEquals(0, Ejercicio04ContarAprobados.contarAprobados(new int[]{0, 1, 4}));
    }

    @Test
    void todosAprobados() {
        assertEquals(3, Ejercicio04ContarAprobados.contarAprobados(new int[]{5, 7, 10}));
    }

    @Test
    void arrayVacio() {
        assertEquals(0, Ejercicio04ContarAprobados.contarAprobados(new int[]{}));
    }

    @Test
    void arrayNulo() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio04ContarAprobados.contarAprobados(null));
    }

}
