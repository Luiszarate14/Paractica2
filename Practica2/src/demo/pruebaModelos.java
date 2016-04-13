/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import Modelo.Curso;
import Modelo.Matricula;
import Modelo.DBCurso;
import Modelo.Estudiante;
import Modelo.DBEstudiante;
import Modelo.DBMatricula;
import Modelo.EstudianteException;
import Modelo.MatriculaManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author luisza
 */
public class pruebaModelos {
    private DBEstudiante dbEstudiante;
    private DBCurso dbCurso;
    private DBMatricula dbmatricula;

    public pruebaModelos() {
        dbEstudiante = new DBEstudiante();
        dbCurso = new DBCurso();
        dbmatricula = new DBMatricula();
    }
    
    public void verificaMatriculaManager(){
        MatriculaManager mm = new MatriculaManager(
                dbmatricula, 
                dbEstudiante, dbCurso);
        
        System.err.println("Imprimiendo estudiantes del curso IF3001");
        Curso curso = dbCurso.obtener_curso("IF3001");
        for(Estudiante est: mm.estudiantes_del_curso(curso)){
            System.out.println(est.getInformacion());
        }
        System.err.println("Imprimiendo cursos del estudiante Carnet 18");
        Estudiante estudiante = dbEstudiante.buscarEstudiante("Carnet 18");
        for(Curso cur: mm.cursos_del_estudiante(estudiante)){
            System.out.println(cur.getSigla()
            );
        }
    }
    
    public void cargaDatos(){
        cargaEstudiantes();
        cargaCurso();
        cargarMatricula();
    }
    
    
    private void cargaEstudiantes(){
        for(int x=0; x<20; x++){
            try {
                dbEstudiante.agregarEstudiante( new Estudiante(
                        "Carnet "+x, "nombre "+x, "correo"+x+"@clase.com"));
            } catch (EstudianteException ex) {
                Logger.getLogger(pruebaModelos.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
    }
    
    private void cargaCurso(){
        for(int x=0; x<5; x++){
         dbCurso.agrega_curso(new Curso("IF300"+x, "Curso "+x, 20));
        }
    }
    
    private void cargarMatricula(){
        for(int x=0; x<5; x++){
            dbmatricula.agregar_matricula(new Matricula("IF300"+x,  "Carnet "+x));
            dbmatricula.agregar_matricula(new Matricula("IF300"+x,  "Carnet "+(5+x)));
            dbmatricula.agregar_matricula(new Matricula("IF300"+x,  "Carnet "+(10+x)));
            dbmatricula.agregar_matricula(new Matricula("IF300"+x,  "Carnet "+(15+x)));        
        
        }
    }
    
    public static void main(String args[]) {
        pruebaModelos pmodelo = new pruebaModelos();
        pmodelo.cargaDatos();
        pmodelo.verificaMatriculaManager();
               
    }
}
