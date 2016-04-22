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
public class Asignacion {
    private Profesor profe;
    private Curso curso;
    
    public Asignacion(Profesor profe, Curso curso){
        this.profe = profe;
        this.curso = curso;
    }

    public Profesor getProfe() {
        return profe;
    }

    public void setProfe(Profesor profe) {
        this.profe = profe;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "profe=" + profe + ", curso=" + curso + '}';
    }
    
}
