/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AlmacenamientoProfesor;
import Modelo.Profesor;
import Vista.Gui_Informacion;
import Vista.Gui_Profesores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author user
 */
public class ControladorProfesores implements ActionListener{
    private Gui_Profesores ventanaProfesor;
    private AlmacenamientoProfesor arregloProfe;
    private Profesor profesor;
    private Gui_Informacion informacion;
    String cadena="";
    public ControladorProfesores(Gui_Profesores ventanaProfesor,AlmacenamientoProfesor arregloProfe) {
        this.ventanaProfesor=ventanaProfesor;   
        this.arregloProfe=arregloProfe;
        informacion= new Gui_Informacion();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Agregar")){
            if(!ventanaProfesor.getTxt_cedula().equals("")&&!ventanaProfesor.getTxt_correo().equals("")&&Integer.parseInt(ventanaProfesor.getTxt_horario())!=0&&!ventanaProfesor.getTxt_nombre().equals("")){
                if(Integer.parseInt(ventanaProfesor.getTxt_horario())<48&&Integer.parseInt(ventanaProfesor.getTxt_horario())>8){
                    profesor= new Profesor(ventanaProfesor.getTxt_nombre(), ventanaProfesor.getTxt_cedula(), ventanaProfesor.getTxt_correo(), Integer.parseInt(ventanaProfesor.getTxt_horario()));
                    if(arregloProfe.agregarProfesor(profesor))
                    ventanaProfesor.setLbl_informacion("Profesor guardado correctamente");
                    else
                        ventanaProfesor.setLbl_informacion("Profesor ya ha sido ingresado");
                }
                else{
                    ventanaProfesor.setLbl_informacion("Horario debe ser mayor que 8 y menor que 48");
                }
            }
            else
                ventanaProfesor.setLbl_informacion("Espacios sin completar");
        }
        else
        if(e.getActionCommand().equals("Buscar")){
            if(!ventanaProfesor.getTxt_cedula().equals("")){
                if(arregloProfe.verificar(ventanaProfesor.getTxt_cedula())){
                    cadena=arregloProfe.getiInformacion(ventanaProfesor.getTxt_cedula());
                    informacion.setInformacion(cadena);
                    informacion.setVisible(true);
                }
                else
                    ventanaProfesor.setLbl_informacion("No existe el profesor");
            }
            else
                ventanaProfesor.setLbl_informacion("Espacios sin completar");
        }
        else  
        if(e.getActionCommand().equals("Editar")){
            if(!ventanaProfesor.getTxt_cedula().equals("")&&!ventanaProfesor.getTxt_correo().equals("")&&Integer.parseInt(ventanaProfesor.getTxt_horario())!=0&&!ventanaProfesor.getTxt_nombre().equals("")){
                if(arregloProfe.verificar(ventanaProfesor.getTxt_cedula())){
                    profesor= new Profesor(ventanaProfesor.getTxt_nombre(), ventanaProfesor.getTxt_cedula(), ventanaProfesor.getTxt_correo(), Integer.parseInt(ventanaProfesor.getTxt_horario()));
                    arregloProfe.modificarProfesor(profesor);
                     ventanaProfesor.setLbl_informacion("Modificacion con exito");
                }
                else
                    ventanaProfesor.setLbl_informacion("No existe el profesor a modificar");
            }
            else
                ventanaProfesor.setLbl_informacion("Espacios sin completar");
        }
        else
        if(e.getActionCommand().equals("Eliminar")){
            if(!ventanaProfesor.getTxt_cedula().equals("")){
                if(arregloProfe.verificar(ventanaProfesor.getTxt_cedula())){
                    arregloProfe.eliminarProfesor(ventanaProfesor.getTxt_cedula());
                     ventanaProfesor.setLbl_informacion("Profesor ha sido eliminado");
                }
            }
            else
                ventanaProfesor.setLbl_informacion("Se requiere una cedula para completar la accion");
        }
    }    
}