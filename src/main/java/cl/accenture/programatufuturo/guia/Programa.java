package cl.accenture.programatufuturo.guia;

import cl.accenture.programatufuturo.guia.dao.CancionDAO;
import cl.accenture.programatufuturo.guia.dao.Conexion;
import cl.accenture.programatufuturo.guia.model.Cancion;

import java.util.LinkedList;

public class Programa {
    public static void main(String[] args) {
        Cancion cancion=new Cancion(12,200,"ewewe","erer","asdasd");

        CancionDAO dao=new CancionDAO(new Conexion("localhost",3306,"cancion","root","mikyyuu12"));
        try {
            System.out.println("Insertar cancion: "+cancion);
            dao.almacenarCancion(cancion);
            System.out.println("Cancion guardada");
            System.out.println("Canciones guardadas");
            dao.obtenerCanciones();
            System.out.println("Buscar cancion: lalal");
            LinkedList<Cancion> canciones = dao.buscarCancion("lalal");
            for(Cancion e: canciones){
                System.out.println(e);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
