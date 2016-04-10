/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.BDEstudiante;
import Modelo.EstudianteException;
import Vista.GuiBuscarEstudiante;
import Vista.ManipulaEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisza
 */
public class ControladorMantenimientoEstudiate implements ActionListener {

    public final static int CARNET = 1;

    public final static int NOMBRE = 2;

    public final static int CORREO = 3;

    public final static int AGREGAR = 4;

    public final static int BUSCAR = 5;

    public final static int EDITAR = 6;

    public final static int ELIMINAR = 7;

    private ManipulaEstudiantes manipulaEstudiantes;

    private Estudiante estudiante;
    private BDEstudiante db;
    private GuiBuscarEstudiante guiBuscarEstudiante;

    public ControladorMantenimientoEstudiate(ManipulaEstudiantes manipulaEstudiantes, BDEstudiante db) {
        this.manipulaEstudiantes = manipulaEstudiantes;
        this.db = db;
        this.guiBuscarEstudiante = new GuiBuscarEstudiante();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int codigo = this.manipulaEstudiantes.getCodigoPorFuente(ae.getSource());

        try{
            procesar_accion(codigo);
        }catch(EstudianteException e){
            this.manipulaEstudiantes.setMensajes(e.getMessage());
            if(e.isLimpiarInterfaz()){
                this.manipulaEstudiantes.limpiar();
            }
        }
    }

    public void procesar_accion(int codigo) throws EstudianteException {
        Estudiante estudiante;
        switch (codigo) {
            case AGREGAR:
                if (manipulaEstudiantes.verificar()) {
                    throw new EstudianteException(
                            "Procure llenar los datos requeridos",
                            false);
                }

                estudiante = new Estudiante(manipulaEstudiantes.getTexCarnet(), manipulaEstudiantes.getTexNombre(), manipulaEstudiantes.getTexCorreo());
                manipulaEstudiantes.limpiar();
                JOptionPane.showMessageDialog(null, db.agregarEstudiante(estudiante));

                break;

            case ELIMINAR:
                if (manipulaEstudiantes.verificarTexCarnet()) {
                    throw new EstudianteException(
                            "Procure llenar los datos requeridos",
                            false);
                }

                JOptionPane.showMessageDialog(null, db.eliminar(manipulaEstudiantes.getTexCarnet()));
                manipulaEstudiantes.limpiar();

                break;

            case BUSCAR:
                if (manipulaEstudiantes.verificarTexCarnet()) {
                    throw new EstudianteException(
                            "Ingrese el carnet para buscar el estudiante",
                            true);
                }

                estudiante = db.buscarEstudiante(manipulaEstudiantes.getTexCarnet());
                if (estudiante == null) {
                    throw new EstudianteException(
                            "No se encontró el estudiante",
                            true);
                }

                guiBuscarEstudiante.setInformacion(estudiante.getCarnet() + " " + estudiante.getNombre() + " " + estudiante.getCorreo() + " ");
                guiBuscarEstudiante.show();
                break;

            case EDITAR:

                if (manipulaEstudiantes.verificarTexCarnet()) {
                    throw new EstudianteException(
                            "Ingrese el carnet del estudiante que desea modificar",
                            true);
                }

                estudiante = db.buscarEstudiante(manipulaEstudiantes.getTexCarnet());

                if (estudiante == null) {
                    throw new EstudianteException(
                            "No se encontró el estudiante",
                            true);
                }

                manipulaEstudiantes.getTexCarnet();
                estudiante.setNombre(manipulaEstudiantes.getTexNombre());
                estudiante.setCorreo(manipulaEstudiantes.getTexCorreo());
                db.modificar(estudiante);
                JOptionPane.showMessageDialog(null, "Estudiante actualizado corectamente");

                break;
        }
    }

}
