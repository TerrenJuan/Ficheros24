package menus;

import servicios.ServicioComprobaciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class MenuComprobaciones {
    private Scanner sc = new Scanner(System.in);
    private boolean salir = false;
    private ServicioComprobaciones servicio = new ServicioComprobaciones();
    public void mostrarMenuComprobaciones(){
        String opcion;
        do {
            System.out.println("Elige una opción:");
            System.out.println("1. Fichero existe.");
            System.out.println("2. Lectura.");
            System.out.println("3. Escritura.");
            System.out.println("0. Salir.");
            opcion = this.pideOpcion();
            this.procesarOpcion(opcion);
        } while (!salir);
    }

    private String pideOpcion() {
        return this.sc.nextLine();
    }
    private void procesarOpcion(String opcion) {
        switch (opcion) {
            case "0" -> salir = true;
            case "1" -> this.comprobarExistencia();
            case "2" -> this.comprobarLectura();
            case "3" -> this.comprobarEscritura();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void comprobarLectura() {
        String ruta = this.sc.nextLine();
        if (servicio.sePuedeLeer(ruta)){
            System.out.println("El archivo se puede leer.");
        } else {
            System.out.println("No se puede leer el archivo.");
        }
    }

    private void comprobarExistencia() {
        // Como necesitamos mas datos del usuario, los pedimos en esta capa.
        System.out.println("Introduce la ruta a comprobar: ");
        String ruta = this.sc.nextLine();
        // Llamamos al servicio que comprueba si existe y comprobamos si la ruta cumple los requisitos
        try {
            this.servicio.existe(ruta);
        }catch(InvalidPathException e){
            System.out.println("La ruta contiene caracteres ilegales, revise la sintaxis.");
        }
    }
    private void comprobarEscritura(){
        System.out.println("Introduce la ruta a comprobar: ");
        String ruta =  this.sc.nextLine();
        try {
            this.servicio.sePuedeEscribir(ruta);
        }catch (InvalidPathException e){
            System.out.println("La ruta no esta bien definida.");
        }



    }
}
