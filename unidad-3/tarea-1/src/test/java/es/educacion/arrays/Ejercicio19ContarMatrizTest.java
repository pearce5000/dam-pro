package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio19ContarMatrizTest {

    @Test void repetidos(){assertEquals(3,Ejercicio19ContarMatriz.contar(new int[][]{{1,2,1},{1,3}},1));}
    @Test void noExiste(){assertEquals(0,Ejercicio19ContarMatriz.contar(new int[][]{{0,-1}},5));}
    @Test void matrizVacia(){assertEquals(0,Ejercicio19ContarMatriz.contar(new int[][]{},1));}
    @Test void filasVacias(){assertEquals(1,Ejercicio19ContarMatriz.contar(new int[][]{{},{7}},7));}
    @Test void filaNula(){assertThrows(IllegalArgumentException.class,()->Ejercicio19ContarMatriz.contar(new int[][]{null},1));}

}
