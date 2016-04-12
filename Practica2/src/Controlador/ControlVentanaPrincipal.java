/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConfigManager;
import Modelo.DBCurso;
import Modelo.Estudiante;
import Modelo.DBEstudiante;
import Modelo.DBMatricula;
import Vista.ConsultaEstudiantes;
import Vista.ManipulaCurso;
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
    private DBEstudiante dbEstudiante;
    private DBCurso dbCurso;
    private ManipulaCurso manipulaCurso;
    private DBMatricula dbMatricula;
    private ConfigManager config_manager;

    public ControlVentanaPrincipal() {

        dbEstudiante = new DBEstudiante();
        dbCurso = new DBCurso();
        dbMatricula = new DBMatricula();
        config_manager = ConfigManager.getInstance();
        config_manager.load_config();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            config_manager.save_config();
            System.exit(0);
        }else

        if (e.getActionCommand().equalsIgnoreCase("Manipular Estudiantes")) {
            this.manipulaEstudiantes = new ManipulaEstudiantes(dbEstudiante);
            manipulaEstudiantes.show();
        }else
        if (e.getActionCommand().equalsIgnoreCase("Reporte Estudiantes")) {
            reporte = new ReporteEstudiante();
            reporte.getPanelTabla().llenarTabla(dbEstudiante.getMatriz(), Estudiante.getEtiquetas());
            reporte.show();
        }else
        if (e.getActionCommand().equalsIgnoreCase("Consultar Estudiantes")) {

            consultaEstudiantes = new ConsultaEstudiantes();
            if (dbEstudiante.getInformacionDeEstudiantes().equals("")) {
                JOptionPane.showMessageDialog(null, "No hay estudiantes en lista");
            } else {
                consultaEstudiantes.llenarTextArea(dbEstudiante.getInformacionDeEstudiantes());
                consultaEstudiantes.show();
            }
        }else
       if(e.getActionCommand().equalsIgnoreCase("Mantener Curso")){
           this.manipulaCurso = new ManipulaCurso();
           ControlCurso cc = new ControlCurso(manipulaCurso, 
                                              dbCurso, 
                                              dbMatricula,
                                              dbEstudiante);
           manipulaCurso.agrega_acciones(cc);
           this.manipulaCurso.set_estudiantes(
                this.dbEstudiante.getArregloEstudiante()
           );
           this.manipulaCurso.setVisible(true);
       }else
        if(e.getActionCommand().equalsIgnoreCase("XML")){
            this.config_manager.setProperty("formato", "xml");
        }else
        if(e.getActionCommand().equalsIgnoreCase("json")){
            this.config_manager.setProperty("formato", "json");
        }
    }
    
}
