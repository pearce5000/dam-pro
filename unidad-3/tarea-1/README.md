# Práctica guiada: arrays en Java 21 (20 ejercicios)

> **Guía para el alumnado.** Este documento explica los conceptos y el enfoque de cada ejercicio **sin mostrar soluciones ni pseudocódigo completo**. El código Java del proyecto contiene firmas y contratos, y las pruebas JUnit indican el comportamiento exigido.

## Objetivos de aprendizaje

Practicar la declaración y el recorrido de arrays, búsquedas, cálculos agregados, transformaciones, algoritmos con dos índices, matrices y documentación profesional con Javadoc. La dificultad avanza de operaciones básicas a problemas con estructuras bidimensionales.

## Requisitos e inicio

- **Java 21** (JDK 21), Maven 3.9+ y **Python 3** para calcular la calificación.
- IDE recomendado: IntelliJ IDEA, Eclipse o Visual Studio Code con soporte Java.
- Los archivos `src/main/java/es/educacion/arrays/Ejercicio*.java` contienen los métodos que debes implementar; no modifiques las firmas ni los nombres de las clases.
- Los archivos `src/test/java/es/educacion/arrays/*Test.java` contienen las pruebas oficiales. **No se deben modificar** para evaluar el trabajo.
- **Excepción:** en el ejercicio 15 los métodos ya funcionan; debes añadir el Javadoc que falta.

## Bases teóricas antes de comenzar

### 1. ¿Qué es un array?

Un array es una secuencia de elementos del **mismo tipo** cuyo tamaño se fija al crearlo. Un `int[]` almacena enteros; un `int[][]` almacena arrays de enteros (filas). Las posiciones se numeran desde **0** hasta `length - 1`. Acceder a un índice fuera de rango provoca `ArrayIndexOutOfBoundsException`.

### 2. Formas de recorrerlo

- **`for` tradicional:** aporta un índice; es necesario cuando importa la posición, se comparan elementos vecinos o se construyen resultados por índice.
- **`for-each`:** ofrece directamente el valor de cada elemento; facilita sumar, contar y comprobar condiciones sin gestionar índices.
- **`while`:** resulta útil cuando dos índices avanzan a velocidades diferentes, por ejemplo, al fusionar arrays ordenados.

### 3. Operaciones frecuentes y bibliotecas

| Concepto o función | Para qué sirve | Precaución |
|---|---|---|
| `array.length` | Conocer el número de elementos | Es un atributo, no un método |
| `Arrays.toString(array)` | Representar un array en texto | No sirve para matrices anidadas |
| `Arrays.deepToString(matriz)` | Representar arrays anidados | Pensado para mostrar, no para comparar |
| `Arrays.sort(array)` | Ordenar números de menor a mayor | **Modifica** el array recibido |
| `Arrays.copyOf(array, n)` | Copiar con longitud deseada | Puede rellenar con valores predeterminados |
| `Arrays.copyOfRange(array, inicio, fin)` | Copiar posiciones desde inicio incluido hasta fin excluido | Revisar límites y contrato del ejercicio |
| `Arrays.equals(a, b)` | Comparar contenidos de arrays unidimensionales | `a == b` compara referencias |
| `Arrays.deepEquals(a, b)` | Comparar contenido de matrices | Útil en tests de resultados 2D |
| `Arrays.binarySearch(array, valor)` | Buscar sobre array ordenado | Requiere orden compatible y devuelve resultado negativo si no encuentra |
| `Arrays.fill(array, valor)` | Rellenar posiciones | Modifica la entrada |
| `Math.max(a, b)` | Elegir el mayor valor | Puede ayudar en problemas de máximos parciales |

### 4. Arrays, memoria y validaciones

Un array es un objeto; si se pasa como argumento a un método, ambos pueden referirse a los mismos datos. Por eso es importante distinguir entre **transformar el original** y **devolver una copia**. Un array `null` es diferente de uno vacío. Debes respetar el contrato de cada método y comprobar los casos extremos antes de realizar operaciones que requieren al menos un elemento.

