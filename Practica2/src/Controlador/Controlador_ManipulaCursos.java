/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MatriculaCursos;
import Vista.ManipulaCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Carolina
 */
public class Controlador_ManipulaCursos implements ActionListener{
    
    public final static int SIGLAS=1;
    public final static int NOMBRE=2;
    public final static int CREDITOS=3;
    public final static int AGREGAR=4;
    public final static int BUSCAR=5;
    public final static int EDITAR=6;
    public final static int ELIMINAR=7;

    private MatriculaCursos matriculaCursos;
    private ManipulaCursos manipulaCursos;

    public Controlador_ManipulaCursos(ManipulaCursos manipulaCursos) {
        this.manipulaCursos = manipulaCursos;
        matriculaCursos = new MatriculaCursos();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     int codigo= this.manipulaCursos.getCodigo(e.getSource());   
     
     switch(codigo){
            case AGREGAR:
                if(manipulaCursos.verificarEspacios()==true){                
                    JOptionPane.showMessageDialog(null,"Debe llenar todos los espacios");                  
                }else{
                     if(matriculaCursos.buscarCursoPorSigla(manipulaCursos.getTxtSiglas()) == true){
                     JOptionPane.showMessageDialog(null,"El curso ya se encuentra registrado \n Intentelo de nuevo");
                     manipulaCursos.limpiar();
                    }else{
                        matriculaCursos.agregarCurso(manipulaCursos.getCurso());
                        System.out.println("Agrego");
                        manipulaCursos.limpiar(); 
                        JOptionPane.showMessageDialog(null,"Curso agregado correctamente");
                    }     
                }//fin del agregar
            break;
                   
            case ELIMINAR:
                if(manipulaCursos.verificarSiglas()==true){                
                    JOptionPane.showMessageDialog(null,"Debe escribir las siglas");                  
                }else{
                     if(matriculaCursos.buscarCursoPorSigla(manipulaCursos.getTxtSiglas()) == true){
                         matriculaCursos.eliminarCurso(manipulaCursos.getTxtSiglas());
                         JOptionPane.showMessageDialog(null,"El curso se eliminó correctamente");
                         manipulaCursos.limpiar();
                         System.out.println("Eliminó");
                    }else{
                        JOptionPane.showMessageDialog(null,"El curso no se encuentra registrado \n Intentelo nuevamente");
                        manipulaCursos.limpiar(); 
                    }     
                }//fin del elimiar
            break;
            
            case BUSCAR:
                if(manipulaCursos.verificarSiglas()==true){                
                    JOptionPane.showMessageDialog(null,"Favor, digite las siglas del curso");                  
                }else{
                     if(matriculaCursos.buscarCursoPorSigla(manipulaCursos.getTxtSiglas())==true){
                         manipulaCursos.setTxtNombre(matriculaCursos.getInfo().getNombre());
                         manipulaCursos.setTxtCreditos(Integer.toString(matriculaCursos.getInfo().getCreditos()));
                         manipulaCursos.setTxtSiglas(matriculaCursos.getInfo().getSiglas());
                         System.out.println("buscó");
                    }else{
                        JOptionPane.showMessageDialog(null,"El curso no se encuentra registrado \n Intentelo nuevamente");
                        manipulaCursos.limpiar(); 
                    }     
                }
            break;       
            case EDITAR:
                if(manipulaCursos.verificarSiglas()==true){                
                    JOptionPane.showMessageDialog(null,"Favor, digite las siglas del curso");                  
                }else{
                     if(matriculaCursos.buscarCursoPorSigla(manipulaCursos.getTxtSiglas())==true){
                         matriculaCursos.getInfo().setNombre(manipulaCursos.getTxtNombre());
                         matriculaCursos.getInfo().setCreditos(Integer.parseInt(manipulaCursos.getTxtCreditos()));
                         JOptionPane.showMessageDialog(null,"Se modificó correctamente");
                         manipulaCursos.limpiar(); 
                         System.out.println("modificó");
                    }else{
                        JOptionPane.showMessageDialog(null,"El curso no se encuentra registrado \n Intentelo nuevamente");
                        manipulaCursos.limpiar(); 
                    }     
                }
            break;
        }
    }
}
