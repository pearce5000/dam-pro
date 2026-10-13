# Unidad 02 · Tarea 1 — Generador de tickets de compra

**Módulo:** Programación — 1.º de Desarrollo de Aplicaciones Multiplataforma (DAM)  
**Entorno:** IntelliJ IDEA, Java 21, Maven y GitHub  
**Sistemas operativos:** Windows (Git Bash) y Debian (Bash)  
**Ubicación de entrega:** `git/dam-pro/unidad-02/tarea1/`

## Objetivos

Al finalizar esta tarea deberás ser capaz de:

- Comprobar si existe tu repositorio `dam-pro` en GitHub y en el equipo; crearlo y clonarlo si es necesario.
- Crear un proyecto **Java con Maven desde IntelliJ IDEA**, dentro del repositorio Git que ya utilizas.
- Leer datos por teclado mediante `Scanner` y utilizar variables `String`, `int` y `float`.
- Repetir operaciones mediante un bucle `for` y calcular un total utilizando un acumulador (variable).
- Documentar la tarea y mantener actualizado el índice de `unidad-02/README.md`.
- Realizar commits progresivos y subirlos a GitHub con `git push`.

> **Importante:** este documento es el enunciado que entrega el profesor. Debes guardarlo como `unidad-02/tarea1/README.md` y **conservar todas sus instrucciones**. Al terminar, añadirás tus apartados de desarrollo y pruebas al final del archivo.

---

# Paso 1. Verificación del repositorio y creación del proyecto Maven

## 1.1. Comprobar el repositorio remoto en GitHub

1. Abre <https://github.com> e inicia sesión.
2. Comprueba si tienes un repositorio llamado **`dam-pro`**.
3. **Si ya existe**, utilízalo: no crees otro ni borres sus archivos.
4. **Si no existe**, selecciona **New repository** y configúralo así:
    - **Repository name:** `dam-pro`.
    - **Description:** `Repositorio de Programación de DAM`.
    - **Visibility:** `Public`.
    - Activa **Add a README file**.
    - Pulsa **Create repository**.
5. Copia o identifica la URL HTTPS de tu repositorio. Tendrá una forma similar a `https://github.com/TU_USUARIO/dam-pro.git`.

## 1.2. Preparar la terminal en IntelliJ IDEA

1. Abre **IntelliJ IDEA**.
2. Abre la terminal desde **View → Tool Windows → Terminal** (`Alt + F12`).
3. En **Windows**, utiliza **Git Bash** como terminal. Si tienes que configurarla, entra en **File → Settings → Tools → Terminal** y selecciona Git Bash (habitualmente `"C:\Program Files\Git\bin\bash.exe" --login -i`).
4. En **Debian**, utiliza **Bash** (`/bin/bash`).
5. Comprueba que Git funciona:

```bash
git --version
```

Si Git no está disponible, instala **Git para Windows** desde <https://git-scm.com/downloads/win>; en Debian puedes utilizar `sudo apt update && sudo apt install git`. Si no tienes configurado el autor de los commits, utiliza tus datos reales:

```bash
git config --global user.name "Nombre Apellidos"
git config --global user.email "tu-correo@example.com"
```

## 1.3. Comprobar si existe la copia local y clonarla si hace falta

Todos trabajaremos dentro de la carpeta `git` de nuestro directorio personal. En Windows (Git Bash) normalmente será `/c/Users/TU_USUARIO_WINDOWS/git`; en Debian, `/home/tu_usuario/git`, generalmente tu_usuario será **alumno**. Verifica si existe la carpeta **/home/alumno/git/dam-pro**.

Accede a ella o ejecuta:

```bash
cd ~
mkdir -p git
cd git
pwd
ls
```

**Si aparece la carpeta `dam-pro`:**

```bash
cd dam-pro
git status
git remote -v
```

Comprueba que `git status` funciona y que la URL de `origin` corresponde a **tu** repositorio. No continúes si la carpeta existe pero no es un repositorio Git: consulta al profesor para no perder datos.

**Si no aparece la carpeta `dam-pro`:** clona el repositorio remoto (sustituye `TU_USUARIO` por tu nombre de usuario de GitHub):

