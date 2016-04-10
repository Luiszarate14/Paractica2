/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luisza
 */
public class Validador {
    private final static String emailpattern = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final static String carnetpattern = "^[A-Z]*\\d{5}$";   
    
    public boolean validaEmail(String email){
        Pattern pat = Pattern.compile(emailpattern, Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(email);
        return mat.find();
    }
    
    public boolean validarCarnet(String carnet){
        Pattern pat = Pattern.compile(carnetpattern, Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(carnet);
        return mat.find();       
    }
}
