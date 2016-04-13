/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Curso;
import Modelo.CursoException;
import Modelo.DBCurso;
import Modelo.DBEstudiante;
import Modelo.DBMatricula;
import Modelo.Estudiante;
import Modelo.Matricula;
import Modelo.MatriculaManager;
import Vista.ManipulaCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisza
 */
public class ControlCurso implements ActionListener{
    public final static int AGREGAR = 1;
    public final static int BUSCAR = 2;
    public final static int EDITAR = 3;
    public final static int ELIMINAR = 4;
    public final static int MATRICULAR = 5;
    public final static int DESMATRICULAR = 6;
    
    public String mensaje;
    
    private DBCurso dbCurso;
    private ManipulaCurso cursomanipulador;
    private DBMatricula dbMatricula;
    private MatriculaManager matManager;
    private DBEstudiante dbEstudiante;

    public ControlCurso(ManipulaCurso cursomanipulador, 
            DBCurso dbCurso, DBMatricula dbMatricula,
            DBEstudiante dbEstudiante
            ) {
        this.cursomanipulador = cursomanipulador;
        this.dbCurso = dbCurso;
        this.dbMatricula = dbMatricula;
        this.dbEstudiante = dbEstudiante;
        matManager = new MatriculaManager(dbMatricula, 
                this.dbEstudiante, dbCurso);
        
    }
    private void cargar_matriculas(Curso curso){
        ArrayList<Estudiante> ests = matManager.estudiantes_del_curso(curso);
        
        cursomanipulador.set_estudiantes_matriculados(
          ests );
    }
    
    private void procesa_accion(int codigo) throws CursoException{
        Curso curso;
        String sigla;
        String carnet;
        
        mensaje= "";
        switch (codigo){
            case EDITAR:
            case AGREGAR:
                curso = this.cursomanipulador.get_curso_si_datos_completos();
                dbCurso.agrega_curso(curso);
                this.cursomanipulador.limpiaInterfaz();
                this.mensaje = "Curso guardado satifactoriamente";
               break;
            case BUSCAR:
                sigla = this.cursomanipulador.get_sigla();
                curso = dbCurso.obtener_curso(sigla);
                if(curso == null){
                    throw new CursoException("No se encontró el curso");
                }
                this.cursomanipulador.set_curso(curso);
                cargar_matriculas(curso);
                break;
            case ELIMINAR:
                sigla = this.cursomanipulador.get_sigla();
                dbCurso.eliminar_curso(sigla);
                this.cursomanipulador.limpiaInterfaz();
                this.mensaje = "Curso eliminado satifactoriamente";
                break; 
            case MATRICULAR:
                sigla = this.cursomanipulador.get_sigla();
                carnet = this.cursomanipulador.get_carnet_seleccionado();
                dbMatricula.agregar_matricula(new Matricula(
                        sigla, carnet
                ));
                this.mensaje = "Estudiante matriculado";
                cargar_matriculas(dbCurso.obtener_curso(sigla));
                break; 
            case DESMATRICULAR:
                sigla = this.cursomanipulador.get_sigla();
                carnet = this.cursomanipulador.get_carnet_matriculado();
                dbMatricula.eliminar_matricula(
                    dbMatricula.obtener_matricula(carnet, sigla)
                );
                this.mensaje = "Estudiante desmatriculado";
                cargar_matriculas(dbCurso.obtener_curso(sigla));
                
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int codigo = this.cursomanipulador.getCodigoPorFuente(e.getSource());
            procesa_accion(codigo);
            if(!this.mensaje.equals("")){
                this.cursomanipulador.setMensaje(mensaje);
            }
        } catch (CursoException ex) {
            if(ex.isLimpiaInterfaz()){
                this.cursomanipulador.limpiaInterfaz();
            }
            this.cursomanipulador.setMensaje(ex.getMessage());
        }
    }
    
}