### 5. Matrices (`int[][]`)

Java representa una matriz mediante un array cuyos elementos son otros arrays. Una matriz puede ser rectangular, irregular o contener filas vacías; no siempre puedes utilizar la longitud de la primera fila para todas las demás. En las operaciones que exigen forma rectangular o cuadrada debes validarla expresamente.

### 6. Javadoc y documentación de API

La documentación de una clase debe expresar su **responsabilidad** y la de un método debe explicar qué hace, qué recibe, qué devuelve y, cuando corresponda, qué excepciones puede producir. Se evalúa la existencia de una descripción útil, etiquetas `@param` para los argumentos y `@return` en métodos que devuelven un valor. La documentación debe describir el contrato real, no repetir únicamente el nombre del método.

## Plan de ejercicios y batería de tests

**20 ejercicios × 5 tests por ejercicio = 100 tests JUnit 5**, incluyendo cinco tests dedicados a la documentación del ejercicio 15.

| Nº | Tema | Nivel | Tests |
|---:|---|---|---:|
| 1 | Sumar elementos | Básico | 5 |
| 2 | Calcular la media | Básico | 5 |
| 3 | Encontrar el máximo | Básico | 5 |
| 4 | Contar aprobados | Básico | 5 |
| 5 | Buscar un elemento | Básico | 5 |
| 6 | Invertir un array | Intermedio | 5 |
| 7 | Ordenar elementos | Intermedio | 5 |
| 8 | Copiar un rango | Intermedio | 5 |
| 9 | Eliminar duplicados | Intermedio | 5 |
| 10 | Fusionar ordenados | Intermedio | 5 |
| 11 | Contar pares | Básico | 5 |
| 12 | Rotar a la derecha | Intermedio | 5 |
| 13 | Frecuencia de un número | Básico | 5 |
| 14 | Intersección sin repetidos | Avanzado | 5 |
| 15 | Documentar clases y métodos | Documentación | 5 |
| 16 | Sumar filas de una matriz | Avanzado | 5 |
| 17 | Sumar diagonal principal | Avanzado | 5 |
| 18 | Transponer una matriz | Avanzado | 5 |
| 19 | Frecuencia en una matriz | Avanzado | 5 |
| 20 | Mayor racha creciente | Avanzado | 5 |
| **Total** | | | **100** |

## Enunciados y guías de resolución

### Ejercicio 01 · Sumar elementos

**Objetivo.** Sumar todos los números de un array.

**Cómo razonar la resolución.** Una variable acumuladora comienza con el elemento neutro de la suma. Se recorre el array una sola vez y se incorpora cada elemento. Un array vacío tiene suma cero.

**Conceptos y funciones recomendadas.** length, for o for-each, operador +.

**Condiciones del contrato.** Array nulo: IllegalArgumentException. Array vacío: 0.

**5 pruebas automáticas.** Se comprueban valores positivos, negativos, ceros, vacío y nulo.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio01Sumar.java`.

### Ejercicio 02 · Calcular la media

**Objetivo.** Calcular la media aritmética de todas las notas.

**Cómo razonar la resolución.** Reutiliza la idea del acumulador, pero divide entre el número de elementos utilizando división decimal. Una colección sin elementos no tiene media y debe tratarse explícitamente.

**Conceptos y funciones recomendadas.** length, for-each, conversión a double.

**Condiciones del contrato.** Array vacío o nulo: IllegalArgumentException.

**5 pruebas automáticas.** Se comprueban enteros, decimales en el resultado, negativos, cero y entradas inválidas.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio02Media.java`.

### Ejercicio 03 · Encontrar el máximo

**Objetivo.** Obtener el valor más alto de un array.

**Cómo razonar la resolución.** Parte de un valor existente, no de cero, porque todos los números podrían ser negativos. Compara cada elemento con el máximo provisional y conserva el más alto.

