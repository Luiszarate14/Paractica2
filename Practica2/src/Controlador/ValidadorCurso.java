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
public class ValidadorCurso {
    private final static String creditopattern = "^\\d+$";     

    
    public static boolean validaCredito(String cred){
        Pattern pat = Pattern.compile(creditopattern, 
                Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(cred);
        return mat.matches();
    }

}
