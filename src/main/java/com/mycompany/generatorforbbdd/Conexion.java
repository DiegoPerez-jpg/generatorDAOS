package com.mycompany.generatorforbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;
    private static Conexion conexionObject;

    private Conexion(String URL, String USER, String PASSWORD){
        try {
            // 1. Cargar el driver (opcional en Java 8+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. Verificar la conexión
            if (conexion != null) {
                System.out.println("✅ Conexión establecida correctamente");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("❌ No se encontró el driver JDBC: " + e.getMessage());
        }
    }


    public static Connection getConnection(){
        if(conexionObject == null){
            System.out.println("Se debe crear anteriormente con el otro metodo sobrecagardo");
            return null;
        }
        return conexionObject.conexion;
    }

    public static Connection getConnection(String URL, String USER, String PASSWORD){
        if(conexionObject == null){
            conexionObject = new Conexion(URL,USER,PASSWORD);
        }
        return conexionObject.conexion;
    }
}