**Conceptos y funciones recomendadas.** length, acceso por índice, if, for-each.

**Condiciones del contrato.** Array vacío o nulo: IllegalArgumentException.

**5 pruebas automáticas.** Se comprueban un elemento, negativos, repetidos, orden ascendente y vacío.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio03Maximo.java`.

### Ejercicio 04 · Contar aprobados

**Objetivo.** Contar notas iguales o superiores a cinco.

**Cómo razonar la resolución.** Establece una condición de aprobado y suma una unidad únicamente cuando la nota cumple la condición. Comprueba el valor justo en el límite.

**Conceptos y funciones recomendadas.** for-each, if, comparador >=.

**Condiciones del contrato.** Array nulo: IllegalArgumentException; vacío: 0.

**5 pruebas automáticas.** Se comprueban todos aprobados, ninguno, límite 5, vacío y nulo.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio04ContarAprobados.java`.

### Ejercicio 05 · Buscar un elemento

**Objetivo.** Localizar la primera posición en que aparece un valor.

**Cómo razonar la resolución.** Recorre de izquierda a derecha y devuelve el índice al detectar la primera coincidencia. Si no aparece, utiliza el indicador acordado en el contrato de la clase.

**Conceptos y funciones recomendadas.** for con índice, ==, return, length.

**Condiciones del contrato.** Array nulo: IllegalArgumentException; ausente: -1.

**5 pruebas automáticas.** Se comprueban primer índice, último, repetidos, ausente y nulo.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio05Buscar.java`.

### Ejercicio 06 · Invertir un array

**Objetivo.** Obtener la secuencia en orden inverso.

**Cómo razonar la resolución.** Relaciona la primera posición con la última, la segunda con la penúltima, etc. Para preservar el array original crea otro array y asigna cada valor en su posición simétrica.

**Conceptos y funciones recomendadas.** new int[], length, bucle for, acceso por índice.

**Condiciones del contrato.** Array nulo: IllegalArgumentException; vacío: vacío.

**5 pruebas automáticas.** Se comprueban impares, pares, un elemento, vacío y conservación del original.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio06Invertir.java`.

### Ejercicio 07 · Ordenar elementos

**Objetivo.** Ordenar los números de menor a mayor.

**Cómo razonar la resolución.** La biblioteca estándar proporciona un algoritmo de ordenación. Decide, según el contrato, si se debe copiar la entrada antes de ordenarla y verifica qué ocurre con los duplicados.

**Conceptos y funciones recomendadas.** Arrays.sort, Arrays.copyOf, Arrays.toString.

**Condiciones del contrato.** Consultar el contrato en la clase; comprobar si modifica el original.

**5 pruebas automáticas.** Se comprueban desordenados, ya ordenados, duplicados, negativos y vacío.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio07Ordenar.java`.

### Ejercicio 08 · Copiar un rango

**Objetivo.** Extraer un intervalo de posiciones.

**Cómo razonar la resolución.** Interpreta el inicio como inclusivo y el final como exclusivo. Valida las fronteras antes de copiar y piensa en el caso de un intervalo de longitud cero.

**Conceptos y funciones recomendadas.** Arrays.copyOfRange, length, comparadores.

**Condiciones del contrato.** 0 ≤ inicio ≤ fin ≤ longitud; intervalo inválido o nulo: IllegalArgumentException.

**5 pruebas automáticas.** Se comprueban intervalo intermedio, completo, vacío y dos índices inválidos.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio08CopiarRango.java`.

### Ejercicio 09 · Eliminar duplicados

**Objetivo.** Conservar una sola aparición de cada valor.

**Cómo razonar la resolución.** Mantén el orden de la primera aparición. Antes de incorporar cada número al resultado comprueba si ya se había procesado. Como el tamaño final se desconoce, considera una estructura temporal o dos pasadas.

**Conceptos y funciones recomendadas.** bucles anidados, Arrays.copyOf, búsqueda lineal.

