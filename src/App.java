import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Estudiante[] estudiantes = {
            new Estudiante("Ana", "Gómez", 20, "Sistemas", 8.5),
            new Estudiante("Luis", "Pérez", 21, "Sistemas", 6.0),
            new Estudiante("María", "Díaz", 19, "Informática", 9.2),
            new Estudiante("Carlos", "Ruiz", 22, "Informática", 4.5)
        };

        // Ejercicio 1: mostrar información
        System.out.println("--- Ejercicio 1 ---");
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i].mostrarInformacion();
        }

        // Ejercicio 2: promedio general (acumulador)
        System.out.println("--- Ejercicio 2 ---");
        double suma = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            suma += estudiantes[i].promedio;
        }
        double promedioGeneral = suma / estudiantes.length;
        System.out.println("Promedio general: " + promedioGeneral);

        // Ejercicio 3: mejor promedio (variable auxiliar)
        System.out.println("--- Ejercicio 3 ---");
        Estudiante mejor = estudiantes[0];
        for (int i = 1; i < estudiantes.length; i++) {
            if (estudiantes[i].promedio > mejor.promedio) {
                mejor = estudiantes[i];
            }
        }
        System.out.println("Mejor promedio: " + mejor.nombre + " "
                + mejor.apellido + " (" + mejor.promedio + ")");

        // Ejercicio 4: aprobados (contador)
        System.out.println("--- Ejercicio 4 ---");
        double notaAprobacion = 6; // valor que indique el docente
        int aprobados = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].promedio >= notaAprobacion) {
                System.out.println(estudiantes[i].nombre + " - " + estudiantes[i].promedio);
                aprobados++;
            }
        }
        System.out.println("Cantidad de aprobados: " + aprobados);

        // Ejercicio 5: buscar por nombre
        System.out.println("--- Ejercicio 5 ---");
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

        // Ejercicio 6: clasificación (rangos de ejemplo)
        System.out.println("--- Ejercicio 6 ---");
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

        // Ejercicio 7: usar el método booleano
        System.out.println("--- Ejercicio 7 ---");
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].esDestacado()) {
                System.out.println(estudiantes[i].nombre + " es destacado");
            }
        }

        sc.close();
    }
}