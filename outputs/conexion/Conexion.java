public class Conexion {
private Connection conexion;
    private static Conexion conexionObject;
    private static final String URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PASSWORD = "";

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
            conexionObject = new Conexion(URL,USER,PASSWORD);
        }
        return conexionObject.conexion;
    }
}