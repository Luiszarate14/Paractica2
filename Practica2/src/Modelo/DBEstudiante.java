/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Luisza
 */
public class DBEstudiante {

    private ArrayList<Estudiante> arregloEstudiante;
    private String matrizDatos[][];

    public DBEstudiante() {

        this.arregloEstudiante = new ArrayList<Estudiante>();
    }

    public void setArregloEstudiante(ArrayList<Estudiante> arregloEstudiante) {
        this.arregloEstudiante = arregloEstudiante;
    }

    public String agregarEstudiante(Estudiante estudiante) throws EstudianteException {

        if (verificarEstudiante(estudiante.getCarnet())) 
            throw new EstudianteException(
                    "Ya existe un estudiante con ese numero de carnet",
                    false);
        
        arregloEstudiante.add(estudiante);
        return "Se agrego con exito";
    }

    public boolean verificarEstudiante(String carnet) {

        boolean dev = false;
        if (arregloEstudiante.size() != 0) {

            for (int i = 0; i < arregloEstudiante.size(); i++) {
                if (arregloEstudiante.get(i).getCarnet().equalsIgnoreCase(carnet)) {

                    dev = true;

                    break;

                }
            }

        }
        return dev;
    }

    public Estudiante buscarEstudiante(String carnet) {

       Estudiante dev = null;
        if (arregloEstudiante.size() != 0) {

            for (Estudiante estu:arregloEstudiante) {
                if (estu.getCarnet().equalsIgnoreCase(carnet)) {

                    dev =estu;
                    break;

                }
            }

        }
        return dev;
    }

    public String eliminar(String carnet) throws EstudianteException {
        Estudiante estudi = buscarEstudiante(carnet);
        
        if(estudi == null) throw new EstudianteException(
                        "No existe el estudiante para eliminar", false);
        
        arregloEstudiante.remove(estudi);

        return "Se elimino el estudiante";
    }

    public void modificar(Estudiante estudiante){
        for(Estudiante estudi:arregloEstudiante){
            if(estudi.getCarnet().equalsIgnoreCase(estudiante.getCarnet())){
                estudi.setNombre(estudiante.getNombre());
                estudi.setCorreo(estudiante.getCorreo());
                break;
                
            }
            
        }
    }
    
    public String [][] getMatriz(){
     matrizDatos= new String[arregloEstudiante.size()][Estudiante.getTamanno()];
     for(int i=0;i<matrizDatos.length;i++){
         for(int j=0;j<matrizDatos[i].length;j++){
             matrizDatos[i][j]= arregloEstudiante.get(i).getDatos(j);
             
         }//fin de for columna
         
     }//fin de for fila
     return matrizDatos;
}
    
    public String getInformacionDeEstudiantes(){
        String info="";
            if(arregloEstudiante!=null){
                for(int i=0; i<arregloEstudiante.size();i++){
                    info=info+"\n"+arregloEstudiante.get(i).getInformacion();
                }
            }
                
        return info;
    }

    public ArrayList<Estudiante> getArregloEstudiante() {
        return arregloEstudiante;
    }
    
    
}
