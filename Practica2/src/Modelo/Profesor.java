/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author user
 */
public class Profesor {
    private String nombre,cedula,correo;
    private int horario;

    public Profesor(String nombre, String cedula, String correo, int horario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.horario = horario;
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

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }
    public String getInformacion(){
        return "Nombre: " +nombre+" Cedula: "+ cedula+" Correo: "+ correo+"  Horario: " + horario;
    }
    
}
