/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

/**
 *
 * @author luisza
 */
public class SalvadorFactory {
    
    public SalvadorArchivos getSalvador(String formato){
        SalvadorArchivos salvador = null;
        if(formato.equals("xml")){
            salvador = new SalvadorXML();
            
        }else if(formato.equals("json")){
            salvador = new SalvadorJson();
        }
        return salvador;
    }
            
    
}
