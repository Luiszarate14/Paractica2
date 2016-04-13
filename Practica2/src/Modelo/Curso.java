/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author luisza
 */
public class Curso {
    private String sigla;
    private String nombre;
    private int numero_creditos;
    private int cantidad_estudiantes;

    
    public Curso(String sigla, String nombre, int numero_creditos) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.numero_creditos = numero_creditos;
        cantidad_estudiantes = 0;
    }

    public Curso() {
    }
    
    
    public void incrementa_cantidad_estudiantes(){
        cantidad_estudiantes++;
    }
    public void decrementa_cantidad_estudiantes(){
        cantidad_estudiantes++;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_creditos() {
        return numero_creditos;
    }

    public void setNumero_creditos(int numero_creditos) {
        this.numero_creditos = numero_creditos;
    }

    public int getCantidad_estudiantes() {
        return cantidad_estudiantes;
    }

    public void setCantidad_estudiantes(int cantidad_estudiantes) {
        this.cantidad_estudiantes = cantidad_estudiantes;
    }
    
}