**Condiciones del contrato.** Se preserva la primera aparición; consultar contrato para nulos.

**5 pruebas automáticas.** Se comprueban repetidos seguidos, dispersos, valores negativos, vacío y nulo.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio09EliminarDuplicados.java`.

### Ejercicio 10 · Fusionar ordenados

**Objetivo.** Combinar dos arrays ya ordenados en un tercero ordenado.

**Cómo razonar la resolución.** Trabaja con dos índices, uno por entrada. En cada paso escoge el menor elemento pendiente y avanza su índice. Cuando una entrada se acaba, incorpora el resto de la otra.

**Conceptos y funciones recomendadas.** length, new int[], índices, while.

**Condiciones del contrato.** Entradas ordenadas de menor a mayor; consultar contrato para nulos.

**5 pruebas automáticas.** Se comprueban ambos con datos, una vacía, negativos, repetidos y nulos.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio10FusionarOrdenados.java`.

### Ejercicio 11 · Contar pares

**Objetivo.** Contar todos los valores divisibles entre dos.

**Cómo razonar la resolución.** Usa el resto de la división. Recuerda que cero y los enteros pares negativos también cumplen la condición; no interpretes par como positivo.

**Conceptos y funciones recomendadas.** operador %, for-each, if.

**Condiciones del contrato.** Nulo: IllegalArgumentException; vacío: 0.

**5 pruebas automáticas.** Se comprueban mezcla, ninguno, todos, vacío y nulo.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio11ContarPares.java`.

### Ejercicio 12 · Rotar a la derecha

**Objetivo.** Rotar los elementos un número no negativo de posiciones.

**Cómo razonar la resolución.** Una rotación mueve los elementos que salen por la derecha al inicio. Si los desplazamientos superan la longitud, usa el resto para evitar vueltas innecesarias. Crea una copia sin alterar la entrada.

**Conceptos y funciones recomendadas.** operador %, length, new int[], for.

**Condiciones del contrato.** Desplazamiento negativo o array nulo: IllegalArgumentException.

**5 pruebas automáticas.** Se comprueban una posición, más de una vuelta, cero, vacío y negativo.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio12RotarDerecha.java`.

### Ejercicio 13 · Frecuencia de un número

**Objetivo.** Contar las apariciones exactas de un valor objetivo.

**Cómo razonar la resolución.** Recorre todos los elementos y lleva un contador de coincidencias. No es suficiente encontrar la primera aparición; los repetidos también cuentan.

**Conceptos y funciones recomendadas.** for-each, ==, contador.

**Condiciones del contrato.** Nulo: IllegalArgumentException; vacío: 0.

**5 pruebas automáticas.** Se comprueban repeticiones, ausente, negativos, vacío y nulo.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio13Frecuencia.java`.

### Ejercicio 14 · Intersección sin repetidos

**Objetivo.** Extraer valores que aparecen en dos arrays sin duplicados.

**Cómo razonar la resolución.** Sigue el orden de la primera entrada, busca si cada candidato figura en la segunda y evita añadirlo si ya se incorporó. No es necesario ordenar ninguno de los arrays.

**Conceptos y funciones recomendadas.** bucles, comparación ==, Arrays.copyOf, estructuras temporales.

**Condiciones del contrato.** Nulos: IllegalArgumentException; no modificar entradas.

**5 pruebas automáticas.** Se comprueban repetidos, sin comunes, vacíos, negativos y nulos.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio14Interseccion.java`.

### Ejercicio 15 · Documentar clases y métodos

**Objetivo.** Completar correctamente el Javadoc de una clase y sus dos métodos públicos.

**Cómo razonar la resolución.** Lee las firmas y los contratos de los métodos. Redacta una explicación útil de la clase, una descripción para cada método, una etiqueta por parámetro y una explicación del valor devuelto. Los métodos ya funcionan: el trabajo se centra en documentarlos, no en reescribir la lógica.

