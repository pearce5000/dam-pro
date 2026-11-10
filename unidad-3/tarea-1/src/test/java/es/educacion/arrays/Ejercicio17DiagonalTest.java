package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio17DiagonalTest {

    @Test void cuadrada(){assertEquals(15,Ejercicio17Diagonal.sumarDiagonal(new int[][]{{1,9,9},{8,5,7},{6,4,9}}));}
    @Test void uno(){assertEquals(-7,Ejercicio17Diagonal.sumarDiagonal(new int[][]{{-7}}));}
    @Test void vacia(){assertEquals(0,Ejercicio17Diagonal.sumarDiagonal(new int[][]{}));}
    @Test void rectangular(){assertThrows(IllegalArgumentException.class,()->Ejercicio17Diagonal.sumarDiagonal(new int[][]{{1,2}}));}
    @Test void filaNula(){assertThrows(IllegalArgumentException.class,()->Ejercicio17Diagonal.sumarDiagonal(new int[][]{null}));}

}
