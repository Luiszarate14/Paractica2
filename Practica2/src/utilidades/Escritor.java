/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import flexjson.JSONSerializer;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisza
 */
public class Escritor {
    
    FileWriter writer;
    private ObjectOutputStream oos;
    private String nameOfFile;
    
    private void write_with_throws(String filepath, String text) throws IOException{
        File file = new File(filepath);
        if(!file.exists()){
            file.createNewFile();
        }
        writer = new FileWriter(file); 
        // Writes the content to the file
        writer.write(text); 
        writer.flush();

    }
    
    public void write_file(String filepath, String text){
        try {
            write_with_throws(filepath, text);
        } catch (IOException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void with_obj_in_file_json(String filepath, Object obj){
        //http://flexjson.sourceforge.net/#Serialization
        JSONSerializer serializer = new JSONSerializer();
        write_file(filepath, serializer.serialize( obj ));
    }
    
    public void with_obj_in_file_xml(String filepath, Object obj){
        // https://docs.oracle.com/javase/7/docs/api/java/beans/XMLEncoder.html
        XMLEncoder e;
        try {
            e = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(filepath)));
            e.writeObject(obj);
            e.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void with_obj_in_file_binario(String filepath, Object obj){
       FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("profesores.txt");
            pw = new PrintWriter(fichero);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
     public boolean openFile() {

        try {
            oos = new ObjectOutputStream(new FileOutputStream(nameOfFile));
            return true;
        } catch (IOException ex) {
            System.out.println("Se genero un: FileNotFoundException");;
            return false;
        }

    }

    public void close() {
        try {
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            System.out.println("Se genero una IOException");
        }
    }
}