**Conceptos y funciones recomendadas.** Javadoc /** … */, @param, @return, herramienta javadoc.

**Condiciones del contrato.** Se requieren descripciones significativas y etiquetas correctas para cada método.

**5 pruebas automáticas.** Se comprueban 5 tests de presencia y calidad mínima de Javadoc: clase, descripciones y etiquetas.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio15Documentar.java`.

### Ejercicio 16 · Sumar filas de una matriz

**Objetivo.** Devolver un array con la suma de cada fila de una matriz.

**Cómo razonar la resolución.** Recuerda que una matriz Java es un array de arrays, de modo que las filas pueden tener tamaños distintos. Recorre las filas y acumula sus elementos de manera independiente.

**Conceptos y funciones recomendadas.** int[][], length, bucles anidados, for-each.

**Condiciones del contrato.** Matriz o fila nula: IllegalArgumentException; filas vacías: suma 0.

**5 pruebas automáticas.** Se comprueban rectangular/irregular, filas vacías, matriz vacía, negativos y fila nula.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio16SumaFilas.java`.

### Ejercicio 17 · Sumar diagonal principal

**Objetivo.** Sumar elementos situados en la diagonal principal de una matriz cuadrada.

**Cómo razonar la resolución.** La diagonal principal reúne posiciones con el mismo índice de fila y columna. Antes de recorrerla comprueba que la matriz sea cuadrada y que ninguna fila sea nula.

**Conceptos y funciones recomendadas.** int[][], length, acceso [i][i], for.

**Condiciones del contrato.** Matriz no cuadrada o nula: IllegalArgumentException; 0x0: suma 0.

**5 pruebas automáticas.** Se comprueban 3x3, 1x1, matriz vacía, rectangular y fila nula.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio17Diagonal.java`.

### Ejercicio 18 · Transponer una matriz

**Objetivo.** Intercambiar filas por columnas.

**Cómo razonar la resolución.** Una matriz de m filas por n columnas se convierte en otra de n filas por m columnas. Verifica que todas las filas tengan el mismo tamaño y copia elementos a posiciones intercambiadas.

**Conceptos y funciones recomendadas.** int[][], new int[][], bucles anidados, length.

**Condiciones del contrato.** Matriz irregular o nula: IllegalArgumentException; 0x0: 0x0.

**5 pruebas automáticas.** Se comprueban 2x3, cuadrada, vacía, irregular y nula.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio18Transponer.java`.

### Ejercicio 19 · Frecuencia en una matriz

**Objetivo.** Contar un valor en todas las filas de una matriz.

**Cómo razonar la resolución.** Aplica la búsqueda exhaustiva, primero recorriendo filas y luego sus elementos. No presupongas que las filas tienen igual longitud.

**Conceptos y funciones recomendadas.** int[][], for-each anidados, ==.

**Condiciones del contrato.** Matriz o fila nula: IllegalArgumentException; vacía: 0.

