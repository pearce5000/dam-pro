package es.educacion.arrays;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class Ejercicio15DocumentarTest {
    private static String fuente() throws IOException {
        return Files.readString(Path.of("src/main/java/es/educacion/arrays/Ejercicio15Documentar.java"));
    }

    private static String docAntesDe(String texto, String firma) {
        Pattern p = Pattern.compile("(?s)/\\*\\*(.*?)\\*/\\s*" + Pattern.quote(firma));
        Matcher m = p.matcher(texto);
        return m.find() ? m.group(1).replace('*', ' ').trim() : "";
    }

    @Test void claseTieneJavadocDescriptivo() throws IOException {
        assertTrue(docAntesDe(fuente(), "public final class Ejercicio15Documentar").length() >= 25);
    }

    @Test void longitudTieneDescripcion() throws IOException {
        String doc = docAntesDe(fuente(), "public static int longitud(");
        assertTrue(doc.split("@param|@return")[0].trim().length() >= 25);
    }

    @Test void longitudTieneParamYReturn() throws IOException {
        String doc = docAntesDe(fuente(), "public static int longitud(");
        assertTrue(doc.matches("(?s).*@param\\s+numeros\\s+\\S+.*"));
        assertTrue(doc.matches("(?s).*@return\\s+\\S+.*"));
    }

    @Test void tieneElementosTieneDescripcion() throws IOException {
        String doc = docAntesDe(fuente(), "public static boolean tieneElementos(");
        assertTrue(doc.split("@param|@return")[0].trim().length() >= 25);
    }

    @Test void tieneElementosTieneParamYReturn() throws IOException {
        String doc = docAntesDe(fuente(), "public static boolean tieneElementos(");
        assertTrue(doc.matches("(?s).*@param\\s+numeros\\s+\\S+.*"));
        assertTrue(doc.matches("(?s).*@return\\s+\\S+.*"));
    }
}
