/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom3.creación;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
/**
 *
 * @author Salvador
 */
public class JDOM3Creación {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // TODO code application logic here
        
        Element Eraiz=new Element("mensajes");
        Document docRSS=new Document(Eraiz);
        Eraiz.setAttribute("fecha","31/03/2017");
        Element Emensaje=new Element("mensaje");
        Emensaje.addContent(new Element("de").setText("Pepe (Pepe@ejemplo.com)"));
        Emensaje.addContent(new Element("para").setText("Juan (Juan@ejemplo.com)"));
        Emensaje.addContent(new Element("hora").setText("17:48"));
        Emensaje.addContent(new Element("texto").setText("Hola Juan, ¿qué haces?"));
        Eraiz.addContent(Emensaje);
        Element Emensaje1=new Element("mensaje");
        Emensaje1.addContent(new Element("de").setText("Juan (Juan@ejemplo.com)"));
        Emensaje1.addContent(new Element("para").setText("Pedro (Pedro@ejemplo.com)"));
        Emensaje1.addContent(new Element("hora").setText("21:15"));
        Emensaje1.addContent(new Element("texto").setText("Aquí, aprendiendo XML"));
        Eraiz.addContent(Emensaje1);
       
        try {
            FileOutputStream out = new FileOutputStream("correo.xml");
            XMLOutputter serializer = new XMLOutputter();
            Format ft=Format.getPrettyFormat();
            serializer.setFormat(ft);
            serializer.output(docRSS, out);
            out.flush();	
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
}
