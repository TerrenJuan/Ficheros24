package servicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ServicioFicheros {

    ServicioComprobaciones servicioComprobaciones = new ServicioComprobaciones();
    Scanner sc = new Scanner(System.in);
    public ServicioFicheros() {

    }

    public Path escribirFichero(Path p, String texto) {
        try {
            return Files.writeString(p,texto,StandardOpenOption.APPEND);
        } catch (IOException e) {
            return escribirFichero(p,texto);
        }
    }

    public Path sobreescribirFichero(Path p, String texto) {
        try {
            return Files.writeString(p,texto);
        }catch (IOException e){
            return sobreescribirFichero(p,texto);
        }
    }
}
