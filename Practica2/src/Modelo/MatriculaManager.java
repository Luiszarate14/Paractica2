/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author luisza
 */
public class MatriculaManager {
    
    private DBMatricula matriculas;
    private DBEstudiante dbestudiante;
    private DBCurso dbcurso;

    public MatriculaManager(DBMatricula matriculas, DBEstudiante dbestudiante, DBCurso dbcurso) {
        this.matriculas = matriculas;
        this.dbestudiante = dbestudiante;
        this.dbcurso = dbcurso;
    }
       
    
    public ArrayList<Estudiante> estudiantes_del_curso(Curso curso){
       ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
       
       for(Matricula matricula: matriculas.getMatriculas()){
           if(matricula.getCurso().equals(curso.getSigla())){
             Estudiante est = dbestudiante.buscarEstudiante(matricula.getEstudiante());
             if(est != null){
                 estudiantes.add(est);
             }else{
             //FIXME: Loggin problems
             
             }
           }
       
       }
      return estudiantes;
    }
    public ArrayList<Curso> cursos_del_estudiante(Estudiante estudiante){
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        for(Matricula matricula: matriculas.getMatriculas()){
            if(matricula.getEstudiante().equals(estudiante.getCarnet())){
                Curso curso =dbcurso.obtener_curso(matricula.getCurso()); 
                cursos.add(curso);
            }
        }
        return cursos;
    }

}
