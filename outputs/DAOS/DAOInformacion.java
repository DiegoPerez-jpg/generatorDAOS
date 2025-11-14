import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class informacionDAO {

public void insert(Informacion informacion) {
    String sql = "INSERT INTO informacion (nif, email, telefono) VALUES (?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, entity.getNif());
ps.setString(2, entity.getEmail());
ps.setString(3, entity.getTelefono());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Informacion informacion) {
    String sql = "UPDATE informacion SET nif = ?, email = ?, telefono = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, informacion.getNif());
        ps.setString(2, informacion.getEmail());
        ps.setString(3, informacion.getTelefono());
        ps.setInt(4, informacion.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM informacion WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Informacion> findAll() {
    List<Informacion> list = new ArrayList<>();
    String sql = "SELECT * FROM informacion";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Informacion(rs.getInt("id"), rs.getString("nif"), rs.getString("email"), rs.getString("telefono")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Informacion findById(int id) {
    String sql = "SELECT * FROM informacion WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Informacion(rs.getInt("id"), rs.getString("nif"), rs.getString("email"), rs.getString("telefono"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}