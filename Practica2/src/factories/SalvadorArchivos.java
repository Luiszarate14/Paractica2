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
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author luisza
 */
public interface SalvadorArchivos {
    
    void guardarEstudiante(ArrayList<Estudiante> estudiantes);
    void guardarCurso(HashMap<String, Curso> cursos);
    void guardarMatriculas(ArrayList<Matricula> matriculas);
    void guardarProfesores(ArrayList<Profesor> profesores);
    void guardarAsignacion(ArrayList<Asignacion> asignacion);
    ArrayList<Estudiante> obtenerEstudiante();
    HashMap<String, Curso> obtenerCurso();
    ArrayList<Matricula> obtenerMatriculas();  
    ArrayList<Profesor> obtenerProfesor();
    ArrayList<Asignacion> obtenerAsignacion();
    
}
