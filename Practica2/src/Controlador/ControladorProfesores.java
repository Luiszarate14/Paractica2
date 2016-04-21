/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AlmacenamientoProfesor;
import Vista.Gui_Profesores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author user
 */
public class ControladorProfesores implements ActionListener{
    private Gui_Profesores ventanaProfesor;
    private AlmacenamientoProfesor arregloProfe;
    public ControladorProfesores(Gui_Profesores ventanaProfesor,AlmacenamientoProfesor arregloProfe) {
        this.ventanaProfesor=ventanaProfesor;   
        this.arregloProfe=arregloProfe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
