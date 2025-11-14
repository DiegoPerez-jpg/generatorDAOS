import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class proveedorDAO {

public Proveedor insert(Proveedor entity) {
    String sql = "INSERT INTO proveedor (fk_id_entidad) VALUES (?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setInt(1, entity.getFk_id_entidad());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado)        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Proveedor proveedor) {
    String sql = "UPDATE proveedor SET fk_id_entidad = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, proveedor.getFk_id_entidad());
        ps.setInt(2, proveedor.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM proveedor WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Proveedor> findAll() {
    List<Proveedor> list = new ArrayList<>();
    String sql = "SELECT * FROM proveedor";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Proveedor(rs.getInt("id"), rs.getInt("fk_id_entidad")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Proveedor findById(int id) {
    String sql = "SELECT * FROM proveedor WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Proveedor(rs.getInt("id"), rs.getInt("fk_id_entidad"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}