**5 pruebas automáticas.** Se comprueban repetidos, ausente, vacía, filas vacías y fila nula.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio19ContarMatriz.java`.

### Ejercicio 20 · Mayor racha creciente

**Objetivo.** Encontrar la longitud de la mayor racha contigua estrictamente creciente.

**Cómo razonar la resolución.** Compara cada elemento con el anterior: si es mayor, la racha continúa; en otro caso, comienza una nueva. Conserva también la mejor racha observada. Los valores iguales rompen la racha.

**Conceptos y funciones recomendadas.** for con índice, >, Math.max, length.

**Condiciones del contrato.** Array nulo: IllegalArgumentException; vacío: 0.

**5 pruebas automáticas.** Se comprueban varias rachas, decreciente, iguales, vacío y nulo.

**Archivo de trabajo:** `src/main/java/es/educacion/arrays/Ejercicio20RachaCreciente.java`.

## Evaluación automática y criterios de nota

La calificación sigue la estructura del script de referencia aportado: **funcionalidad (7 puntos), calidad (2 puntos) y documentación (1 punto)**. El sistema usa los resultados XML de Surefire, los informes de Checkstyle, PMD y CPD, y la revisión de Javadoc. Los tests que faltan o se omiten no suman.

| Bloque | Máximo | Regla de evaluación |
|---|---:|---|
| Funcionalidad | **7,00** | 100 tests oficiales; cada test correcto aporta **0,07 puntos**; cada ejercicio vale hasta **0,35** |
| Calidad de código | **2,00** | Checkstyle 0,55; PMD 0,90; CPD 0,55, con penalización por incidencias |
| Documentación de clases y funciones | **1,00** | Descripciones de clase, métodos públicos, etiquetas `@param`, `@return` y generación HTML de Javadoc |
| **Total** | **10,00** | Suma de los tres apartados |

**Condición de documentación:** el punto de documentación se habilita únicamente cuando se superan **90 de los 100 tests**. Si se superan menos de 90, el subtotal de documentación aplicado es 0 aunque exista documentación. **El ejercicio 15 tiene además sus cinco tests específicos, que cuentan dentro de los siete puntos de funcionalidad.**

### Cómo se reparte el punto de documentación

- Descripción Javadoc de las 20 clases: **0,15**.
- Descripción Javadoc de los métodos públicos: **0,35**.
- Etiquetas `@param` de los métodos públicos: **0,25**.
- Etiquetas `@return` en métodos que devuelven datos: **0,15**.
- Generación de HTML Javadoc: **0,10**.

### Ejecución de pruebas y obtención de nota

Para ejecutar todos los tests, usa **`mvn test`**. Los ejercicios están incompletos deliberadamente y algunas pruebas fallarán hasta que programes las soluciones.

Para ejecutar solamente los cinco tests de un ejercicio, usa el comando **`mvn -Dtest=Ejercicio01SumarTest test`** (ajusta el número y el nombre de la clase).

Para ejecutar las pruebas, revisar estilo, analizar duplicación, generar Javadoc y obtener la calificación, utiliza:

```bash
mvn clean verify -Pnota
```

Se requiere `python3` accesible desde la terminal. La evaluación está diseñada para continuar tras fallos de tests y generar informes.

### Informes generados

| Informe | Contenido |
|---|---|
| `target/notas_por_bloques.txt` | Resultado narrativo por ejercicio, incidencias y nota final |
| `target/nota/informe-nota.md` | Rúbrica legible y resultados detallados |
| `target/nota/desglose-ejercicios.csv` | Tests superados, fallidos, errores y omitidos por ejercicio |
| `target/nota/rubrica-completa.csv` | Puntuación de todos los criterios |
| `target/nota/nota.csv` | Resultado numérico final / 10 |
| `target/surefire-reports/` | Informes XML oficiales de JUnit |

## Recomendaciones para el alumnado

1. Lee el enunciado y el contrato de la clase antes de programar. Decide primero qué debe pasar si hay valores nulos, vacíos, repetidos o índices incorrectos.
2. Distingue entre un método que cuenta, busca, transforma o devuelve un nuevo array. Diseña la solución evitando modificar entradas cuando no esté permitido.
3. Realiza un ejercicio cada vez y comprueba su batería de cinco tests; los mensajes de fallo explican qué situación no se ha resuelto.
4. Documenta las clases y métodos durante el desarrollo, no únicamente al final. Dedica especial atención al ejercicio 15.
5. Ejecuta el perfil de evaluación para conocer el desglose de la nota e identificar los aspectos que quedan por mejorar.

## Notas para el profesorado

La batería es determinista y cubre situaciones habituales y casos límite, pero cinco tests por ejercicio **no demuestran la corrección universal** de un algoritmo. El Javadoc se comprueba a partir del texto fuente y de la generación HTML; no sustituye una revisión semántica humana. Para una evaluación acreditativa, conserva una copia inalterable del proyecto y de sus tests oficiales.
