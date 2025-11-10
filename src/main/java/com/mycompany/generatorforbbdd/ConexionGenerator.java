package com.mycompany.generatorforbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionGenerator {
    private String url;
    private String user;
    private String password;
    private StringBuilder s;
    public ConexionGenerator(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void init(){
        craftConexionSB();
        Table.setupModelosRepository("conexion");
        Table.crearArchivo("conexion","",s,"conexion");
    }

    public void craftConexionSB(){
        s = new StringBuilder();
        s.append("import java.sql.Connection;\n" +
                        "import java.sql.DriverManager;\n" +
                        "import java.sql.SQLException;\n"+
                "public class Conexion {\n"+
                "private Connection conexion;\n" +
                "    private static Conexion conexionObject;\n" +
                "    private static final String URL = \""+url+"\";\n" +
                "    private static final String USER = \""+user+"\";\n" +
                "    private static final String PASSWORD = \""+password+"\";\n" +
                "\n" +
                "    private Conexion(String URL, String USER, String PASSWORD){\n" +
                "        try {\n" +
                "            // 1. Cargar el driver (opcional en Java 8+)\n" +
                "            Class.forName(\"com.mysql.cj.jdbc.Driver\");\n" +
                "\n" +
                "            // 2. Establecer la conexión\n" +
                "            conexion = DriverManager.getConnection(URL, USER, PASSWORD);\n" +
                "\n" +
                "            // 3. Verificar la conexión\n" +
                "            if (conexion != null) {\n" +
                "                System.out.println(\"✅ Conexión establecida correctamente\");\n" +
                "            }\n" +
                "\n" +
                "        } catch (SQLException e) {\n" +
                "            System.out.println(\"❌ Error de conexión: \" + e.getMessage());\n" +
                "        } catch (ClassNotFoundException e) {\n" +
                "            System.out.println(\"❌ No se encontró el driver JDBC: \" + e.getMessage());\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "\n" +
                "    public static Connection getConnection(){\n" +
                "        if(conexionObject == null){\n" +
                "            conexionObject = new Conexion(URL,USER,PASSWORD);\n" +
                "        }\n" +
                "        return conexionObject.conexion;\n" +
                "    }\n"+"}");
    }

}
