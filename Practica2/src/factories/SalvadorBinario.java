/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factories;

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
 * @author user
 */
public class SalvadorBinario implements SalvadorArchivos{
    private Escritor escritor;
    private AyudanteOS ayudaos;
    @Override
    public void guardarEstudiante(ArrayList<Estudiante> estudiantes) {
        try {
            escritor.writeObjectProfesorBin(ayudaos.get_config_file("estudiantes.dat"), estudiantes);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarCurso(HashMap<String, Curso> cursos) {
        try {
            escritor.writeObjectProfesorBin(ayudaos.get_config_file("cursos.dat"), cursos);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void guardarMatriculas(ArrayList<Matricula> matriculas) {
         try {
            escritor.writeObjectProfesorBin(ayudaos.get_config_file("matriculas.dat"), matriculas);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarProfesor(ArrayList<Profesor> profesores) {
         try {
            escritor.writeObjectProfesorBin(ayudaos.get_config_file("profesore.dat"), profesores);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Estudiante> obtenerEstudiante() {
        Lector<ArrayList<Estudiante>> lector= new Lector<>();
        String filePath=null;
        try {
            filePath= ayudaos.get_config_file("estudiantes.dat");
            
        } catch (Exception e) {
            System.out.println("no existe path . dat");
        }
        return lector.read_Bin(filePath);
    }

    @Override
    public HashMap<String, Curso> obtenerCurso() {
         Lector<HashMap<String,Curso>> lector= new Lector<>();
        String filePath=null;
        try {
            filePath= ayudaos.get_config_file("cursos.dat");
            
        } catch (Exception e) {
            System.out.println("no existe path . dat");
        }
        return lector.read_Bin(filePath);
    }

    @Override
    public ArrayList<Matricula> obtenerMatriculas() {
         Lector<ArrayList<Matricula>> lector= new Lector<>();
        String filePath=null;
        try {
            filePath= ayudaos.get_config_file("matriculas.dat");
            
        } catch (Exception e) {
            System.out.println("no existe path . dat");
        }
        return lector.read_Bin(filePath);
    }

    @Override
    public ArrayList<Profesor> obtenerProfesor() {
        Lector<ArrayList<Profesor>> lector= new Lector<>();
        String filePath=null;
        try {
            filePath= ayudaos.get_config_file("profesores.dat");
            
        } catch (Exception e) {
            System.out.println("no existe path . dat");
        }
        return lector.read_Bin(filePath);
    }
}
