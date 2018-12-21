package cl.accenture.programatufuturo.guia.controllers;

import cl.accenture.programatufuturo.guia.dao.CancionDAO;
import cl.accenture.programatufuturo.guia.dao.Conexion;
import cl.accenture.programatufuturo.guia.model.Cancion;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class TestController {
    @RequestMapping(method = RequestMethod.GET , value="/canciones")
    public LinkedList<Cancion> getCancion( ){
        try{

            CancionDAO dao = new CancionDAO(new Conexion("localhost",3306,"cancion","root","mikyyuu12"));
            return dao.obtenerCanciones();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    @RequestMapping(method = RequestMethod.POST , value="/canciones")
    public void setCancion( @RequestBody Cancion cancion){
        try{
            CancionDAO dao = new CancionDAO(new Conexion("localhost",3306,"cancion","root","mikyyuu12"));
            dao.almacenarCancion(cancion);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