```bash
git clone https://github.com/TU_USUARIO/dam-pro.git
cd dam-pro
git status
git remote -v
```

**Si has creado el repositorio remoto ahora**, este clon tendrá inicialmente solo el README principal. Es normal; crearás la estructura de la unidad en los siguientes apartados.

> **No ejecutes `git init` dentro de `tarea1`:** todo debe pertenecer al repositorio Git principal `dam-pro`.

## 1.4. Comprobar la rama y sincronizar

Todos los comandos siguientes se ejecutan desde la raíz de `dam-pro`:

```bash
pwd
git branch --show-current
git status
git fetch origin
git log --oneline HEAD..origin/main
git pull --ff-only origin main
git status
```

La rama de trabajo de esta actividad es `main`. Si el nombre de tu rama es diferente, pide indicaciones antes de continuar. Si `git pull --ff-only` muestra un error, **no borres ni fuerces cambios**: revisa `git status` y consulta al profesor.

**Observa:** `git fetch` consulta y descarga la información del repositorio remoto; `git pull` integra sus cambios en tu copia local.

## 1.5. Abrir `dam-pro` en IntelliJ IDEA

1. Selecciona **File → Open**.
2. Abre la carpeta `git/dam-pro` de tu usuario.
3. Comprueba que la ventana **Project** muestra el README principal y, si ya existían, las carpetas de otras unidades.
4. Comprueba que tienes disponible **JDK 21**. Si IntelliJ IDEA lo solicita, selecciona un JDK 21 instalado o descárgalo desde el asistente.

## 1.6. Crear la unidad si todavía no existe

En el panel **Project** de IntelliJ IDEA:

1. Comprueba si existe `unidad-02` dentro de `dam-pro`.
2. Si **no existe**, haz clic derecho sobre `dam-pro` → **New → Directory** → escribe `unidad-02`.
3. Si **ya existe**, consérvala sin borrar nada.
4. Comprueba si existe `unidad-02/README.md`. Si no, créalo con **New → File** y escribe como mínimo:

```markdown
# Unidad 02 - Fundamentos de Java

## Descripción

Ejercicios de programación básica en Java.

## Índice de tareas

| Tarea | Descripción | Estado |
|---|---|---|
```

Si el README ya contiene la descripción o un índice, **no lo sustituyas**.

## 1.7. Crear el proyecto Maven `tarea1` desde el IDE

**No crees manualmente la estructura Maven con comandos de terminal.** Utiliza el asistente de IntelliJ IDEA:

1. Comprueba primero si ya existe la carpeta `unidad-02/tarea1`. Si contiene un `pom.xml`, **abre el proyecto existente**; no vuelvas a crearlo.
2. Si no existe, selecciona **File → New → Project**.
3. Selecciona **Java** como lenguaje y **Maven** como sistema de construcción (según la versión de IntelliJ IDEA, Maven puede aparecer como tipo de proyecto).
4. Introduce **Name:** `tarea1`.
5. Selecciona **Location:** la carpeta `git/dam-pro/unidad-02`. **Comprueba antes de crear** que la ruta final que muestra el asistente termina en `git/dam-pro/unidad-02/tarea1` y que no va a crear `tarea1/tarea1`.
6. Elige **JDK 21**.
7. Si aparecen identificadores Maven, utiliza por ejemplo **GroupId:** `es.dam` y **ArtifactId:** `tarea1`.
8. **Desactiva la creación de un nuevo repositorio Git**, si el asistente ofrece esa opción.
9. Pulsa **Create**. Si pregunta cómo abrirlo, puedes abrirlo en otra ventana y mantener abierta la del repositorio principal.
10. Espera a que IntelliJ IDEA cargue el proyecto Maven.

La estructura mínima debe ser:

```text
git/
└── dam-pro/
    ├── README.md
    └── unidad-02/
        ├── README.md
        └── tarea1/
            ├── README.md
            ├── pom.xml
            └── src/
                └── main/
                    └── java/
                        └── Main.java
```

El fichero `Main.java` se creará en el **Paso 2**. Si IntelliJ IDEA utiliza un paquete (por ejemplo `es.dam`), coloca la clase dentro de ese paquete y conserva la estructura correspondiente. No hace falta reproducir literalmente el árbol anterior si usas paquetes Java.


