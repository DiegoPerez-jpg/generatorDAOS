import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class relacionfacturaDAO {

public void insert(Relacionfactura relacionfactura) {
    String sql = "INSERT INTO relacionfactura (fk_id_producto, cantidad) VALUES (?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, entity.getFk_id_producto());
ps.setDouble(2, entity.getCantidad());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Relacionfactura relacionfactura) {
    String sql = "UPDATE relacionfactura SET fk_id_factura = ?, fk_id_producto = ?, cantidad = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, relacionfactura.getFk_id_factura());
        ps.setInt(2, relacionfactura.getFk_id_producto());
        ps.setDouble(3, relacionfactura.getCantidad());
        ps.setInt(4, relacionfactura.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM relacionfactura WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Relacionfactura> findAll() {
    List<Relacionfactura> list = new ArrayList<>();
    String sql = "SELECT * FROM relacionfactura";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Relacionfactura(rs.getInt("fk_id_factura"), rs.getInt("fk_id_producto"), rs.getDouble("cantidad")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Relacionfactura findById(int id) {
    String sql = "SELECT * FROM relacionfactura WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Relacionfactura(rs.getInt("fk_id_factura"), rs.getInt("fk_id_producto"), rs.getDouble("cantidad"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}