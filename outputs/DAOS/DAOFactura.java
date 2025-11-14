import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class facturaDAO {

public void insert(Factura factura) {
    String sql = "INSERT INTO factura (fk_id_empresa, numero, fecha_emision, concepto, base_imponible, iva_total, total_factura, estado, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, entity.getFk_id_empresa());
ps.setString(2, entity.getNumero());
ps.setLocalDate(3, entity.getFecha_emision());
ps.setString(4, entity.getConcepto());
ps.setDouble(5, entity.getBase_imponible());
ps.setDouble(6, entity.getIva_total());
ps.setDouble(7, entity.getTotal_factura());
ps.setString(8, entity.getEstado());
ps.setString(9, entity.getObservaciones());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Factura factura) {
    String sql = "UPDATE factura SET fk_id_empresa = ?, numero = ?, fecha_emision = ?, concepto = ?, base_imponible = ?, iva_total = ?, total_factura = ?, estado = ?, observaciones = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, factura.getFk_id_empresa());
        ps.setString(2, factura.getNumero());
        ps.setLocalDate(3, factura.getFecha_emision());
        ps.setString(4, factura.getConcepto());
        ps.setDouble(5, factura.getBase_imponible());
        ps.setDouble(6, factura.getIva_total());
        ps.setDouble(7, factura.getTotal_factura());
        ps.setString(8, factura.getEstado());
        ps.setString(9, factura.getObservaciones());
        ps.setInt(10, factura.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM factura WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Factura> findAll() {
    List<Factura> list = new ArrayList<>();
    String sql = "SELECT * FROM factura";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Factura(rs.getInt("id"), rs.getInt("fk_id_empresa"), rs.getString("numero"), rs.getLocalDate("fecha_emision"), rs.getString("concepto"), rs.getDouble("base_imponible"), rs.getDouble("iva_total"), rs.getDouble("total_factura"), rs.getString("estado"), rs.getString("observaciones")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Factura findById(int id) {
    String sql = "SELECT * FROM factura WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Factura(rs.getInt("id"), rs.getInt("fk_id_empresa"), rs.getString("numero"), rs.getLocalDate("fecha_emision"), rs.getString("concepto"), rs.getDouble("base_imponible"), rs.getDouble("iva_total"), rs.getDouble("total_factura"), rs.getString("estado"), rs.getString("observaciones"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}