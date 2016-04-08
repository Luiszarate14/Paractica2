/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.MatriculaEstudiante;
import Vista.ManipulaEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiante
 */
public class Controlador_ManipulaEstudiantes implements ActionListener{

    public final static int CARNE=1;
    public final static int NOMBRE=2;
    public final static int CORREO=3;
    public final static int AGREGAR=4;
    public final static int BUSCAR=5;
    public final static int EDITAR=6;
    public final static int ELIMINAR=7;

    
    private ManipulaEstudiantes manipulaEstudiantes;
    private MatriculaEstudiante matriculaEstudiante;


    public Controlador_ManipulaEstudiantes(ManipulaEstudiantes manipulaEstudiantes) {
        this.manipulaEstudiantes = manipulaEstudiantes;
        matriculaEstudiante = new MatriculaEstudiante();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int codigo= this.manipulaEstudiantes.getCodigo(e.getSource());
         
        switch(codigo){
            case AGREGAR:
                if(manipulaEstudiantes.validarCampos()==true){                
                    JOptionPane.showMessageDialog(null,"Debe llenar todos los espacios");                  
                }else{
                     if(matriculaEstudiante.buscarEstudianteXCarne(manipulaEstudiantes.getTxtCarne()) == true){
                     JOptionPane.showMessageDialog(null,"El estudiante ya se encuentra registrado \n Intentelo de nuevo");
                     manipulaEstudiantes.limpiar();
                    }else{
                        matriculaEstudiante.agregar(manipulaEstudiantes.getEstudiante());
                        System.out.println("Agrego");
                        manipulaEstudiantes.limpiar(); 
                        JOptionPane.showMessageDialog(null,"Agregado correctamente");
                    }     
                }          
            break;
                   
            case ELIMINAR:
                if(manipulaEstudiantes.validarCarne()==true){                
                    JOptionPane.showMessageDialog(null,"Debe llenar el espacio de carné");                  
                }else{
                     if(matriculaEstudiante.buscarEstudianteXCarne(manipulaEstudiantes.getTxtCarne()) == true){
                         matriculaEstudiante.eliminarEstudiante(manipulaEstudiantes.getTxtCarne());
                         JOptionPane.showMessageDialog(null,"El estudiante se eliminó correctamente");
                         manipulaEstudiantes.limpiar();
                         System.out.println("Eliminó");
                    }else{
                        JOptionPane.showMessageDialog(null,"El estudiante no se encuentra registrado \n Intentelo nuevamente");
                        manipulaEstudiantes.limpiar(); 
                    }     
                }      
            break;
            
            case BUSCAR:
                if(manipulaEstudiantes.validarCarne()==true){                
                    JOptionPane.showMessageDialog(null,"Debe llenar el espacio de carné");                  
                }else{
                     if(matriculaEstudiante.buscarEstudianteXCarne(manipulaEstudiantes.getTxtCarne())==true){
                         manipulaEstudiantes.setTxtNombre(matriculaEstudiante.getInfo().getNombre());
                         manipulaEstudiantes.setTxtCorreo(matriculaEstudiante.getInfo().getCorreo());
                         manipulaEstudiantes.setTxtCarne(matriculaEstudiante.getInfo().getCarne());
                         System.out.println("buscó");
                    }else{
                        JOptionPane.showMessageDialog(null,"El estudiante no se encuentra registrado \n Intentelo nuevamente");
                        manipulaEstudiantes.limpiar(); 
                    }     
                }           
            break;    
            case EDITAR:
                if(manipulaEstudiantes.validarCarne()==true){                
                    JOptionPane.showMessageDialog(null,"Debe llenar el espacio de carné");                  
                }else{
                     if(matriculaEstudiante.buscarEstudianteXCarne(manipulaEstudiantes.getTxtCarne())==true){
                         matriculaEstudiante.getInfo().setNombre(manipulaEstudiantes.getTxtNombre());
                         matriculaEstudiante.getInfo().setCorreo(manipulaEstudiantes.getTxtCorreo());
                         JOptionPane.showMessageDialog(null,"Se modificó correctamente");
                         manipulaEstudiantes.limpiar(); 
                         System.out.println("modificó");
                    }else{
                        JOptionPane.showMessageDialog(null,"El estudiante no se encuentra registrado \n Intentelo nuevamente");
                        manipulaEstudiantes.limpiar(); 
                    }     
                }  
            break;
        }
    }
}