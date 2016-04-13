/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;

/**
 *
 * @author luisza
 */
public class DBCurso {
    public HashMap<String, Curso> db;

    public DBCurso() {
        db = new HashMap<String, Curso>();
    }

    public HashMap<String, Curso> getDb() {
        return db;
    }

    public void setDb(HashMap<String, Curso> db) {
        this.db = db;
    }
    
    
    
    public void agrega_curso(Curso curso){
        db.put(curso.getSigla(), curso);
    }
    
    public void eliminar_curso(String sigla){
        if(db.containsKey(sigla)){
            db.remove(sigla);
        }
    }
    
    public boolean existe(String sigla){
        return db.containsKey(sigla);
    }
    
    public Curso obtener_curso(String sigla){    
         return db.get(sigla);
    }
}
