/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.BDEstudiante;
import Vista.ConsultaEstudiantes;
import Vista.ManipulaEstudiantes;
import Vista.ReporteEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Luisza
 */
public class ControlVentanaPrincipal implements ActionListener {

    private ManipulaEstudiantes manipulaEstudiantes;
    private ReporteEstudiante reporte;
    private ConsultaEstudiantes consultaEstudiantes;
    private BDEstudiante db;

    public ControlVentanaPrincipal() {

        db = new BDEstudiante();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Salir")) {

            System.exit(0);

        }else

        if (e.getActionCommand().equalsIgnoreCase("Manipular Estudiantes")) {
            this.manipulaEstudiantes = new ManipulaEstudiantes(db);
            manipulaEstudiantes.show();
        }else
        if (e.getActionCommand().equalsIgnoreCase("Reporte Estudiantes")) {
            reporte = new ReporteEstudiante();
            reporte.getPanelTabla().llenarTabla(db.getMatriz(), Estudiante.getEtiquetas());
            reporte.show();
        }else
        if (e.getActionCommand().equalsIgnoreCase("Consultar Estudiantes")) {

            consultaEstudiantes = new ConsultaEstudiantes();
            if (db.getInformacionDeEstudiantes().equals("")) {
                JOptionPane.showMessageDialog(null, "No hay estudiantes en lista");
            } else {
                consultaEstudiantes.llenarTextArea(db.getInformacionDeEstudiantes());
                consultaEstudiantes.show();
            }
        }
    }
}
