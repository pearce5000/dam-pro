package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio18TransponerTest {

    @Test void dosPorTres(){assertArrayEquals(new int[][]{{1,4},{2,5},{3,6}},Ejercicio18Transponer.transponer(new int[][]{{1,2,3},{4,5,6}}));}
    @Test void cuadrada(){assertArrayEquals(new int[][]{{1,3},{2,4}},Ejercicio18Transponer.transponer(new int[][]{{1,2},{3,4}}));}
    @Test void vacia(){assertArrayEquals(new int[][]{},Ejercicio18Transponer.transponer(new int[][]{}));}
    @Test void irregular(){assertThrows(IllegalArgumentException.class,()->Ejercicio18Transponer.transponer(new int[][]{{1},{2,3}}));}
    @Test void nula(){assertThrows(IllegalArgumentException.class,()->Ejercicio18Transponer.transponer(null));}

}
