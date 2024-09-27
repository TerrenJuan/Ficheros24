package menus;

import servicios.ServicioComprobaciones;
import servicios.ServicioFicheros;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class MenuFicheros {
    private Scanner sc = new Scanner(System.in);
    private boolean salir = false;
    private ServicioComprobaciones servicioComprobaciones = new ServicioComprobaciones();
    private ServicioFicheros servicioFicheros = new ServicioFicheros();

    public void mostrarMenuAccesoFicheros(){
        String opcion;
        do{
            System.out.println("Elige una opción: ");
            System.out.println("1. Leer el fichero.");
            System.out.println("2. Escribir el fichero.");
            System.out.println("3. Listar.");
            System.out.println("0. Salir.");
            opcion = this.pideOpcion();
            this.procesarOpcion(opcion);
        }while(!salir);
    }

    private String pideOpcion() {
        return this.sc.nextLine();
    }

    private void procesarOpcion(String opcion){
        switch(opcion){
            case "0" -> salir = true;
            case "1" -> this.leerFichero();
            case "2" -> mostrarMenuEscritura();
            case "3" -> this.listar();
            default -> System.out.println("Opcion no valida.");
        }
    }

    public void mostrarMenuEscritura(){
        String opcion;
        do{
            System.out.println("Elige una opción: ");
            System.out.println("1. Sobreescribe el fichero.");
            System.out.println("2. Añadir información en el fichero.");
            System.out.println("0. Salir.");
            opcion = this.pideOpcion();
            this.procesarOpcionEscritura(opcion);
        }while(!salir);
    }

    private void procesarOpcionEscritura(String opcion) {
        switch(opcion){
            case "0" -> salir = true;
            case "1" -> this.sobreescribirFichero();
            case "2" -> this.escribirEnElFichero();
            default -> System.out.println("Opcion no valida.");
        }
    }

    private void escribirEnElFichero() {
        System.out.println("Introduce la ruta del fichero en el que quieres escribir.");
        String ruta = this.sc.nextLine();
        Path p = Path.of(ruta);
        String texto = this.sc.nextLine();
        if(servicioComprobaciones.sePuedeEscribir(ruta)){
            System.out.println("Escribe el texto que quieres añadir al fichero.");
            servicioFicheros.escribirFichero(p,texto);
        }
    }

    private void sobreescribirFichero() {
        System.out.println("Introduce la ruta del fichero a sobreescribir");
        String ruta = this.sc.nextLine();
        Path p = Path.of(ruta);
        if(servicioComprobaciones.sePuedeEscribir(ruta)){
            System.out.println("Escribe el texto que quieres añadir al fichero.");
            String texto = this.sc.nextLine();
            servicioFicheros.sobreescribirFichero(p,texto);
        }
    }


    private void leerFichero() {
        System.out.println("Introduce la ruta a comprobar: ");
        String ruta =  this.sc.nextLine();
        Path p = Path.of(ruta);
        if(servicioComprobaciones.sePuedeLeer(ruta)){
            try {
                System.out.println(Files.readAllLines(p));
            } catch (IOException e) {
                System.out.println("Error al leer el fichero.");
            }
        }else{
            System.out.println("El fichero no ha podido leerse.");
        }
    }

    private void listar(){
        System.out.println("Introduce la ruta a comprobar: ");
        String ruta =  this.sc.nextLine();

        Path p = Path.of(ruta);
        if(servicioComprobaciones.esDirectorio(ruta)){
            try {
                System.out.println(Files.list(p).toList());
            } catch (IOException e) {
                System.out.println("Error al listar el directorio.");
            }
        }

    }


}
