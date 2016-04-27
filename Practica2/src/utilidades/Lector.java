/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import Modelo.Estudiante;
import flexjson.JSONDeserializer;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisza
 */
public class Lector<T> {

    BufferedReader br;
    ObjectInputStream lectorBin;
    
    private String read_file_with_throws(String filepath) throws FileNotFoundException, IOException {
        //System.out.println("lector path metodo de clase lector: "+filepath);
        
        br = new BufferedReader(new FileReader(filepath));//aca se cae
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        return sb.toString();

    }

    public String read_file(String filepath) {
        String dev = null;
        try {
            dev = read_file_with_throws(filepath);
        } catch (IOException ex) {
           // System.err.println("Archivo no exite "+ filepath);
           // Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(br != null)
                br.close();
            } catch (IOException ex) 
            {  
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dev;
    }

    public T read_json(String filepath) {
        //http://flexjson.sourceforge.net/#Deserialization
        T objs = null;
        String text = this.read_file(filepath);
        if(text!=null){
            objs = new JSONDeserializer<T>().deserialize(text);
        }
        return objs;
    }

    public T read_xml(String filepath) {
        // https://docs.oracle.com/javase/7/docs/api/java/beans/XMLDecoder.html
        XMLDecoder d;
        T objs = null;
        try {
            d = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(filepath)));

            objs = (T) d.readObject();
            d.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objs;
    }
    //String nameOfFile;

    public T lectura(String filepath) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filepath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        T t = (T) ois.readObject();
        return t;
    }
    public T read_binario(String filepath){
         T  aux=null;
         //System.out.println("path"+filepath);
        try {
            lectorBin= new ObjectInputStream(new FileInputStream(filepath));//errore verificar
            
                aux= (T)lectorBin.readObject();//regresa el objeto       
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No regreso el .bine");
        }
        System.err.println("aux: "+aux);
        return aux;
    }

}
