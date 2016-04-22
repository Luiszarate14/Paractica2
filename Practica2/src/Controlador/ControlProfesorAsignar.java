/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Asignacion;
import Modelo.Curso;
import Modelo.DBAsignar;
import Modelo.Profesor;
import Modelo.ProfesorException;
import Vista.ManipulaAsignarCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Silvia Araya J
 */
public class ControlProfesorAsignar implements ActionListener{
    public final static int ASIGNAR = 1;
    private ManipulaAsignarCurso mac;
    private DBAsignar dba;
    
    public ControlProfesorAsignar(ManipulaAsignarCurso mac, DBAsignar dba){
        this.mac = mac;
        this.dba =dba;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int codigo = this.mac.getCodigoPorFuente(e.getSource());
            switch(codigo){
                case ASIGNAR: dba.asignarCurso(new Asignacion(new Profesor(mac.get_Profesor_seleccionado()),new Curso(mac.getSigla(),8)));
//profesor seleccionado del combo box, y el curso de acuerdo a la sigla
                break;
            }} catch (ProfesorException ex) {
                System.out.println(ex.getMessage());
        }
    }
    
}
