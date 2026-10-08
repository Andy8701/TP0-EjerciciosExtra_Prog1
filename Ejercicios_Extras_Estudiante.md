# Ejercicios Extras Aplicados – Clase `Estudiante`

**Alumno:** Saires Andrés
**Materia:** Programación Orientada a Objetos
**Lenguaje:** Java (JDK 17)

**Objetivo:** seguir practicando POO con la clase `Estudiante`, integrando operadores, condicionales (`if / else`), ciclos (`for`), arreglos, contadores y acumuladores.

---

## Clase `Estudiante` (base de todos los ejercicios)

Es la clase del TP0, con dos métodos nuevos: `mostrarInformacion()` (Ejercicio 1) y `esDestacado()` (Ejercicio 7).

```java
public class Estudiante {
    String nombre;
    String apellido;
    int edad;
    String carrera;
    double promedio;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, int edad, String carrera, double promedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    // Ejercicio 1
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellido
                + " | Edad: " + edad
                + " | Carrera: " + carrera
                + " | Promedio: " + promedio);
    }

    // Ejercicio 7
    public boolean esDestacado() {
        return promedio >= 8;
    }
}
```

## Datos de prueba

```java
Estudiante[] estudiantes = {
    new Estudiante("Ana", "Gómez", 20, "Sistemas", 8.5),
    new Estudiante("Luis", "Pérez", 21, "Sistemas", 6.0),
    new Estudiante("María", "Díaz", 19, "Informática", 9.2),
    new Estudiante("Carlos", "Ruiz", 22, "Informática", 4.5)
};
```

> Los valores que define el docente (nota de aprobación, rangos de clasificación y condición del método booleano) son **de ejemplo** y pueden ajustarse.

---

## Ejercicio 1 – Mostrar información completa

**Consigna:** agregar a `Estudiante` un método que muestre toda la información, recorrer el arreglo y usar ese método.

**Resolución:** el método `mostrarInformacion()` imprime todos los atributos del objeto. En el `main` se recorre el arreglo con un `for` y se invoca el método en cada posición.

```java
for (int i = 0; i < estudiantes.length; i++) {
    estudiantes[i].mostrarInformacion();
}
```

**Salida:**

```
Nombre: Ana Gómez | Edad: 20 | Carrera: Sistemas | Promedio: 8.5
Nombre: Luis Pérez | Edad: 21 | Carrera: Sistemas | Promedio: 6.0
Nombre: María Díaz | Edad: 19 | Carrera: Informática | Promedio: 9.2
Nombre: Carlos Ruiz | Edad: 22 | Carrera: Informática | Promedio: 4.5
```

---

## Ejercicio 2 – Promedio general del curso

**Consigna:** recorrer el arreglo, sumar los promedios con un acumulador y calcular el promedio general.

**Resolución:** se usa la variable `suma` como **acumulador** (tipo `double` para no perder decimales) y al final se divide por la cantidad de estudiantes.

```java
double suma = 0;
for (int i = 0; i < estudiantes.length; i++) {
    suma += estudiantes[i].promedio;
}
double promedioGeneral = suma / estudiantes.length;
System.out.println("Promedio general: " + promedioGeneral);
```

**Salida:** `Promedio general: 7.05` (aproximadamente)

---

## Ejercicio 3 – Mejor promedio

**Consigna:** determinar qué estudiante tiene el promedio más alto, usando variables auxiliares.

**Resolución:** se usa la variable auxiliar `mejor`, que guarda al mejor candidato encontrado hasta el momento. Arranca con el primer estudiante y el `for` empieza en `i = 1`. Si aparece alguien con mayor promedio, se reemplaza.

```java
Estudiante mejor = estudiantes[0];
for (int i = 1; i < estudiantes.length; i++) {
    if (estudiantes[i].promedio > mejor.promedio) {
        mejor = estudiantes[i];
    }
}
System.out.println("Mejor promedio: " + mejor.nombre + " "
        + mejor.apellido + " (" + mejor.promedio + ")");
```

**Salida:** `Mejor promedio: María Díaz (9.2)`

---

## Ejercicio 4 – Estudiantes aprobados

**Consigna:** un estudiante aprueba si su promedio es mayor o igual al valor indicado por el docente. Mostrar nombre y promedio de los aprobados y contar cuántos son.

