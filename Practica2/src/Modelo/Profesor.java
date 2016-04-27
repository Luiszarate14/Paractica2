/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Silvia Araya J
 */
public class Profesor implements java.io.Serializable{
    private String nombre;
    private String cedula;
    private String correo;
    private int horarioDisponible;
    
    public Profesor(){
        
    }
    public Profesor(String cedula){
        this.cedula = cedula;
    }
    public Profesor(String nombre, String cedula, String correo, int horarioDisponible){
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.horarioDisponible = 48;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(int horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }

    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", horarioDisponible=" + horarioDisponible + '}';
    }
    public void incremetarHoras(){
        horarioDisponible++;
    }
    
}
