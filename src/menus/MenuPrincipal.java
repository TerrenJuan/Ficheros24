package menus;

import java.util.Scanner;

public class MenuPrincipal {
    private boolean salir = false;
    private Scanner sc = new Scanner(System.in);
    private MenuComprobaciones menuComprobaciones = new MenuComprobaciones();
    private MenuFicheros menuFicheros = new MenuFicheros();
    public void mostrarMenuPrincipal(){
        String opcion;
        do {
            System.out.println("Elige una opción:");
            System.out.println("1. Comprobaciones de ficheros.");
            System.out.println("2. Acceso a ficheros.");
            System.out.println("0. Salir.");
            opcion = this.pideOpcion();
            this.procesarOpcion(opcion);
        } while (!salir);
    }

    private void procesarOpcion(String opcion) {
        switch (opcion) {
            case "0" -> salir = true;
            case "1" -> this.menuComprobaciones.mostrarMenuComprobaciones();
            case "2" -> this.menuFicheros.mostrarMenuAccesoFicheros();
            default -> System.out.println("Opción no válida.");
        }
    }

    private String pideOpcion() {
        return this.sc.nextLine();
    }
}
