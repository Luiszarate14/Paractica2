/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Matricula;
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
 * @author luisza
 */
public class SalvadorJson implements SalvadorArchivos{

    private Escritor escritor;
    private AyudanteOS ayudaos;

    public SalvadorJson() {
        escritor = new Escritor();
        ayudaos = new AyudanteOS();
    }

    @Override
    public void guardarEstudiante(ArrayList<Estudiante> estudiantes) {
        try {
            escritor.with_obj_in_file_json(
                    ayudaos.get_config_file("estudiantes.json"),
                    estudiantes);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarCurso(HashMap<String, Curso> cursos) {
        try {
            escritor.with_obj_in_file_json(
                    ayudaos.get_config_file("cursos.json"),
                    cursos);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarMatriculas(ArrayList<Matricula> matriculas) {
        try {
            escritor.with_obj_in_file_json(
                    ayudaos.get_config_file("matriculas.json"),
                    matriculas);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Estudiante> obtenerEstudiante() {
        Lector<ArrayList<Estudiante>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("estudiantes.json");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lector.read_json(filepath);
    }

    @Override
    public HashMap<String, Curso> obtenerCurso() {
        Lector<HashMap<String, Curso>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("cursos.json");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lector.read_json(filepath);
    }

    @Override
    public ArrayList<Matricula> obtenerMatriculas() {
        Lector<ArrayList<Matricula>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("matriculas.json");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lector.read_json(filepath);         
    }
    
}
