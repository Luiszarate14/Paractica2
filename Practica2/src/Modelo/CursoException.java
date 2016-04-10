/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author luisza
 */
public class CursoException extends Exception {

    private boolean limpiaInterfaz;
    public CursoException(String message, boolean limpiaInterfaz) {
        super(message);
        this.limpiaInterfaz = limpiaInterfaz;
    }

    public CursoException(String message) {
        super(message);
        this.limpiaInterfaz = false;
    }
    public boolean isLimpiaInterfaz() {
        return limpiaInterfaz;
    }
    
}
