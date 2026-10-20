# Tarea 4 — Clases envolventes y funciones en Java

> **Entorno:** IntelliJ IDEA · **Maven** · **JDK 21 o JDK 27**  
> **Nombre del proyecto:** `tarea-4`  
> **Modalidad:** individual  
> **Tiempo orientativo:** 3–4 sesiones  
> **Repositorio:** `dam-pro` (GitHub público) · **Ruta:** `unidad-02/tarea-4/`  
> **Entrega:** enlace público directo a la carpeta de la tarea en GitHub, publicado en Moodle. **No se entrega ZIP.**

## 1. Objetivos

En esta tarea practicarás las clases envolventes de Java y reforzarás la **descomposición de problemas en funciones**. Al terminar deberás ser capaz de:

- Identificar las diferencias entre tipos primitivos y envolventes (`int`/`Integer`, `double`/`Double`, `boolean`/`Boolean` y `char`/`Character`).
- Convertir texto mediante métodos como `parseInt`, `parseDouble`, `parseBoolean` y `valueOf`.
- Explicar y utilizar autoboxing y unboxing.
- Analizar caracteres con la clase `Character`.
- Trabajar con `ArrayList<Double>` y comparar objetos mediante `compareTo`.
- Gestionar entradas incorrectas sin que termine inesperadamente el programa.
- Diseñar funciones con responsabilidades claras, **parámetros** y **valores de retorno**.
- **Documentar todas las clases y funciones con Javadoc**.

