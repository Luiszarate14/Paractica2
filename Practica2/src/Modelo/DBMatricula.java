/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author luisza
 */
public class DBMatricula {
    private ArrayList<Matricula> matriculas;

    public DBMatricula() {
        matriculas = new ArrayList<>();
        
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Matricula obtener_matricula(String carnet, String sigla){
        for(Matricula mat: matriculas){
            if(mat.getCurso().equals(sigla) &&
               mat.getEstudiante().equals(carnet) ){
                return mat;
            }
        }
        return null;
    }
    public void agregar_matricula(Matricula matricula){
        if(matriculas.contains(matricula)){
            //FIXME: EXCEPTION
        }
        matriculas.add(matricula);
    }
    
    public void eliminar_matricula(Matricula matricula){
        matriculas.remove(matricula);
    }
    
    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }
    
    
}
