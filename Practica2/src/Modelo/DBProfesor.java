/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Silvia Araya J
 */
public class DBProfesor {

    private ArrayList<Profesor> profesor;

    public DBProfesor() {
        profesor = new ArrayList<Profesor>();
    }

    public ArrayList<Profesor> getProfesor() {
        System.out.println(profesor);
        return profesor;
        
    }

    public void setProfesor(ArrayList<Profesor> profesor) {
       // System.out.println("set profesor");
        if(profesor != null){
        this.profesor = profesor;
        } 
    }

    public boolean verificarProfesor(Profesor profesores) {
        if (profesor.size() != 0) {
            for (int i = 0; i < profesor.size(); i++) {
                if (profesor.get(i).getCedula().equalsIgnoreCase(profesores.getCedula())) {
                    return true;//ya existe el profesor
                }
            }
        }
        return false;//no existe este profesor
    }

    public Profesor buscarProfe(String id) {
        if (profesor.size() != 0) {
            for (int i = 0; i < profesor.size(); i++) {
                if (profesor.get(i).getCedula().equalsIgnoreCase(id)) {
                    return profesor.get(i);
                }
            }
        }
        return null;
    }

    public boolean buscarProfeID(String id) {
        if (profesor.size() != 0) {
            for (int i = 0; i < profesor.size(); i++) {
                if (profesor.get(i).getCedula().equalsIgnoreCase(id)) {
                    return true;//el profesor si existe
                }
            }
        }
        return false;//el profesor no existe
    }

    public void agregarProfesor(Profesor profe) throws ProfesorException {
        if (verificarProfesor(profe)) {
            throw new ProfesorException("Profesor ya esta Registrado");
        } else {
            profesor.add(profe);
        }
    }

    public void modificarProfesor(Profesor profe) throws ProfesorException {
        if (profesor.size() != 0) {
            if (buscarProfeID(profe.getCedula())) {
                for (int i = 0; i < profesor.size(); i++) {
                    if (profesor.get(i).getCedula().equalsIgnoreCase(profe.getCedula())) {
                        profesor.get(i).setNombre(profe.getNombre());
                        profesor.get(i).setCorreo(profe.getCorreo());
                        profesor.get(i).setHorarioDisponible(profe.getHorarioDisponible());
                        break;
                    }
                }
            } else {
                throw new ProfesorException("Profesor no registrado, imposible modificar sus datos");
            }
        }
    }

    public String eliminarProfesor(String profe) throws ProfesorException {
        if (profesor.size() != 0) {
            if (buscarProfeID(profe)) {
                for (int i = 0; i < profesor.size(); i++) {
                    profesor.remove(profe);
                }
            } else {
                throw new ProfesorException("El profesor no existe, imposible eliminarlo");
            }
        }
        return "Se elimino el profesor";
    }
    public void eliminar(String profe){
        if(profesor.size() !=0){
            if(buscarProfeID(profe)){
                for(int i=0;i<profesor.size();i++){
                    profesor.remove(profe);
                }
            }
        }
    }
    public boolean sumaHoras(){
        for(int i=0; i<profesor.size();i++){
            if(profesor.get(i).getHorarioDisponible() >=8 || profesor.get(i).getHorarioDisponible() <= 48){
                return true;//tiene disponibilidad
            }
        }
        return false;//tiene el horario compeleto
    }
    
}
