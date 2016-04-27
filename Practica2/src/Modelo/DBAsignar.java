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
public class DBAsignar {
    private ArrayList<Asignacion> asignacion;
    
    public DBAsignar(){
        this.asignacion = new ArrayList<>();
    }

    public ArrayList<Asignacion> getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(ArrayList<Asignacion> asignacion) {
        if(asignacion != null){
        this.asignacion = asignacion;
        }
    }
    public void asignarCurso(Asignacion asignar) throws ProfesorException{
        if(ControlHoras()){
        asignacion.add(asignar);
        } else{
            throw new ProfesorException("El profesor no tiene horas disponibles");
        }
    }
    public boolean ControlHoras(){
        for(int i=0; i<asignacion.size();i++){
            if(asignacion.get(i).getProfe().getHorarioDisponible() >=8 && asignacion.get(i).getProfe().getHorarioDisponible() < 48){
                return true;//tiene disponibilidad
            }
        }
        return false;//tiene el horario compeleto
    }
}
