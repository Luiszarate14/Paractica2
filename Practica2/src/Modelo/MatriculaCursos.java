/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Carolina
 */
public class MatriculaCursos {
    private ArrayList <Curso> arrayCurso;
    int pos;

    public MatriculaCursos() {
        arrayCurso = new ArrayList<>();
    }
    
    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    public Curso getInfo(){
         return arrayCurso.get(getPos());
     }
    
    public void agregarCurso(Curso curso){
        arrayCurso.add(curso);
    }// agrega un curso
    
     public boolean buscarCursoPorSigla(String siglas){
       boolean buscar=false;
        for(int i=0; i<arrayCurso.size(); i++ )
            if(arrayCurso!=null){
                if(arrayCurso.get(i).getSiglas().equalsIgnoreCase(siglas))
                {
                    buscar=true;
                    setPos(i);
                    break;
                }
            }
        return buscar;
    }//busca y retorna el curso
     
     public void eliminarCurso(String siglas){
        arrayCurso.remove(getPos());
    }   
    
}
