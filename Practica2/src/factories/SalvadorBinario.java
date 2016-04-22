/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import Modelo.Asignacion;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Matricula;
import Modelo.Profesor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.AyudanteOS;
import utilidades.Escritor;
import utilidades.Lector;

/**
 *
 * @author Silvia Araya J
 */
public class SalvadorBinario implements SalvadorArchivos{

    private Escritor escritor;
    private AyudanteOS ayudaos;

    public SalvadorBinario() {
        escritor = new Escritor();
        ayudaos = new AyudanteOS();
    }
    
    @Override
    public void guardarEstudiante(ArrayList<Estudiante> estudiantes) {
        try {
            escritor.with_obj_in_file_binario(
                    ayudaos.get_config_file("estudiantes.txt"),
                    estudiantes);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarCurso(HashMap<String, Curso> cursos) {
        try {
            escritor.with_obj_in_file_binario(
                    ayudaos.get_config_file("cursos.txt"),
                    cursos);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }       

    }

    @Override
    public void guardarMatriculas(ArrayList<Matricula> matriculas) {
        try {
            escritor.with_obj_in_file_binario(
                    ayudaos.get_config_file("matriculas.txt"),
                    matriculas);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Estudiante>  obtenerEstudiante() {
        Lector<ArrayList<Estudiante>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("estudiantes.txt");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            lector.openFile();
            return lector.read_binario(filepath);
            
        } catch (IOException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HashMap<String, Curso> obtenerCurso() {
        Lector<HashMap<String, Curso>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("cursos.txt");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            lector.openFile();
            return lector.read_binario(filepath);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Matricula> obtenerMatriculas() {
        Lector<ArrayList<Matricula>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("matriculas.txt");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {       
            lector.openFile();
            return lector.read_binario(filepath);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void guardarProfesores(ArrayList<Profesor> profesores) {
        try {
            escritor.with_obj_in_file_binario(
                    ayudaos.get_config_file("profesores.txt"),
                    profesores);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Profesor> obtenerProfesor() {
        try{
            Lector<ArrayList<Profesor>> lector = new Lector();
            String filepath = null;
            try{
                filepath = ayudaos.get_config_file("profesores.txt");
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            lector.openFile();
            return lector.read_binario(filepath);
        }catch(IOException ex){
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void guardarAsignacion(ArrayList<Asignacion> asignacion) {
        try {
            escritor.with_obj_in_file_binario(
                    ayudaos.get_config_file("asignacion.txt"),
                    asignacion);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Asignacion> obtenerAsignacion() {
       try{
            Lector<ArrayList<Asignacion>> lector = new Lector();
            String filepath = null;
            try{
                filepath = ayudaos.get_config_file("asignacion.txt");
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            lector.openFile();
            return lector.read_binario(filepath);
        }catch(IOException ex){
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
