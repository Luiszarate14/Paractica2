package utilidades;


import Modelo.InterfaceAnotacion;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisza
 */
public class Inspector {
    
    public String obtener_nombre_clase(Object o){
        return o.getClass().getName();
    }
    
    public HashMap<String, Object> obtener_campos(Object o) throws IllegalArgumentException, IllegalAccessException {
        Class<?> clazz = o.getClass();//recibe una clase que no sabe el tipo
        HashMap<String, Object> dev = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {//permite obtener los campos de cada clase,(getDeclaredFields() devuel los atributos declarados,nombre,carnet,etc
            //ademas de que el field tiene los objetos declarados con anotaciones en el Objeto estudiante.
            //you can also use .toGenericString() instead of .getName(). This will
            //give you the type information as well.
            System.out.println("tipo"+field.isAnnotationPresent(InterfaceAnotacion.class));
            if (field.isAnnotationPresent(InterfaceAnotacion.class)) {
                for (Annotation anotacion : field.getDeclaredAnnotations()) {
                    InterfaceAnotacion acampo = (InterfaceAnotacion)anotacion ;
                    if (acampo.guardarXml()) {//si la anotacion devuelve true
                        field.setAccessible(true);//crea un atributo privado como publico
                        dev.put( field.getName(), field.get(o));//agrega al hashmap una clave y un objeto y lo devuele
                    }
                }
            }
        }
        return dev;
    }
    
    
}
