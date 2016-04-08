/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Carolina
 */
public class Estudiante {
 
    private String nombre;
    private String carne;
    private String correo;

    public Estudiante() {
    }

    public Estudiante(String nombre, String carne, String correo) {
        this.nombre = nombre;
        this.carne = carne;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getInformacion(){
        return "Nombre: " + getNombre() + "\nCarnet: " +getCarne();
    }
    
}