## 1.8. Actualizar el índice de tareas de la unidad

Abre `unidad-02/README.md` y, dentro del apartado `## Índice de tareas`, añade la entrada siguiente **sin borrar las tareas anteriores**:

```markdown
| [Tarea 1](tarea1/) | Generador de tickets de compra | En desarrollo |
```

Si ya existe una entrada para `tarea1`, actualiza su descripción y estado sin duplicarla. Guarda el archivo.

## 1.9. Primer commit: estructura y documentación

Abre la terminal integrada situada en la **raíz de `dam-pro`**. Si la terminal del proyecto Maven está en `tarea1`, vuelve a la raíz con `cd ../..`.

```bash
git status
git add unidad-02/README.md
git add unidad-02/tarea1/README.md
git add unidad-02/tarea1/pom.xml
git diff --cached
git commit -m "build: preparar tarea 1 unidad 02"
git push origin main
git status
```

Si ya tenías un README o un proyecto creado y Git indica que **no hay cambios que confirmar**, comprueba los archivos: no realices commits vacíos. Comprueba en GitHub que se visualiza la tarea y que el enlace del índice funciona.

---

# Paso 2. Desarrollo del ejercicio: Generador de tickets de compra

## 2.1. Enunciado

Una pequeña tienda necesita un programa de consola que genere un ticket de compra sencillo. El programa debe:

1. Solicitar el **nombre del cliente**.
2. Preguntar **cuántos productos** va a comprar.
3. Utilizar un **bucle `for`** para pedir el nombre y el precio de cada producto.
4. Mostrar la información de cada producto.
5. **Acumular los precios** en una variable que represente el total.
6. Mostrar al terminar el número de productos, el importe total y un mensaje de despedida personalizado.

> No es necesario utilizar arrays ni colecciones. Puedes mostrar cada línea del ticket al leer su producto y el total al finalizar el bucle.

## 2.2. Ejemplo de ejecución

```text
====================================
         TIENDA DAM-PRO
====================================

Introduce tu nombre: Laura
¿Cuántos productos vas a comprar? 3

Producto 1
Nombre: Cuaderno
Precio: 2.50
Cuaderno - 2.50 euros

Producto 2
Nombre: Bolígrafo
Precio: 1.25
Bolígrafo - 1.25 euros

Producto 3
Nombre: Carpeta
Precio: 3.75
Carpeta - 3.75 euros

====================================
            TOTAL DEL TICKET
====================================
Cliente: Laura
Productos comprados: 3
TOTAL: 7.50 euros
Gracias por tu compra, Laura.
```

**Nota sobre los decimales:** el separador decimal aceptado por `Scanner` depende de la configuración regional. Si tu programa está configurado para usar coma, introduce por ejemplo `2,50`. Si está configurado para usar punto, utiliza `2.50`. Puedes configurar explícitamente una región si el profesor lo indica.

## 2.3. Requisitos técnicos

| Elemento | Uso obligatorio |
|---|---|
| `Scanner` | Leer los datos por teclado |
| `String` | Guardar el nombre del cliente y el de cada producto |
| `int` | Guardar la cantidad de productos y controlar el bucle |
| `float` | Guardar los precios y el total |
| `for` | Repetir la lectura de cada producto |
| Acumulador | Sumar todos los precios |
| `System.out.println()` | Mostrar los mensajes y resultados |

En esta primera tarea puedes suponer que se introducen **cantidades positivas y precios válidos**. No necesitas implementar todavía validaciones complejas ni control de errores de entrada.

## 2.4. Crear la clase Java con IntelliJ IDEA

