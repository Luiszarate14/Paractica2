/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class AlmacenamientoProfesor {
    ArrayList<Profesor> arregloProfesor;

    public AlmacenamientoProfesor() {
        arregloProfesor= new ArrayList<Profesor>();
    }
    public void setProfesores(ArrayList<Profesor> profesor){
        arregloProfesor=profesor;
    }
    public void agregarProfesor(Profesor profesor){
        if(!verificar(profesor.getCedula())){
            arregloProfesor.add(profesor);
        }
    }
    public boolean verificar(String cedula){
        boolean existeEstudiante=false;
        if(arregloProfesor!=null){
            for(int i=0;i<arregloProfesor.size();i++){
                 if(arregloProfesor.get(i).getCedula().equals(cedula)){
                     existeEstudiante=true;
                     i=arregloProfesor.size();
                 }   
            }
        }
        return existeEstudiante;
    }
    public void modificarProfesor(Profesor profesor){
        for(int i=0;i<arregloProfesor.size();i++){
            if(arregloProfesor.get(i).getCedula().equals(profesor.getCedula())){
                arregloProfesor.get(i).setCedula(profesor.getCedula());
                arregloProfesor.get(i).setCorreo(profesor.getCorreo());
                arregloProfesor.get(i).setHorario(profesor.getHorario());
                arregloProfesor.get(i).setNombre(profesor.getNombre());
                System.out.println("Se modifico con exito");
            }
        }
    }
    public void eliminarProfesor(String cedula){
         for(int i=0;i<arregloProfesor.size();i++){
            if(arregloProfesor.get(i).getCedula().equals(cedula)){
                arregloProfesor.remove(i);
            }
         }
    }
    public ArrayList<Profesor> getArregloProfesor(){
        return arregloProfesor;
    }
    
}
