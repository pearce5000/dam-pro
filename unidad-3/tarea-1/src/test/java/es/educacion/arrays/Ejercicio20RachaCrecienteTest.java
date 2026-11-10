package es.educacion.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio20RachaCrecienteTest {

    @Test void dosRachas(){assertEquals(4,Ejercicio20RachaCreciente.longitudMayorRacha(new int[]{1,2,0,1,2,3,0}));}
    @Test void decreciente(){assertEquals(1,Ejercicio20RachaCreciente.longitudMayorRacha(new int[]{5,4,3}));}
    @Test void repetidos(){assertEquals(2,Ejercicio20RachaCreciente.longitudMayorRacha(new int[]{1,1,2,2}));}
    @Test void vacio(){assertEquals(0,Ejercicio20RachaCreciente.longitudMayorRacha(new int[]{}));}
    @Test void nulo(){assertThrows(IllegalArgumentException.class,()->Ejercicio20RachaCreciente.longitudMayorRacha(null));}

}
