/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.DBProfesor;
import Modelo.Profesor;
import Modelo.ProfesorException;
import Vista.ManipulaProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvia Araya J
 */
public class ControlProfesor implements ActionListener{
    public final static int AGREGAR = 1;
    public final static int BUSCAR = 2;
    public final static int MODIFICAR = 3;
    public final static int ELIMINAR = 4;
    
    private ManipulaProfesor manipulaProfesor;
    private DBProfesor dbp;
    
    public ControlProfesor(ManipulaProfesor manipulaProfesor, DBProfesor dbp){
        this.manipulaProfesor = manipulaProfesor;
        this.dbp = dbp;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int codigo = this.manipulaProfesor.getCodigoPorFuenteProfesor(e.getSource());
            Profesor profesor;
            String cedula;
            switch(codigo){
                case AGREGAR: profesor = this.manipulaProfesor.datosLlenos();
                profesor = new Profesor(this.manipulaProfesor.getNombre(), this.manipulaProfesor.getCedula(),
                this.manipulaProfesor.getCorreo(), Integer.parseInt(this.manipulaProfesor.getHoras()));
                dbp.agregarProfesor(profesor);
                JOptionPane.showMessageDialog(null,"Agregado con exito");
                this.manipulaProfesor.limpiarText();
                break;
                case MODIFICAR: cedula = this.manipulaProfesor.getCedula();
                profesor = dbp.buscarProfe(manipulaProfesor.getCedula());
                 if (profesor == null) {
                    throw new ProfesorException(
                            "No se encontró el profesor");
                }
                 manipulaProfesor.getCedula();
                 profesor.setNombre(manipulaProfesor.getNombre());
                profesor.setCorreo(manipulaProfesor.getCorreo());
                profesor.setHorarioDisponible(Integer.parseInt(manipulaProfesor.getHoras()));
                
                dbp.modificarProfesor(profesor);
                JOptionPane.showMessageDialog(null, "Profesor actualizado corectamente");
                manipulaProfesor.limpiarText();
                    break;
                case ELIMINAR: if(dbp.buscarProfeID(manipulaProfesor.getCedula())){
                    dbp.eliminar(manipulaProfesor.getCedula());
                     JOptionPane.showMessageDialog(null,"Eliminado con exito");
                    manipulaProfesor.limpiarText();
                } else{
                    throw new ProfesorException("No existe este profesor registrado");
                }
                    break;
                case BUSCAR: if(dbp.buscarProfeID(manipulaProfesor.getCedula())){
                    JOptionPane.showMessageDialog(null,dbp.buscarProfe(manipulaProfesor.getCedula()));
                    manipulaProfesor.limpiarText();
                }
                    break;
            }
        } catch (ProfesorException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
