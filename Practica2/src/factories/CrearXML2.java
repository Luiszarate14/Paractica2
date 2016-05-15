
package factories;


import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Matricula;
import Modelo.Profesor;
import utilidades.Inspector;
import utilidades.LectorXML;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

 
public class CrearXML2 implements SalvadorArchivos
{

    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    DOMImplementation implementation;
    Document document;
    ArrayList titulos;
    ArrayList valores;
    Element raiz;
    Inspector inspector;
    String nombreArchivo;
 
    public CrearXML2(String nombreArchivo) 
    {
        this.inspector = new Inspector();
        this.nombreArchivo = nombreArchivo;
        _nuevoArchivo();
    }

    private void _nuevoArchivo() {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, nombreArchivo, null);
            document.setXmlVersion("1.0");
            raiz = document.getDocumentElement();
        } catch (ParserConfigurationException ex) {
            System.out.println("exeptiom");
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardar() 
    {
        try{
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(nombreArchivo)); 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            System.out.println("Archivo XML creado con el nombre: "+nombreArchivo);
        } catch (TransformerException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void _agregarEstudiante(ArrayList<Estudiante> estudiantes) throws IllegalArgumentException, IllegalAccessException{
        HashMap<String, Object> campoEstudiante = null;//guardar
        raiz = document.getDocumentElement();
        Text valor;
        Element item = null;
        Element clave =null;
        
        for(Estudiante estudiante: estudiantes){//eterador
            // Obtengo los campos y los valores de los campos
            campoEstudiante = inspector.obtener_campos(estudiante);
            // Obtengo un iterador para recorrer el HashMap
            Iterator i = campoEstudiante.keySet().iterator();
            item = document.createElement(inspector.obtener_nombre_clase(estudiante));
            while(i.hasNext()){
                String key = (String)i.next();
                clave = document.createElement(key); 
                valor = document.createTextNode(campoEstudiante.get(key).toString());
                clave.appendChild(valor);
                item.appendChild(clave);
            }
            raiz.appendChild(item);
        }
    }
    
    public void agregarEstudiante(ArrayList<Estudiante> estudiantes){
        try {
            this._agregarEstudiante(estudiantes);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private NodeList busco_en_documento(String expresion) throws XPathExpressionException{
        XPath xPath =  XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.compile(
                expresion).evaluate(
            document, XPathConstants.NODESET);
        return nodeList;
    }
//    public ArrayList<Estudiante> get_Estudiante() throws XPathExpressionException{
//        ArrayList<Estudiante> estudiante= new ArrayList<>();
//        NodeList nodeList=this.busco_en_documento("/ejemploEstudiante");
//                
//        IntefaceBuilder Interbuilder= new EstudianteBuider();
//        for(int i=0;i<nodeList.getLength();i++){
//            Node nNode= nodeList.item(i);
//            if(nNode.getNodeType()==Node.ELEMENT_NODE){
//                estudiante.add(Interbuilder.contruyeEstudiante(nNode));
//            }
//        }
//        return estudiante;
//    }
    
    private void _buscar(String expresion, ArrayList<String> campo) throws XPathExpressionException{
         NodeList nodeList = this.busco_en_documento(expresion);
         for (int i = 0; i < nodeList.getLength(); i++) {
             Node nNode = nodeList.item(i);
             System.out.println("\nElemento :" + nNode.getNodeName());
             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               for (int x=0; x<campo.size(); x++){
                   
                   System.out.println(
                           
                           campo.get(x)+" = "+
                    eElement.getElementsByTagName(campo.get(x)).item(0).getTextContent()+
                    eElement.getAttribute("class")
                            );
               }
               
             }
             else{
                    System.out.println("error de impresion:");
                 }
         }
    }
    public void buscar(String expresion, ArrayList<String> campo){//string y expresion
        try {
            this._buscar(expresion, campo);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(LectorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void _cargar(String nombreArchivo) throws SAXException, IOException{
        document = builder.parse(
                        new FileInputStream(nombreArchivo));
    }
    
    public void cargar(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
        try {    
            _cargar(nombreArchivo);
        } catch (SAXException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ///agrega un curso al xml
        private void _agregarCurso(ArrayList<Curso> curso) throws IllegalArgumentException, IllegalAccessException{
        HashMap<String, Object> campoCurso = null;
        raiz = document.getDocumentElement();
        Text valor;
        Element item = null;
        Element clave =null;
        
        for(Curso cursos: curso){
            // Obtengo los campos y los valores de los campos
            campoCurso = inspector.obtener_campos(cursos);
            // Obtengo un iterador para recorrer el HashMap
            Iterator i = campoCurso.keySet().iterator();
            item = document.createElement(inspector.obtener_nombre_clase(cursos)); 
            while(i.hasNext()){
                String key = (String)i.next();
                clave = document.createElement(key); 
                valor = document.createTextNode(campoCurso.get(key).toString());
                clave.appendChild(valor);
                item.appendChild(clave);
            }
            raiz.appendChild(item);
        }
    }
    
        public void agregarCurso(ArrayList<Curso> curso){
        try {
            this._agregarCurso(curso);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        private void _agregarMatricula(ArrayList<Matricula> matricula) throws IllegalArgumentException, IllegalAccessException{
        HashMap<String, Object> campoCurso = null;
        raiz = document.getDocumentElement();
        Text valor;
        Element item = null;
        Element clave =null;
        
        for(Matricula iteMatricula: matricula){
            // Obtengo los campos y los valores de los campos
            campoCurso = inspector.obtener_campos(iteMatricula);
            // Obtengo un iterador para recorrer el HashMap
            Iterator i = campoCurso.keySet().iterator();
            item = document.createElement(inspector.obtener_nombre_clase(iteMatricula)); 
            while(i.hasNext()){
                String key = (String)i.next();
                clave = document.createElement(key); 
                valor = document.createTextNode(campoCurso.get(key).toString());
                clave.appendChild(valor);
                item.appendChild(clave);
            }
            raiz.appendChild(item);
        }
    }
    public void agregarMatriculas(ArrayList<Matricula> matricula){
        try {
            if(matricula!=null)
            this._agregarMatricula(matricula);
            else{
                System.out.println("hola no estoy haciendo nada");
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
        
    @Override
    public void guardarEstudiante(ArrayList<Estudiante> estudiantes) {
        agregarEstudiante(estudiantes);
        guardar();
    }

    @Override
    public void guardarCurso(HashMap<String, Curso> cursos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardarMatriculas(ArrayList<Matricula> matricula) {//guardar matricula
       try {
            this.agregarMatriculas(matricula);
             this.guardar();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CrearXML2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardarProfesor(ArrayList<Profesor> profesores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Estudiante> obtenerEstudiante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, Curso> obtenerCurso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Matricula> obtenerMatriculas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Profesor> obtenerProfesor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

