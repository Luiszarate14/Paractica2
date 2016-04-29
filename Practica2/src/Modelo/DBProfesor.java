/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
/**
 *
 * @author Ariel
 */
public class DBProfesor {
    
    private ArrayList <Profesor> arrayProfesor;

    public DBProfesor() {
        this.arrayProfesor = new ArrayList<Profesor>();
    }
    
    public void setArrayProfesor (ArrayList<Profesor> arrayProfesor)
    {
        this.arrayProfesor= arrayProfesor;
    }
    
    public String agregarProfesor(Profesor profesor) throws ProfesorException {

        if (verificarProfesor(profesor.getCedula())) 
            throw new ProfesorException(
                    "Ya existe un profesor con ese numero de cedula",
                    false);
        
        arrayProfesor.add(profesor);
        return "Se agrego con exito";
    }
    
    public boolean verificarProfesor(String cedula) {

        boolean dev = false;
        if (arrayProfesor.size() != 0) {

            for (int i = 0; i < arrayProfesor.size(); i++) {
                if (arrayProfesor.get(i).getCedula().equalsIgnoreCase(cedula)) {

                    dev = true;

                    break;

                }
            }

        }
        return dev;
    }

    public Profesor buscarProfesor(String cedula) {

       Profesor dev = null;
        if (arrayProfesor.size() != 0) {

            for (Profesor prof:arrayProfesor) {
                if (prof.getCedula().equalsIgnoreCase(cedula)) {

                    dev =prof;
                    break;

                }
            }

        }
        return dev;
    }
    
    public String eliminar(String cedula) throws ProfesorException {
        Profesor profe = buscarProfesor(cedula);
        
        if(profe == null) throw new ProfesorException(
                        "No existe el profesor a eliminar", false);
        
        arrayProfesor.remove(profe);

        return "Se elimino el profesor";
    }

    public void modificar(Profesor profesor){
        for(Profesor profe:arrayProfesor){
            if(profe.getCedula().equalsIgnoreCase(profesor.getCedula())){
                profe.setNombre(profesor.getNombre());
                profe.setCorreo(profesor.getCorreo());
                break;
                
            }
            
        }
    }
    
      public String getInformacionDeProfesores(){
       
          String info= "";
            if(arrayProfesor!=null){
                for(int i=0; i<arrayProfesor.size();i++){
                    info=info+"\n"+arrayProfesor.get(i).getInformacion();
                }
            }
                
        return info;
    }

    public ArrayList<Profesor> getArrayProfesor() {
        return arrayProfesor;
    }
    
    
    
}