**Consulta:** [Lección — Clases envolventes](https://codelearnacademy.github.io/java/leccion02/12-clases-envolventes/).

> **Importante:** Este documento es un enunciado guiado. **No contiene código fuente Java ni soluciones.** Debes programar las clases y funciones por tu cuenta.

---

## Preparación del repositorio GitHub (siguiendo la Tarea 3)

Esta tarea **continúa en el mismo repositorio público `dam-pro`** de la Tarea 3. Conserva las tareas anteriores y usa la rama `main`. La carpeta de trabajo será `~/git/dam-pro/` (Windows con **Git Bash** o Debian con **Bash**).

1. Comprueba en [GitHub](https://github.com) que existe tu repositorio público `dam-pro`. **No crees otro repositorio** para la Tarea 4. Si todavía no existe, créalo con ese nombre, visibilidad pública y un README inicial.
2. Abre IntelliJ IDEA y su terminal en **View → Tool Windows → Terminal** (`Alt + F12`). En Windows utiliza Git Bash; en Debian, Bash.
3. Comprueba que Git está disponible e identifica el repositorio remoto:

```bash
git --version
cd ~
mkdir -p git
cd git
ls
```

Si la carpeta `dam-pro` ya existe, entra en ella y comprueba que pertenece al repositorio correcto:

```bash
cd dam-pro
git status
git remote -v
```

Si **no** existe, clona tu repositorio de GitHub (sustituye `TU_USUARIO`):

```bash
git clone https://github.com/TU_USUARIO/dam-pro.git
cd dam-pro
git status
git remote -v
```

4. Antes de comenzar, comprueba la rama y sincroniza desde la raíz `dam-pro`:

```bash
git branch --show-current
git status
git fetch origin
git log --oneline HEAD..origin/main
git pull --ff-only origin main
```

> Si existen cambios locales pendientes o Git comunica un conflicto, revisa la situación y consulta al profesor. **No uses** `git init` dentro de la tarea, `push --force`, `reset --hard` ni borres las carpetas anteriores.

5. En IntelliJ IDEA abre `git/dam-pro`. Comprueba que existe `unidad-02/` y que su `README.md` conserva las tareas anteriores. Si la unidad no existe, créala desde el IDE. **No reemplaces** un README existente.
6. En `unidad-02/README.md`, conserva el índice y añade esta fila **sin duplicarla**:

```markdown
| [Tarea 4](tarea-4/) | Clases envolventes y funciones | En desarrollo |
```

Cuando hayas completado y probado toda la práctica, cambiarás solo esa fila a **Completada**.

---

## 2. Crear un proyecto Maven en IntelliJ IDEA

### Paso 1. Verificar el JDK instalado

1. Abre una terminal (del sistema o de IntelliJ IDEA).
2. Ejecuta el comando `java -version`. Comprueba que la versión principal indicada es **21 o 27**.
3. Ejecuta `javac -version`. Comprueba que el compilador también corresponde a **21 o 27**.
4. Si no está instalado uno de esos JDK, instálalo desde **Download JDK** de IntelliJ IDEA o desde un proveedor de JDK. Evita confundir un **JDK** con un **JRE**.
5. Si `java` o `javac` muestran otra versión, recuerda que puede haber varias instalaciones. **La versión usada para compilar el proyecto se debe verificar además dentro de IntelliJ.**

**Evidencia requerida:** anota en el README del proyecto los resultados de `java -version` y `javac -version` y el JDK seleccionado en IntelliJ. No hace falta que sean idénticos si el terminal utiliza otra instalación: explica la diferencia y asegúrate de que **IntelliJ y Maven** usan 21 o 27.

### Paso 2. Crear `tarea-4` como Maven

1. Abre **IntelliJ IDEA** y selecciona **New Project** (o **File → New → Project**).
2. Escoge **Java** como lenguaje y **Maven** como **Build system**. En algunas versiones de IntelliJ aparece **Maven** como tipo de proyecto independiente.
3. Escribe `tarea-4` como **Name** y, en **Location**, selecciona `~/git/dam-pro/unidad-02/`. Comprueba que la ruta final sea exactamente `~/git/dam-pro/unidad-02/tarea-4/` y **no** `tarea-4/tarea-4/`. Si la tarea ya existe con `pom.xml`, ábrela: no la recrees.
4. Configura **GroupId** como `ies.puerto.es` y **ArtifactId** como `tarea-4` (si IntelliJ solicita estas coordenadas). El paquete Java que crearás también será `ies.puerto.es`.
5. Selecciona como **JDK del proyecto** la versión **21 o 27** que hayas comprobado.
6. Si aparece **Create Git repository**, desactívalo: esta carpeta pertenece al repositorio existente `dam-pro`. Si aparece la opción de generar un proyecto de ejemplo, puedes desactivarla.
7. Pulsa **Create** y espera a que Maven importe el proyecto.
8. Comprueba que existe un archivo **`pom.xml`** en la raíz de la nueva tarea. Añade a esa misma carpeta este enunciado como **`README.md`**: **no borres ni sustituyas su contenido**. Al final incorporarás tu sección de desarrollo y pruebas.

### Paso 3. Comprobar que IDE y Maven utilizan la misma versión

1. Ve a **File → Project Structure → Project**. Comprueba el **Project SDK** y el **Language level**.
2. Abre **Settings → Build, Execution, Deployment → Build Tools → Maven → Runner** y revisa el **JRE/JDK** del proceso Maven. Selecciona un JDK **21 o 27**.
3. En **Settings → Build Tools → Maven → Importing**, comprueba el JDK de importación si aparece en tu versión del IDE.
4. Revisa el archivo `pom.xml` y configura el **nivel de compilación Java** del proyecto a **21 o 27**, coincidiendo con el JDK seleccionado. Puedes usar la propiedad de Maven `maven.compiler.release` o la configuración equivalente del compilador; **no indiques una versión superior a la del JDK que realmente compila**.
5. Abre la terminal de IntelliJ y ejecuta `mvn -version` (o `mvnw -version` si has incorporado Maven Wrapper). Comprueba que Maven se ejecuta con **Java 21 o 27**.
6. Ejecuta `mvn clean compile` y comprueba que la compilación finaliza correctamente.

> **Atención:** `java -version` comprueba el Java visible para la terminal; `mvn -version` muestra el Java usado por Maven. **Son comprobaciones diferentes.** Si `mvn` no está disponible, utiliza las acciones **clean** y **compile** de la ventana Maven de IntelliJ y revisa el JDK del Runner.

### Paso 4. Organizar las clases

Localiza `src/main/java` y crea el paquete **`ies.puerto.es`** (en IntelliJ, clic derecho en `java` → **New → Package**). Dentro de él, crea las siguientes clases Java. Comprueba que todas declaran el paquete `ies.puerto.es`:

- `DatosPersonales`
- `AnalizadorContrasena`
- `GestorCalificaciones`

La estructura orientativa debe ser:

```text
git/dam-pro/
├── README.md                         (conservar)
└── unidad-02/
    ├── README.md                     (índice de tareas)
    ├── tarea3/                       (conservar)
    └── tarea-4/
        ├── pom.xml
        ├── README.md
        └── src/
            ├── main/
            │   └── java/
            │       └── ies/
            │           └── puerto/
            │               └── es/
            │                   ├── DatosPersonales.java
            │                   ├── AnalizadorContrasena.java
            │                   └── GestorCalificaciones.java
            └── test/
                └── java/           (opcional)
```

Cada clase debe poder ejecutarse individualmente desde IntelliJ y disponer de un punto de entrada. **La lógica se repartirá entre funciones:** el método principal se dedicará principalmente a coordinar llamadas, obtener entradas y presentar resultados.

---

## 3. Normas comunes de desarrollo

Estas condiciones son **obligatorias en los tres ejercicios**:

1. Divide el problema en **funciones pequeñas** con nombres descriptivos; evita concentrarlo todo en el método principal.
2. Cada función debe realizar **una responsabilidad concreta**.
3. Decide qué **parámetros** necesita y qué **tipo de dato devuelve**. Usa funciones sin retorno cuando solo presenten información.
4. Utiliza funciones de transformación: reciben datos de un tipo o representación y devuelven otra representación o un resultado procesado.
5. Evita recurrir a variables globales para pasar información entre funciones.
6. **Documenta cada clase y cada función utilizando Javadoc**, incluidas las funciones auxiliares. Para los métodos con parámetros incluye `@param`; cuando devuelvan un valor, `@return`; cuando corresponda, documenta las excepciones con `@throws`.
7. Incluye una descripción breve del propósito de la clase y la autoría de la tarea. Los comentarios deben explicar las decisiones importantes y no repetir lo evidente.
8. Prueba entradas correctas, valores límite y entradas incorrectas.

### Cómo plantear una función antes de programarla

Para cada función anota en tu cuaderno o en el README:

| Elemento | Pregunta que debes responder |
|---|---|
| Nombre | ¿Qué acción realiza? |
| Entrada | ¿Qué parámetros recibe y de qué tipo son? |
| Salida | ¿Qué dato devuelve y de qué tipo es? |
| Transformación | ¿Cómo transforma o analiza la entrada? |
| Casos especiales | ¿Qué sucede ante un dato no válido o `null`? |
| Javadoc | ¿Cómo describirás su contrato sin explicar línea por línea su código? |

**Lista de comprobación de Javadoc:** debe existir un comentario Javadoc **antes de cada declaración de clase y de cada función**; incluye etiquetas cuando correspondan. No basta con comentarios de una sola línea.

---

## 4. Ejercicio 1 — Conversor de datos personales

**Dificultad:** básica · **Clase:** `DatosPersonales`

### Situación inicial

Dispones de una ficha de una persona cuyos datos se reciben inicialmente como cadenas de texto: nombre `"Ana"`, edad `"21"`, altura `"1.68"` y matrícula `"true"`. Debes transformar esos datos, obtener información derivada y presentar una ficha. **No escribas toda la lógica en el método principal:** implementa las funciones descritas y úsalas para construir el resultado.

### Funciones que debes desarrollar

#### 1. `convertirEdad`

Esta función transformará una edad que hemos recibido como texto (`String`) en un número entero primitivo (`int`). Para hacerlo, utiliza la **clase envolvente `Integer`** y específicamente su método estático **`valueOf()`**. Recuerda que `valueOf()` produce un objeto `Integer`; cuando se utiliza ese resultado como un `int`, Java realiza automáticamente una conversión llamada **unboxing**.

- **Recibe:** una cadena `String` con una edad numérica.
- **Devuelve:** un valor `int` con la edad.
- **Ejemplo:** recibe `"21"` y devuelve el número `21`, no el texto `"21"`.
- **Debes documentar:** qué tipo de texto espera y qué ocurre si el texto no representa un entero válido.

#### 2. `convertirAltura`

Esta función recibirá la altura como texto y la transformará en un **objeto `Double`**, que puede representar un número decimal. Utiliza **`Double.valueOf()`**, de manera que practiques la creación de un valor envolvente a partir de una cadena.

- **Recibe:** un `String` que represente una altura decimal en metros, usando punto decimal.
- **Devuelve:** un `Double`.
- **Ejemplo:** `"1.68"` se transforma en un objeto cuyo valor es `1.68`.
- **Debes documentar:** el formato esperado, la unidad de medida y el retorno.

#### 3. `convertirMatricula`

Esta función interpretará el estado de matrícula recibido como texto. Utiliza **`Boolean.parseBoolean()`** para transformarlo en un valor lógico primitivo, que permitirá tomar decisiones posteriores.

- **Recibe:** un `String` que indique si está matriculada, como `"true"` o `"false"`.
- **Devuelve:** un `boolean`.
- **Ejemplo:** `"true"` se convierte en `true`.
- **Atención:** `Boolean.parseBoolean()` devuelve `false` ante cualquier texto distinto de `"true"` sin distinguir entre un `"false"` legítimo y un error de escritura. Explícalo en tu documentación o reflexión.

#### 4. `esMayorDeEdad`

Esta función ya no convierte texto: **transforma una edad numérica en una respuesta lógica**. Debe comparar la edad recibida con el límite de mayoría de edad, **18 años**, y devolver el resultado en lugar de imprimirlo.

- **Recibe:** una edad `int`.
- **Devuelve:** `boolean`.
- **Ejemplos:** con `17`, devuelve `false`; con `18`, devuelve `true`.
- **Debes documentar:** el criterio utilizado para considerar mayor de edad.

#### 5. `convertirEdadAEnvolvente`

Esta función transformará el valor primitivo de la edad en su tipo envolvente. **Recibe un `int` y devuelve un `Integer`**, aprovechando el proceso automático de **autoboxing**. La finalidad es comprender la relación entre el dato primitivo y el objeto.

- **Recibe:** un `int`.
- **Devuelve:** un `Integer`.
- **Ejemplo:** recibe el número `21` como primitivo y devuelve un objeto `Integer` que representa `21`.
- **Debes poder explicar:** por qué cambia el tipo aunque el valor mostrado sea el mismo.

#### 6. `recuperarEdadPrimitiva`

Esta función realizará la transformación inversa: obtendrá un número primitivo a partir de un objeto envolvente `Integer`. Debes aplicar **unboxing**.

- **Recibe:** un objeto `Integer`.
- **Devuelve:** un `int`.
- **Ejemplo:** recibe un `Integer` con valor `21` y devuelve el primitivo `21`.
- **Debes documentar:** qué sucedería si se recibiera `null` y se intentara realizar el unboxing.

#### 7. `formatearFicha`

Esta función reunirá los datos procesados y **transformará varios valores en un único texto legible**. Debe recibir el nombre, la edad, la altura, la matrícula y el resultado de la comprobación de mayoría de edad, además de cualquier otro dato que decidas mostrar. No debe leer del teclado ni encargarse de convertir el texto original.

- **Recibe:** los datos ya transformados, con sus tipos apropiados.
- **Devuelve:** un `String` con la ficha completa, distribuida en varias líneas.
- **Ejemplo:** debe poder construir líneas como `Edad: 21` y `Mayor de edad: true`.
- **Debes documentar:** qué representa cada parámetro y qué contiene el texto final.

### Integración y pruebas

En el método principal, define o recoge los datos iniciales, llama a las funciones siguiendo un orden lógico y presenta el resultado de `formatearFicha`. Comprueba los casos de edad `17`, `18` y `21`, el estado de matrícula `"false"` y una edad escrita incorrectamente.

**Resultado de referencia:**

```text
Nombre: Ana
Edad: 21
Altura: 1.68 m
Matriculada: true
Mayor de edad: true
Edad como Integer: 21
Edad como int: 21
```

**Reflexiona:** ¿por qué `Integer.valueOf()` devuelve un objeto aunque `convertirEdad` tenga retorno `int`? ¿Qué diferencia presenta respecto a `Integer.parseInt()`?

---

## 5. Ejercicio 2 — Analizador de contraseñas

**Dificultad:** intermedia · **Clase:** `AnalizadorContrasena`

### Situación inicial

Una aplicación debe analizar una contraseña introducida por teclado y comprobar si es válida. Para ello, debe tener **al menos 8 caracteres, una mayúscula, una minúscula y un dígito**. Los símbolos se contabilizan, pero no son obligatorios. Practicarás funciones que **transforman una cadena en contadores o resultados lógicos**, utilizando los métodos de `Character`.

### Funciones que debes desarrollar

#### 1. `contarMayusculas`

Esta función recibirá una contraseña completa y la recorrerá carácter por carácter. Por cada carácter, utilizará **`Character.isUpperCase()`** para decidir si se trata de una letra mayúscula y aumentar un contador cuando corresponda.

- **Recibe:** la contraseña como `String`.
- **Devuelve:** un `int` con el total de mayúsculas.
- **Ejemplo:** con `"Java2026!"`, devuelve `1`.
- **Debes documentar:** qué caracteres cuenta y cómo se interpreta el resultado.

#### 2. `contarMinusculas`

Trabaja de manera similar a la anterior, pero identifica letras minúsculas mediante **`Character.isLowerCase()`**. Debe analizar toda la contraseña y devolver el total, sin imprimir mensajes.

- **Recibe:** un `String`.
- **Devuelve:** un `int`.
- **Ejemplo:** para `"Java2026!"`, devuelve `3`.
- **Debes documentar:** qué se entiende por minúscula y qué valor retorna.

#### 3. `contarDigitos`

Esta función transformará una contraseña en el número de caracteres numéricos que contiene. Utiliza **`Character.isDigit()`** para reconocerlos; no confundas el número de dígitos con el valor numérico de la contraseña.

- **Recibe:** un `String`.
- **Devuelve:** un `int`.
- **Ejemplo:** para `"Java2026!"`, devuelve `4`.
- **Debes documentar:** que cuenta caracteres, sin realizar conversiones a enteros.

#### 4. `contarSimbolos`

Esta función contará los caracteres que **no son letras ni dígitos**. Utiliza **`Character.isLetterOrDigit()`** para comprobar cada carácter y contabiliza los que no cumplan esa condición. En esta actividad, los espacios también se considerarían caracteres no alfanuméricos.

- **Recibe:** la contraseña como `String`.
- **Devuelve:** el número de caracteres no alfanuméricos como `int`.
- **Ejemplo:** `"Java2026!"` contiene `1` símbolo.
- **Debes documentar:** el criterio empleado y el tratamiento de los espacios.

#### 5. `tieneLongitudMinima`

Esta función comprobará únicamente el requisito de longitud. Transformará una cadena de caracteres en un resultado lógico, comparando su longitud con el mínimo establecido de **8 caracteres**.

- **Recibe:** un `String`.
- **Devuelve:** `boolean`.
- **Ejemplos:** `"Ja12"` devuelve `false`; `"Java2026!"` devuelve `true`.
- **Debes documentar:** la longitud mínima requerida.

#### 6. `esContrasenaValida`

Esta función se encargará de **combinar los resultados de las funciones anteriores**. No debe repetir los bucles para contar caracteres: debe reutilizar las funciones de longitud, mayúsculas, minúsculas y dígitos y decidir si se cumplen todos los requisitos.

- **Recibe:** un `String` con la contraseña.
- **Devuelve:** `boolean`.
- **Ejemplo:** `"Java2026!"` devuelve `true`; `"java2026!"` devuelve `false` porque no tiene mayúsculas.
- **Debes documentar:** las cuatro condiciones que se exigen.

#### 7. `generarInforme`

Esta función construirá un informe de texto con la longitud, los cuatro contadores y el resultado de la validación. Reutiliza los resultados de las funciones ya creadas. **No debe solicitar la contraseña ni mostrar directamente el informe**.

- **Recibe:** la contraseña como `String`.
- **Devuelve:** un `String` con el informe.
- **Ejemplo:** incluye líneas como `Dígitos: 4` y `Resultado: contraseña válida`.
- **Debes documentar:** el contenido del informe devuelto.

### Integración y pruebas

En el método principal, solicita la contraseña con `Scanner`, llama a `generarInforme` y muestra el texto devuelto. Prueba `"Java2026!"` (válida), `"java2026!"` (sin mayúsculas), `"JAVA2026!"` (sin minúsculas), `"Javaaaaa"` (sin dígitos) y `"Ja12"` (demasiado corta).

**Resultado de referencia:**

```text
Introduce una contraseña: Java2026!
Longitud: 9
Mayúsculas: 1
Minúsculas: 3
Dígitos: 4
Símbolos: 1
Resultado: contraseña válida
```

**Ampliación opcional:** desarrolla una función `contieneSimbolos` que reutilice `contarSimbolos` y modifique la validación para exigir al menos un símbolo.

**Reflexiona:** ¿qué ventajas tiene reutilizar los contadores dentro de `esContrasenaValida` en lugar de repetir el mismo análisis?

---

## 6. Ejercicio 3 — Gestor de calificaciones

**Dificultad:** avanzada · **Clase:** `GestorCalificaciones`

### Situación inicial

El programa recogerá notas entre **0 y 10**, incluidos ambos extremos, y calculará estadísticas. Las calificaciones se guardarán en un **`ArrayList<Double>`**. En este ejercicio combinarás **funciones de conversión, validación, entrada, análisis y presentación**, además de controlar errores al transformar texto en números.

### Funciones que debes desarrollar

#### 1. `convertirNumeroNotas`

Esta función transformará la cantidad de calificaciones, que inicialmente se ha leído como `String`, en un entero primitivo. Utiliza **`Integer.parseInt()`** para practicar una alternativa a `valueOf()`.

- **Recibe:** un `String` con la cantidad solicitada.
- **Devuelve:** un `int`.
- **Ejemplo:** `"5"` se convierte en `5`.
- **Debes documentar:** qué ocurre cuando el texto no es un entero; el control de ese error puede realizarse en la función que solicita el dato.

#### 2. `convertirNota`

Esta función transformará el texto de una calificación en un número decimal primitivo. Utiliza **`Double.parseDouble()`**; a diferencia de `Double.valueOf()`, el resultado será un `double`.

- **Recibe:** una calificación como `String`, por ejemplo `"7.5"`.
- **Devuelve:** un `double`.
- **Ejemplo:** `"7.5"` se convierte en `7.5`.
- **Debes documentar:** el formato decimal esperado y la posibilidad de un error de conversión.

#### 3. `esNotaValida`

Esta función recibe una nota ya convertida a número y decide si se encuentra en el intervalo permitido, **de 0 a 10**. También debe rechazar valores especiales como **`NaN`** o **`Infinity`**, aunque Java pueda interpretarlos como números de tipo `double`.

- **Recibe:** un `double`.
- **Devuelve:** `boolean`.
- **Ejemplos:** `0`, `5.5` y `10` son válidos; `-1`, `11` y `NaN` no lo son.
- **Debes documentar:** los límites y la exclusión de valores no finitos.

#### 4. `solicitarNotaValida`

Esta función se encargará del diálogo con el usuario para obtener **una sola nota válida**. Leerá el dato como texto, llamará a `convertirNota` y después a `esNotaValida`. Si se escribe algo que no puede convertirse en número, utilizará **`try-catch`** para gestionar `NumberFormatException`. Si la nota queda fuera del rango, volverá a solicitarla.

- **Recibe:** la información necesaria para leer desde teclado, por ejemplo un `Scanner`, y opcionalmente el número de nota que se está solicitando.
- **Devuelve:** un `double` ya validado.
- **Ejemplo:** si el usuario introduce `"hola"`, después `"11"` y finalmente `"7.5"`, la función pedirá de nuevo el dato hasta devolver `7.5`.
- **Debes documentar:** que la función no finaliza hasta obtener una nota correcta y cómo trata las entradas inválidas.

#### 5. `recogerNotas`

Esta función repetirá la petición de notas tantas veces como indique la cantidad recibida, llamando a `solicitarNotaValida` en cada iteración. Guardará las notas en un **`ArrayList<Double>`**. Observa que las funciones anteriores trabajan con `double`, pero la colección almacena objetos `Double`: Java realiza **autoboxing** al añadir cada nota.

- **Recibe:** la cantidad de notas `int` y el recurso necesario para leerlas, como un `Scanner`.
- **Devuelve:** un `ArrayList<Double>` con todas las notas válidas.
- **Ejemplo:** si se piden 3 notas y se introducen `7`, `4.5` y `9`, devuelve una lista que contiene esos tres valores.
- **Debes documentar:** cómo se construye la lista y qué sucede si la cantidad es cero.

#### 6. `calcularMedia`

Esta función calculará el promedio aritmético de las notas existentes en la lista. Debe recorrer los valores, sumarlos y dividir la suma entre el número de elementos. Al recuperar cada elemento `Double` y tratarlo como un primitivo `double`, interviene el **unboxing**.

- **Recibe:** un `ArrayList<Double>`.
- **Devuelve:** la media como `double`.
- **Ejemplo:** con `[7.0, 4.0, 10.0]`, devuelve `7.0`.
- **Debes documentar:** qué ocurrirá si la lista está vacía; establece una regla coherente y evita dividir entre cero.

#### 7. `obtenerMaxima`

Esta función encontrará la nota más alta de la lista. Debe comparar elementos **`Double` utilizando `compareTo()`**, para practicar la comparación de objetos envolventes. Evita asumir que la nota máxima será necesariamente `10`.

- **Recibe:** un `ArrayList<Double>` con notas.
- **Devuelve:** un `Double` con la nota máxima.
- **Ejemplo:** `[7.5, 4.0, 9.0]` produce `9.0`.
- **Debes documentar:** el requisito de lista no vacía o el comportamiento acordado cuando no existen notas.

#### 8. `obtenerMinima`

Esta función realizará la operación complementaria a `obtenerMaxima`: identificará la menor calificación comparando objetos `Double` mediante **`compareTo()`**.

- **Recibe:** un `ArrayList<Double>`.
- **Devuelve:** un `Double` con la menor nota.
- **Ejemplo:** `[7.5, 4.0, 9.0]` produce `4.0`.
- **Debes documentar:** cómo se comporta ante listas vacías.

#### 9. `contarAprobados`

Esta función transformará una lista de calificaciones en un contador entero. Recorrerá las notas e identificará las que sean **mayores o iguales que 5**.

- **Recibe:** un `ArrayList<Double>`.
- **Devuelve:** un `int` con la cantidad de aprobados.
- **Ejemplo:** `[4.0, 5.0, 7.0]` produce `2`.
- **Debes documentar:** el umbral de aprobado, incluyendo el valor límite `5`.

#### 10. `contarSuspensos`

Esta función contará las notas **menores que 5**. Mantén esta responsabilidad separada de la función de aprobados para practicar reutilización y claridad del diseño.

- **Recibe:** un `ArrayList<Double>`.
- **Devuelve:** un `int` con el número de suspensos.
- **Ejemplo:** `[4.0, 5.0, 7.0]` produce `1`.
- **Debes documentar:** cuándo una nota se considera suspensa.

#### 11. `generarEstadisticas`

Esta función transformará una lista de calificaciones en un **informe de texto**. Debe llamar a las funciones de media, máximos, mínimos y contadores, reutilizando sus resultados en lugar de repetir los cálculos. No debe solicitar notas al usuario.

- **Recibe:** un `ArrayList<Double>`.
- **Devuelve:** un `String` con todas las estadísticas.
- **Ejemplo:** el informe debe mostrar las notas introducidas, la media, la nota máxima, la mínima, los aprobados y los suspensos.
- **Debes documentar:** qué estadísticas produce y cómo se representa una lista vacía.

### Integración y pruebas

En el método principal, solicita primero **cuántas notas se quieren introducir**; controla entradas que no sean enteros y cantidades negativas. Después usa `recogerNotas` y finalmente muestra el resultado de `generarEstadisticas`. El método principal debe coordinar el proceso y **no sustituir las funciones anteriores**.

**Resultado de referencia:**

```text
¿Cuántas notas deseas introducir? 5
Nota 1: 7.5
Nota 2: 4
Nota 3: hola
Error: introduce una nota numérica.
Nota 3: 9
Nota 4: 6.5
Nota 5: 3

--- ESTADÍSTICAS ---
Notas: [7.5, 4.0, 9.0, 6.5, 3.0]
Media: 6.0
Máxima: 9.0
Mínima: 3.0
Aprobados: 3
Suspensos: 2
```

**Casos de prueba obligatorios:** notas `0` y `10` (válidas), `-1` y `11` (rechazadas), texto `"hola"` (volver a pedir), `"NaN"` e `"Infinity"` (rechazadas), cero notas (sin errores) y cantidad de notas negativa (no permitida).

**Ampliación opcional:** crea `filtrarNotasDisponibles`, que recibe una lista con posibles valores `null` y devuelve otra sin ellos, antes de calcular estadísticas. Evita el unboxing de `null`.

**Reflexiona:** ¿por qué conviene separar conversión, validación, lectura, cálculo y presentación? ¿Qué funciones podrías probar sin usar `Scanner`?

---

## 7. Documentación obligatoria con Javadoc

Antes de dar por finalizada la tarea, verifica lo siguiente:

- [ ] Cada una de las **tres clases** comienza con una descripción Javadoc de su propósito.
- [ ] Cada **función creada**, incluyendo las auxiliares y el método principal, está documentada con Javadoc.
- [ ] Cada parámetro dispone de su correspondiente etiqueta `@param`.
- [ ] Cada función que devuelve información incluye `@return`.
- [ ] Las excepciones que forman parte del contrato de una función se documentan con `@throws` cuando corresponda.
- [ ] Los nombres de funciones y variables reflejan claramente su cometido.
- [ ] La documentación describe **qué hace** cada función, qué recibe y qué devuelve; no sustituye una buena estructura del código.

**Comprobación en IntelliJ:** sitúate sobre una función y utiliza la ayuda de documentación rápida (**Quick Documentation**, habitualmente `Ctrl+Q` en Windows/Linux). Revisa si se muestra correctamente su descripción. Los atajos pueden cambiar según el sistema y la configuración.

## 8. Verificación final del proyecto Maven

1. Comprueba en IntelliJ el **Project SDK (21 o 27)**.
2. Comprueba el nivel de compilación elegido en `pom.xml`: **21 o 27**, coherente con el JDK.
3. Ejecuta `mvn -version` y deja constancia de la versión de Java con la que Maven se ejecuta.
4. Ejecuta `mvn clean compile` y verifica que aparece **BUILD SUCCESS**.
5. Ejecuta las tres clases por separado desde IntelliJ y repite sus casos de prueba.
6. Si has creado pruebas automatizadas, ejecútalas mediante `mvn test`.
7. Comprueba que no has entregado clases sin documentación Javadoc ni funciones excesivamente largas.

## 9. Publicación y entrega mediante GitHub (como en la Tarea 3)

**No entregues archivos ZIP ni un repositorio nuevo.** Toda la práctica se guarda dentro del repositorio **público `dam-pro`**, en la carpeta **`unidad-02/tarea-4/`**. Trabaja en la rama `main` y realiza **commits progresivos** durante el desarrollo, no todos al final.

### 9.1. Primer commit: proyecto Maven y enunciado

Desde la **raíz de `dam-pro`**, después de crear el proyecto y colocar este enunciado como `unidad-02/tarea-4/README.md`:

```bash
git status
git add unidad-02/README.md
git add unidad-02/tarea-4/README.md
git add unidad-02/tarea-4/pom.xml
git diff --cached
git commit -m "build: preparar tarea 4 unidad 02"
git push origin main
```

Comprueba en GitHub que aparece la carpeta `tarea-4`, el `pom.xml`, su `README.md` y el enlace desde el índice de la unidad. **No ejecutes `git init` ni crees un segundo repositorio.** Si no hay cambios, no hagas commits vacíos.

### 9.2. Commits al completar los ejercicios

Tras implementar y probar **cada ejercicio**, realiza un commit de avance. Desde la raíz de `dam-pro`:

| Momento | Mensaje recomendado de commit |
|---|---|
| Finalización del ejercicio 1 | `feat: implementar conversiones de datos personales` |
| Finalización del ejercicio 2 | `feat: analizar contrasenas con Character` |
| Finalización del ejercicio 3 | `feat: gestionar calificaciones y errores` |

Para cada fase, usa estos comandos sustituyendo `MENSAJE` por el mensaje correspondiente:

```bash
git status
git add unidad-02/tarea-4/src/
git diff --cached
git commit -m "MENSAJE"
git push origin main
```

Si modificaste `pom.xml`, añade también `git add unidad-02/tarea-4/pom.xml`. Comprueba los resultados antes de publicar y verifica los commits en GitHub.

### 9.3. Documentar pruebas y terminar el índice

Al **final** del archivo `unidad-02/tarea-4/README.md`, añade una sección titulada **`## Desarrollo y pruebas del alumno`**. **No elimines el enunciado del profesor.** En esa sección explica con tus palabras:

- Qué versión de Java has elegido (21 o 27), resultados de `java -version`, `javac -version`, `mvn -version` y cómo has configurado Maven.
- Cómo has organizado las funciones de los tres ejercicios y qué clases envolventes empleaste.
- Cómo ejecutar cada clase y qué casos de prueba has realizado, indicando entradas y resultados.
- Al menos una dificultad encontrada y cómo la resolviste.

Cuando los tres ejercicios funcionen, estén documentados con Javadoc y hayas comprobado `mvn clean compile`, cambia **únicamente** la entrada de la Tarea 4 en `unidad-02/README.md` a:

```markdown
| [Tarea 4](tarea-4/) | Clases envolventes y funciones | Completada |
```

Publica el resultado:

```bash
git status
git add unidad-02/tarea-4/README.md unidad-02/README.md
git add unidad-02/tarea-4/src/ unidad-02/tarea-4/pom.xml
git diff --cached
git commit -m "docs: finalizar tarea 4 y actualizar indice"
git push origin main
git status
git log --oneline -6
```

Mantén `.gitignore` con reglas que excluyan `**/target/`, `*.class`, `.idea/` y `*.iml`, conservando las reglas anteriores. Si tienes que actualizarlo, inclúyelo en el commit con `git add .gitignore`. **No subas `target/` ni archivos de configuración locales innecesarios.**

### 9.4. Si termina la clase: guardar avances para continuar en casa

**Antes de salir del aula, sube a GitHub todo el trabajo realizado aunque todavía no compile**. Si la práctica sigue incompleta, conserva el estado **En desarrollo** en el índice.

```bash
git status
git add unidad-02/README.md unidad-02/tarea-4/
git diff --cached
git commit -m "wip: guardar avance tarea 4 para continuar en casa"
git push origin main
git status
```

El mensaje `wip` indica trabajo en curso; úsalo solo cuando existan modificaciones reales. En casa, abre el mismo repositorio, ejecuta `git status`, `git fetch origin` y `git pull --ff-only origin main` antes de seguir; al terminar, publica los cambios con otro commit. **Un archivo que solo está en tu ordenador no se considera entregado.**

### 9.5. Entrega en Moodle: URL pública de la carpeta

Copia desde GitHub el **enlace directo a la carpeta de esta tarea** y pégalo como entrega en Moodle:

```text
https://github.com/TU_USUARIO/dam-pro/tree/main/unidad-02/tarea-4
```

Sustituye `TU_USUARIO` por tu nombre de usuario real. Abre el enlace en una ventana privada o sin iniciar sesión para comprobar que el repositorio es público y que se ven `README.md`, `pom.xml`, `src/` y los últimos commits.

**El profesor comprobará:** estructura Maven, paquete `ies.puerto.es`, Java 21 o 27, los tres ejercicios, Javadoc de clases y funciones, pruebas documentadas, índice de la unidad actualizado y **historial de commits progresivos**.

## 10. Rúbrica de evaluación (10 puntos)

| Criterio | Puntuación |
|---|---:|
| Proyecto Maven bien creado y configurado con JDK 21 o 27 | 1 punto |
| Ejercicio 1: conversiones, autoboxing y unboxing | 1,5 puntos |
| Ejercicio 2: análisis con `Character` y validación | 1,5 puntos |
| Ejercicio 3: lista, estadísticas y tratamiento de errores | 2 puntos |
| Diseño de funciones: parámetros, retornos, reutilización y separación de responsabilidades | 1,5 puntos |
| Documentación Javadoc completa y correcta en clases y funciones | 1,5 puntos |
| Pruebas, README, índice y commits progresivos en GitHub | 1 punto |
| **Total** | **10 puntos** |

## 11. Autocomprobación del alumnado

- [ ] He creado `tarea-4` como **Maven** y existe `pom.xml`.
- [ ] He comprobado **Java 21 o 27** en terminal, IntelliJ y Maven.
- [ ] Las tres clases declaran el paquete `ies.puerto.es` y están en `src/main/java/ies/puerto/es/`.
- [ ] Cada ejercicio se resuelve mediante **varias funciones**, no únicamente en el método principal.
- [ ] Las funciones que transforman datos reciben parámetros y devuelven resultados adecuados.
- [ ] Todas las clases y funciones incluyen **Javadoc**.
- [ ] He probado los casos normales, límites y errores indicados.
- [ ] `mvn clean compile` finaliza correctamente.
- [ ] He guardado todo en `dam-pro/unidad-02/tarea-4/`, sin crear un repositorio adicional.
- [ ] He conservado el enunciado en `README.md` y añadido **Desarrollo y pruebas del alumno**.
- [ ] He realizado commits progresivos y actualizado el índice de `unidad-02/`.
- [ ] He publicado los cambios en GitHub y pegado en Moodle el **enlace directo a la carpeta** de la Tarea 4.