**Resolución:** se recorre con `for`, se evalúa con `if` y se usa el **contador** `aprobados`. Se tomó como nota de aprobación **6** (valor de ejemplo).

```java
double notaAprobacion = 6;
int aprobados = 0;
for (int i = 0; i < estudiantes.length; i++) {
    if (estudiantes[i].promedio >= notaAprobacion) {
        System.out.println(estudiantes[i].nombre + " - " + estudiantes[i].promedio);
        aprobados++;
    }
}
System.out.println("Cantidad de aprobados: " + aprobados);
```

**Salida:**

```
Ana - 8.5
Luis - 6.0
María - 9.2
Cantidad de aprobados: 3
```

---

## Ejercicio 5 – Buscar un estudiante por nombre

**Consigna:** pedir un nombre al usuario, compararlo con el de cada estudiante y mostrar su información. Si no existe, informarlo.

**Resolución:** se usa `Scanner` para leer el nombre y una variable booleana `encontrado` como bandera. La comparación de textos se hace con `equalsIgnoreCase` (y no con `==`, porque `==` compara referencias y no el contenido del `String`).

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
System.out.print("Ingrese un nombre: ");
String buscado = sc.nextLine();

boolean encontrado = false;
for (int i = 0; i < estudiantes.length; i++) {
    if (estudiantes[i].nombre.equalsIgnoreCase(buscado)) {
        estudiantes[i].mostrarInformacion();
        encontrado = true;
    }
}
if (!encontrado) {
    System.out.println("No se encontró ningún estudiante con ese nombre.");
}
sc.close();
```

**Salida (ingresando `luis`):**

```
Nombre: Luis Pérez | Edad: 21 | Carrera: Sistemas | Promedio: 6.0
```

**Salida (ingresando `Pedro`):**

```
No se encontró ningún estudiante con ese nombre.
```

---

## Ejercicio 6 – Clasificación según promedio

**Consigna:** clasificar a cada estudiante según rangos de promedio, usando `if / else if / else`.

**Resolución:** se definieron estos rangos de ejemplo:

| Promedio | Clasificación |
|----------|---------------|
| 9 o más | Excelente |
| 7 a menos de 9 | Bueno |
| 6 a menos de 7 | Regular |
| Menos de 6 | Insuficiente |

```java
for (int i = 0; i < estudiantes.length; i++) {
    String clasificacion;
    double p = estudiantes[i].promedio;
    if (p >= 9) {
        clasificacion = "Excelente";
    } else if (p >= 7) {
        clasificacion = "Bueno";
    } else if (p >= 6) {
        clasificacion = "Regular";
    } else {
        clasificacion = "Insuficiente";
    }
    System.out.println(estudiantes[i].nombre + ": " + clasificacion);
}
```

**Salida:**

```
Ana: Bueno
Luis: Regular
María: Excelente
Carlos: Insuficiente
```

---

## Ejercicio 7 – Método que determina una condición

**Consigna:** agregar a `Estudiante` un método que devuelva un `boolean` según una condición del promedio, y usarlo en un condicional dentro de un recorrido.

**Resolución:** se creó `esDestacado()`, que devuelve `true` si el promedio es mayor o igual a 8 (condición de ejemplo). En el `main`, el `if` usa directamente el resultado del método. Esto deja la lógica dentro de la clase y el código que la usa queda más legible.

```java
for (int i = 0; i < estudiantes.length; i++) {
    if (estudiantes[i].esDestacado()) {
        System.out.println(estudiantes[i].nombre + " es destacado");
    }
}
```

**Salida:**

```
Ana es destacado
María es destacado
```

---

## Conclusiones

- Los **acumuladores** (`suma`) y los **contadores** (`aprobados`) permiten resumir datos de un arreglo en un solo recorrido.
- Las **variables auxiliares** (`mejor`, `encontrado`) sirven para recordar un resultado parcial mientras se recorre.
- Los **métodos dentro de la clase** (`mostrarInformacion`, `esDestacado`) encapsulan comportamiento y evitan repetir código en el `main`.
- Para comparar `String` en Java se usa `equals` / `equalsIgnoreCase`, no `==`.