1. Abre el proyecto Maven `tarea1`.
2. En el panel **Project**, localiza `src/main/java`.
3. Haz clic derecho sobre `java` (o sobre tu paquete) → **New → Java Class**.
4. Escribe `Tickets` y comprueba que se crea `Main.java`.
5. Incorpora el método `main`. Puedes comenzar con este esqueleto, **sin solución completa**:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // 1. Pedir el nombre del cliente.
        // 2. Preguntar la cantidad de productos.
        // 3. Inicializar el acumulador total.
        // 4. Usar un bucle for para pedir los productos.
        // 5. Mostrar el número de productos y el total.

        teclado.close();
    }
}
```

Si la clase pertenece a un paquete Java, conserva la línea `package ...;` que haya generado IntelliJ IDEA encima de los imports.

## 2.5. Programar por fases

**Fase A — Datos iniciales:** solicita el nombre del cliente (`String`) y el número de productos (`int`). Comprueba que ambos se muestran correctamente. Recuerda que al combinar `nextInt()`, `nextFloat()` y `nextLine()` puede quedar pendiente un salto de línea: debes gestionarlo.

**Fase B — Productos y acumulador:** crea un `float` para el total, inicialmente a cero. Utiliza un `for` que se repita tantas veces como productos se hayan indicado. En cada vuelta solicita el nombre (`String`) y el precio (`float`), muestra el producto y suma su precio al total.

**Fase C — Ticket final:** al salir del bucle, muestra el cliente, la cantidad de productos, el importe acumulado y el mensaje de despedida.

## 2.6. Segundo commit: lectura de datos

Cuando la **Fase A** funcione, abre la terminal del repositorio principal (ruta `git/dam-pro`). Ejecuta:

```bash
git status
git add unidad-02/tarea1/src/
git diff --cached
git commit -m "feat: solicitar datos iniciales de la compra"
git push origin main
```

Es importante hacer este commit **antes de continuar** con el bucle.

## 2.7. Tercer commit: bucle `for` y total

Cuando las fases B y C funcionen:

```bash
git status
git add unidad-02/tarea1/src/
git diff --cached
git commit -m "feat: generar ticket con bucle for y acumulador"
git push origin main
```

## 2.8. Ejecutar y realizar las pruebas

En IntelliJ IDEA, abre `Main.java` y selecciona **Run 'Main.main()'**. Comprueba estas pruebas:

| Prueba | Entrada | Total esperado |
|---|---|---|
| 1 | Un producto de 5 euros | 5 euros |
| 2 | Dos productos de 2 y 3 euros | 5 euros |
| 3 | Tres productos de 1,50; 2,50 y 4 euros | 8 euros |
| 4 | Cuatro productos de 1 euro cada uno | 4 euros |

Si usas Maven desde la terminal para compilar, entra en `unidad-02/tarea1` y ejecuta `mvn compile` (si Maven está instalado o disponible mediante el IDE). **No subas** archivos `.class` ni la carpeta `target/`.

Comprueba el `.gitignore` de la raíz de `dam-pro`. Si no existe, créalo desde IntelliJ IDEA y añade estas líneas (conservando cualquier otra regla previa):

```gitignore
**/target/
*.class
.idea/
*.iml
```

Si has modificado `.gitignore`, regístralo junto con el siguiente commit o en un commit específico.

## 2.9. Documentar pruebas y completar el índice

**No borres el enunciado.** Al final de este mismo archivo `unidad-02/tarea1/README.md`, añade y completa con tus propias palabras:

```markdown
## Desarrollo y pruebas del alumno

### Cómo funciona mi programa

Explica cómo has utilizado Scanner, las variables,
el bucle for y el acumulador.

### Pruebas realizadas

Describe los datos introducidos y los resultados
obtenidos en las cuatro pruebas obligatorias.

### Dificultades y soluciones

