/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejemplo de archivo de configuraciones y Singlenton
 *
 * @author luisza
 */
public class ConfigManager {

    // Me instancio solo una vez
    private static ConfigManager cm = new ConfigManager();

    private Properties props;

    private ConfigManager() {
        // que sea privado previene que otros lo instancien
        props = new Properties();
    }

    public static ConfigManager getInstance() {
        // retorna la unica instancia
        return cm;
    }

    public String getProperty(String key) {
        return props.getProperty(key, "");
    }

    public void setProperty(String key, String value) {
        props.setProperty(key, value);
    }

    private Path get_config_dir() throws IOException {
        // Se asegura que siempre exista el directorio de configuracion
        Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), ".LeeArchivos");
        if (!Files.isDirectory(path)) {
            Files.createDirectories(path);
        }
        return path;
    }

    private String get_config_file() throws IOException {
        //Retorna el archivo de configuracion
        Path path = this.get_config_dir();
        path = path.getFileSystem().getPath(path.toString(), "config.properties");
        return path.toString();
    }

    public void load_config() {
        // carga las configuraciones desde un archivo de texto
        File configFile;
        try {
            configFile = new File(this.get_config_file());
            InputStream inputStream = new FileInputStream(configFile);
            props.load(inputStream);
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void save_config() {
        // Guarda las configuraciones en un archivo de texto
        File configFile = null;
        FileWriter writer = null;
        //props.setProperty("formato", "json");
        try {
            writer = new FileWriter(this.get_config_file());
            props.store(writer, "leearchivos settings");

        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
