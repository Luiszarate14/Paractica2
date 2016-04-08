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
public class MatriculaEstudiante {
    
    private ArrayList <Estudiante> arrayEstudiantes;
    int pos;

    public MatriculaEstudiante() {
        arrayEstudiantes = new ArrayList<>();
    }
    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    public Estudiante getInfo(){
         return arrayEstudiantes.get(getPos());
     }
    
    public void agregar(Estudiante estudiante){
        arrayEstudiantes.add(estudiante);
    
    }
   
    public boolean buscarEstudianteXCarne(String carne){       
        boolean buscar=false;
        for(int i=0; i<arrayEstudiantes.size(); i++ )
            if(arrayEstudiantes!=null){
                if(arrayEstudiantes.get(i).getCarne().equalsIgnoreCase(carne))
                {
                    buscar=true;
                    setPos(i);
                    break;
                }
            }
        return buscar;
    }
    
    public void eliminarEstudiante(String carne){
        arrayEstudiantes.remove(getPos());
    }  
    
    public String [][] getInfoAlumno(){
        String datos [][]= new String[arrayEstudiantes.size()][3];
        
        for(int i=0;i<arrayEstudiantes.size();i++){
            Estudiante get= arrayEstudiantes.get(i);
            datos[i]=new String[]{get.getCarne(),get.getNombre()};
        }
        return datos;
    }
}