Explica al menos una dificultad encontrada o indica
qué parte has revisado con especial atención.
```

Abre también `unidad-02/README.md` y modifica el estado de tu tarea a **Completada**:

```markdown
| [Tarea 1](tarea1/) | Generador de tickets de compra | Completada |
```

No borres otras entradas del índice.

## 2.10. Cuarto commit: documentación final

Desde la raíz de `dam-pro`:

```bash
git status
git add unidad-02/tarea1/README.md
git add unidad-02/README.md
git add .gitignore
git diff --cached
git commit -m "docs: finalizar tarea 1 y actualizar indice"
git push origin main
git status
git log --oneline -6
```

Si `.gitignore` no se ha creado o modificado porque ya estaba correcto, no pasa nada: `git add .gitignore` simplemente añadirá su versión actual si existe. **Si no existe, créalo antes** de ejecutar ese comando.

Verifica en GitHub que se ven el enunciado, el `pom.xml`, el código Java y el índice actualizado.

---

# Paso 3. ¿Qué hacer si termina el tiempo de clase?

**Si no acabas durante la clase, es obligatorio subir a GitHub todo lo que tengas realizado, aunque el programa esté incompleto, y terminar la tarea en casa.** No esperes al día siguiente para realizar el primer push.

## 3.1. Antes de salir de clase

1. Guarda todos tus archivos en IntelliJ IDEA.
2. Abre la terminal integrada y asegúrate de estar dentro de la raíz `git/dam-pro`.
3. Comprueba los cambios y publícalos:

```bash
git status
git add unidad-02/README.md unidad-02/tarea1/
git diff --cached
git commit -m "wip: guardar avance de tarea 1 para continuar en casa"
git push origin main
git status
```

`wip` significa *work in progress* (trabajo en progreso). Este commit debe utilizarse **solo si tienes cambios pendientes**. Si Git muestra que no hay cambios que confirmar, no necesitas crear otro commit: comprueba que tu último trabajo ya está publicado.

4. En `unidad-02/README.md`, conserva el estado **En desarrollo** hasta que el programa esté realmente terminado. Si lo has modificado, incluye ese cambio en el commit de avance.
5. Abre GitHub y comprueba que aparece tu último commit.

## 3.2. Continuar desde casa

1. Abre IntelliJ IDEA y el repositorio `dam-pro` en tu equipo de casa.
2. Si no tienes la copia local, clónala siguiendo los pasos del apartado **1.3**.
3. En la raíz del repositorio, ejecuta:

```bash
git status
git fetch origin
git log --oneline HEAD..origin/main
git pull --ff-only origin main
```

4. Abre el proyecto Maven de `unidad-02/tarea1` y termina los apartados pendientes.
5. Realiza las pruebas, documenta el resultado y cambia el estado del índice a **Completada** solo cuando funcione.
6. Registra y publica los cambios finales:

```bash
git status
git add unidad-02/README.md unidad-02/tarea1/
git diff --cached
git commit -m "feat: terminar tarea 1 desde casa"
git push origin main
git status
```

Si ya realizaste el commit final de documentación, utiliza un mensaje que describa los cambios reales que hayas hecho en casa. No realices commits vacíos.

> **Recuerda:** el trabajo entregado se comprobará en GitHub. Un archivo guardado únicamente en el ordenador del aula o de casa **no es una entrega**.

---

# Paso 4. Entrega en Moodle

Entrega en Moodle el **enlace público directo** a la carpeta de la tarea:

```text
https://github.com/TU_USUARIO/dam-pro/tree/main/unidad-02/tarea1
```

Sustituye `TU_USUARIO` por tu usuario real de GitHub.

El profesor revisará:

- La estructura Maven y el archivo `pom.xml`.
- El código fuente de `Main.java` y su funcionamiento.
- El `README.md` de la tarea, que debe conservar el enunciado y añadir tus pruebas.
- El índice actualizado en `unidad-02/README.md`.
- El historial de commits, que debe mostrar trabajo progresivo.
- La publicación del trabajo realizado durante la clase, aunque se haya completado después en casa.

## Criterios de evaluación

| Criterio | Puntuación |
|---|---:|
| Repositorio preparado, estructura Maven y README | 1 punto |
| Índice de tareas actualizado | 1 punto |
| Uso correcto de `Scanner`, `String`, `int` y `float` | 2 puntos |
| Bucle `for` correctamente utilizado | 2 puntos |
| Acumulador y cálculo del total | 2 puntos |
| Pruebas y presentación de resultados | 1 punto |
| Commits progresivos y publicación en GitHub | 1 punto |
| **Total** | **10 puntos** |

## Ampliación voluntaria

Si terminas antes, haz que el programa pregunte también cuántas **unidades** se compran de cada producto. Calcula el subtotal de cada producto como `precio × unidades` y acumula los subtotales en el total. Registra esta mejora en un commit independiente.
