package dao;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.sql.Connection;

import java.sql.DriverManager;

public class Conexion {
    private String host;
    private int puerto;
    private String baseDeDatos;
    private String usuario;
    private String password;

    public Conexion() {
        this.host="";
        this.puerto=0;
        this.baseDeDatos="";
        this.usuario="";
    }

    public Conexion(String host, int puerto, String baseDeDatos, String usuario, String password) {
        this.host = host;
        this.puerto = puerto;
        this.baseDeDatos = baseDeDatos;
        this.usuario = usuario;
        this.password=password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Connection obtenerConexion() throws Exception{

        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos, usuario, password);
        return conexion;
    }

}
