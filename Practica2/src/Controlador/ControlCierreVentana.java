/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConfigManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author luisza
 */
public class ControlCierreVentana extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
        ConfigManager.getInstance().save_config();
    }
}
