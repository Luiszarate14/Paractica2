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
            escritor.escribeBinario(
                    ayudaos.get_config_file("estudiantes.bin"),
                    estudiantes);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarCurso(HashMap<String, Curso> cursos) {
        try {
            escritor.escribeBinario(
                    ayudaos.get_config_file("cursos.bin"),
                    cursos);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }       

    }

    @Override
    public void guardarMatriculas(ArrayList<Matricula> matriculas) {
        try {
            escritor.escribeBinario(
                    ayudaos.get_config_file("matriculas.bin"),
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
            filepath = ayudaos.get_config_file("estudiantes.bin");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lector.read_binario(filepath);
    }

    @Override
    public HashMap<String, Curso> obtenerCurso() {
        Lector<HashMap<String, Curso>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("cursos.bin");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lector.read_binario(filepath);
       
    }

    @Override
    public ArrayList<Matricula> obtenerMatriculas() {
        Lector<ArrayList<Matricula>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("matriculas.bin");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
            return lector.read_binario(filepath);
       
    }

    public void guardarProfesores(ArrayList<Profesor> profesores) {
        try {
            escritor.escribeBinario(ayudaos.get_config_file("profesor.bin"),
                    profesores);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Profesor> obtenerProfesor() {
        Lector<ArrayList<Profesor>> lector = new Lector();
        String filepath = null;
        try{
            filepath = ayudaos.get_config_file("profesor.bin");
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return lector.read_binario(filepath);
        
    }

    @Override
    public void guardarAsignacion(ArrayList<Asignacion> asignacion) {
        try {
            escritor.escribeBinario(
                    ayudaos.get_config_file("asignacion.bin"),
                    asignacion);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Asignacion> obtenerAsignacion() {
            Lector<ArrayList<Asignacion>> lector = new Lector();
            String filepath = null;
            try{
                filepath = ayudaos.get_config_file("asignacion.bin");
                
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            return lector.read_binario(filepath);
        
    }
}
