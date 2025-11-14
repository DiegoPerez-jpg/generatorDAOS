import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clienteDAO {

public void insert(Cliente cliente) {
    String sql = "INSERT INTO cliente (fk_id_entidad) VALUES (?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, entity.getFk_id_entidad());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Cliente cliente) {
    String sql = "UPDATE cliente SET fk_id_entidad = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, cliente.getFk_id_entidad());
        ps.setInt(2, cliente.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM cliente WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Cliente> findAll() {
    List<Cliente> list = new ArrayList<>();
    String sql = "SELECT * FROM cliente";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Cliente(rs.getInt("id"), rs.getInt("fk_id_entidad")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Cliente findById(int id) {
    String sql = "SELECT * FROM cliente WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Cliente(rs.getInt("id"), rs.getInt("fk_id_entidad"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}