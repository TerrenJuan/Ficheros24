package servicios;

import java.nio.file.Files;
import java.nio.file.Path;

public class ServicioComprobaciones {
    public void existe(String ruta){
        // La librería nio, trabaja con la clase Path
        Path p = Path.of(ruta);
        // Los métodos para Path están en la clase Files
        if  (Files.exists(p)){
            System.out.print("El recurso existe y es un ");
            if(Files.isDirectory(p)){
                System.out.print(" directorio.");
            }else{
                System.out.print(" archivo");
            }
            System.out.println(" del sistema de archivos.");
        }else {
            System.out.println("El recurso no existe");
        }
    }

    public boolean sePuedeLeer(String ruta){
       return Files.isReadable(Path.of(ruta));
    }

    public boolean sePuedeEscribir(String ruta){
        return Files.isWritable(Path.of(ruta));
    }

    public boolean esDirectorio(String ruta){
        return Files.isDirectory(Path.of(ruta));
    }
}
