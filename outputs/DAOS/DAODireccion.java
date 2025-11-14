import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class direccionDAO {

public void insert(Direccion direccion) {
    String sql = "INSERT INTO direccion (direccion, codigopostal, ciudad, provincia, pais, etiqueta) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, entity.getDireccion());
ps.setString(2, entity.getCodigopostal());
ps.setString(3, entity.getCiudad());
ps.setString(4, entity.getProvincia());
ps.setString(5, entity.getPais());
ps.setString(6, entity.getEtiqueta());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Direccion direccion) {
    String sql = "UPDATE direccion SET direccion = ?, codigopostal = ?, ciudad = ?, provincia = ?, pais = ?, etiqueta = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, direccion.getDireccion());
        ps.setString(2, direccion.getCodigopostal());
        ps.setString(3, direccion.getCiudad());
        ps.setString(4, direccion.getProvincia());
        ps.setString(5, direccion.getPais());
        ps.setString(6, direccion.getEtiqueta());
        ps.setInt(7, direccion.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM direccion WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Direccion> findAll() {
    List<Direccion> list = new ArrayList<>();
    String sql = "SELECT * FROM direccion";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Direccion(rs.getInt("id"), rs.getString("direccion"), rs.getString("codigopostal"), rs.getString("ciudad"), rs.getString("provincia"), rs.getString("pais"), rs.getString("etiqueta")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Direccion findById(int id) {
    String sql = "SELECT * FROM direccion WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Direccion(rs.getInt("id"), rs.getString("direccion"), rs.getString("codigopostal"), rs.getString("ciudad"), rs.getString("provincia"), rs.getString("pais"), rs.getString("etiqueta"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}