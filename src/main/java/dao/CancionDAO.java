package dao;

import model.Cancion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class CancionDAO {
    private Conexion conexion;

    public CancionDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public void almacenarCancion(Cancion e)throws Exception{
        PreparedStatement psInsertar= getConexion().obtenerConexion().prepareStatement(
                "INSERT INTO cancion(idcancion, nombre, autor, genero, duracion) VALUES(?,?,?,?,?);");
        psInsertar.setInt(1,e.getIdCancion());
        psInsertar.setString(2,e.getNombre());
        psInsertar.setString(3,e.getAutor());
        psInsertar.setString(4,e.getGenero());
        psInsertar.setInt(5,e.getDuracion());
        int resultpInsert=psInsertar.executeUpdate();
    }

    public void obtenerCanciones()throws Exception{
        PreparedStatement psObtener= getConexion().obtenerConexion().prepareStatement("SELECT * FROM cancion");
        ResultSet rs=psObtener.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("nombre"));
        }
    }
    public LinkedList<Cancion> buscarCancion(String nombre)throws Exception{
        LinkedList<Cancion>cancions=new LinkedList<Cancion>();
        PreparedStatement psBuscar= getConexion().obtenerConexion().prepareStatement("SELECT nombre FROM cancion WHERE nombre=?");
        psBuscar.setString(1,nombre);
        ResultSet rs=psBuscar.executeQuery();
        while (rs.next()){
            Cancion cancion=new Cancion();
            cancion.setNombre(rs.getString("nombre"));
            cancions.add(cancion);
        }
        return cancions;
    }

}
