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

    // Ejercicio 7: devuelve true si el promedio es mayor o igual a 8
    public boolean esDestacado() {
        return promedio >= 8;
    }
}