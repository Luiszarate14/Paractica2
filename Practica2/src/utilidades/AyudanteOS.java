/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author luisza
 */
public class AyudanteOS {
    
    public Path get_config_dir() throws IOException {
        // Se asegura que siempre exista el directorio de configuracion
        Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), ".LeeArchivos");
        if (!Files.isDirectory(path)) {
            Files.createDirectories(path);
        }
        return path;
    }
    
    public Path get_path_config_file(String name) throws IOException{
        Path path = this.get_config_dir();
        path = path.getFileSystem().getPath(path.toString(), name);
        return path;
    }
    
    public String get_config_file(String name) throws IOException{
        return this.get_path_config_file(name).toString();
    }
    
}
