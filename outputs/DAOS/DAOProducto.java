import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class productoDAO {

public Producto insert(Producto entity) {
    String sql = "INSERT INTO producto (codigo, descripcion, precio_coste, precio_venta, stock, fk_id_entidad, fk_id_tipoiva) VALUES (?, ?, ?, ?, ?, ?, ?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setString(1, entity.getCodigo());
ps.setString(2, entity.getDescripcion());
ps.setDouble(3, entity.getPrecio_coste());
ps.setDouble(4, entity.getPrecio_venta());
ps.setDouble(5, entity.getStock());
ps.setInt(6, entity.getFk_id_entidad());
ps.setInt(7, entity.getFk_id_tipoiva());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado)        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Producto producto) {
    String sql = "UPDATE producto SET codigo = ?, descripcion = ?, precio_coste = ?, precio_venta = ?, stock = ?, fk_id_entidad = ?, fk_id_tipoiva = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, producto.getCodigo());
        ps.setString(2, producto.getDescripcion());
        ps.setDouble(3, producto.getPrecio_coste());
        ps.setDouble(4, producto.getPrecio_venta());
        ps.setDouble(5, producto.getStock());
        ps.setInt(6, producto.getFk_id_entidad());
        ps.setInt(7, producto.getFk_id_tipoiva());
        ps.setInt(8, producto.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM producto WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Producto> findAll() {
    List<Producto> list = new ArrayList<>();
    String sql = "SELECT * FROM producto";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Producto(rs.getInt("id"), rs.getString("codigo"), rs.getString("descripcion"), rs.getDouble("precio_coste"), rs.getDouble("precio_venta"), rs.getDouble("stock"), rs.getInt("fk_id_entidad"), rs.getInt("fk_id_tipoiva")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Producto findById(int id) {
    String sql = "SELECT * FROM producto WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Producto(rs.getInt("id"), rs.getString("codigo"), rs.getString("descripcion"), rs.getDouble("precio_coste"), rs.getDouble("precio_venta"), rs.getDouble("stock"), rs.getInt("fk_id_entidad"), rs.getInt("fk_id_tipoiva"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}