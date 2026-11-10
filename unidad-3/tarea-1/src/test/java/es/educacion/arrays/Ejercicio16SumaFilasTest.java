package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio16SumaFilasTest {

    @Test void rectangular(){assertArrayEquals(new int[]{6,9},Ejercicio16SumaFilas.sumarFilas(new int[][]{{1,2,3},{4,5}}));}
    @Test void filasVacias(){assertArrayEquals(new int[]{0,4},Ejercicio16SumaFilas.sumarFilas(new int[][]{{},{4}}));}
    @Test void matrizVacia(){assertArrayEquals(new int[]{},Ejercicio16SumaFilas.sumarFilas(new int[][]{}));}
    @Test void negativos(){assertArrayEquals(new int[]{-3,0},Ejercicio16SumaFilas.sumarFilas(new int[][]{{-1,-2},{5,-5}}));}
    @Test void filaNula(){assertThrows(IllegalArgumentException.class,()->Ejercicio16SumaFilas.sumarFilas(new int[][]{null}));}

}
