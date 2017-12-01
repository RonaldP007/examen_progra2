package base_datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronald
 */
public class conectar {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    public Connection Conexion() {
        if (connection == null) {

            //nombre tabla
            String url = "jdbc:postgresql://localhost:5432/examen2";
            String password = "RPG007rpg";
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, "postgres", password);
                if (connection != null) {
                    // System.out.println("Se conecto");
                    return connection;
                }
            } catch (Exception e) {
                System.out.println("No se conecto a la base");
            }
        }
        return null;
    }

    public boolean Prod_Registro(int id, String nombre, int precio, String tipo) {
        boolean se_registro = false;
        conectar bd = new conectar();
        connection = bd.Conexion();

        try {
            s = connection.createStatement();

            int z = s.executeUpdate("INSERT INTO productos (id_producto, nombre, precio, tipo) VALUES ('" + id + "', '" + nombre + "', '" + precio + "', '" + tipo + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se agrego el registro con exito");
                se_registro = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar registro");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
            JOptionPane.showMessageDialog(null, "Ese id de producto ya esta en uso");
        }

        return se_registro;
    }
    
    public ArrayList<String> Cargar_Combo_Ventas(String tipo) {
        conectar bd = new conectar();
        connection = bd.Conexion();
        String id;
        String nombre;
        ArrayList<String> lista = new ArrayList<>();
        try {
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_producto,nombre FROM productos WHERE tipo ='" + tipo + "'");
            while (rs.next()) {
                id= rs.getString("id_producto");
                nombre = rs.getString("nombre");
                lista.add(id);
                lista.add(nombre);
            }
            if (lista.size()>=1){
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
     public boolean Comp_Registro(String nombre, int edad, Character sexo, int id_producto, String fecha) {
        boolean se_registro = false;
        conectar bd = new conectar();
        connection = bd.Conexion();

        try {
            s = connection.createStatement();

            int z = s.executeUpdate("INSERT INTO compras (nombre_usuario, edad, sexo, id_producto, fecha) VALUES ('" + nombre+ "', '" + edad+ "', '" + sexo + "', '" + id_producto + "', '" + fecha + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se agrego el registro con exito");
                se_registro = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar registro");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
            JOptionPane.showMessageDialog(null, e);
        }

        return se_registro;
    }
}
