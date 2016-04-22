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
        switch (formato) {
            case "xml":
                salvador = new SalvadorXML();
                break;
            case "json":
                salvador = new SalvadorJson();
                break;
            case "dat":                
                salvador = new SalvadorBinario();
                break;
            default:
                break;
        }
        return salvador;
    }
            
    
}
