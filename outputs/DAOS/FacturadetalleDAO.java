import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturadetalleDAO {

public Facturadetalle insert(Facturadetalle entity) {
    String sql = "INSERT INTO facturadetalle (fk_id_producto, cantidad, precio_unitario, total_linea) VALUES (?, ?, ?, ?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setInteger(1, entity.getFk_id_producto());
ps.setDouble(2, entity.getCantidad());
ps.setDouble(3, entity.getPrecio_unitario());
ps.setDouble(4, entity.getTotal_linea());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado);        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Facturadetalle facturadetalle) {
    String sql = "UPDATE facturadetalle SET fk_id_factura = ?, fk_id_producto = ?, cantidad = ?, precio_unitario = ?, total_linea = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInteger(1, facturadetalle.getFk_id_factura());
        ps.setInteger(2, facturadetalle.getFk_id_producto());
        ps.setDouble(3, facturadetalle.getCantidad());
        ps.setDouble(4, facturadetalle.getPrecio_unitario());
        ps.setDouble(5, facturadetalle.getTotal_linea());
        ps.setInt(6, facturadetalle.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM facturadetalle WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Facturadetalle> findAll() {
    List<Facturadetalle> list = new ArrayList<>();
    String sql = "SELECT * FROM facturadetalle";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Facturadetalle(rs.getInteger("fk_id_factura"), rs.getInteger("fk_id_producto"), rs.getDouble("cantidad"), rs.getDouble("precio_unitario"), rs.getDouble("total_linea")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Facturadetalle findById(int id) {
    String sql = "SELECT * FROM facturadetalle WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Facturadetalle(rs.getInt("fk_id_factura"), rs.getInt("fk_id_producto"), rs.getDouble("cantidad"), rs.getDouble("precio_unitario"), rs.getDouble("total_linea"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


public List<Facturadetalle> findByAll(Integer fk_id_factura, Integer fk_id_producto, Double cantidad, Double precio_unitario, Double total_linea) {
String baseSql = "SELECT * FROM facturadetalle";
        List<String> condiciones = new ArrayList<>();
        List<Object> valores = new ArrayList<>();   if (fk_id_factura != null) {
            condiciones.add("fk_id_factura = ?");
            valores.add(fk_id_factura);
        }
   if (fk_id_producto != null) {
            condiciones.add("fk_id_producto = ?");
            valores.add(fk_id_producto);
        }
   if (cantidad != null) {
            condiciones.add("cantidad = ?");
            valores.add(cantidad);
        }
   if (precio_unitario != null) {
            condiciones.add("precio_unitario = ?");
            valores.add(precio_unitario);
        }
   if (total_linea != null) {
            condiciones.add("total_linea = ?");
            valores.add(total_linea);
        }
if (condiciones.isEmpty()) {
            return new ArrayList<>();
        }
String sql = baseSql + " WHERE " + String.join(" AND ", condiciones);
        List<Facturadetalle> lista = new ArrayList<>();
try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < valores.size(); i++) {
                Object val = valores.get(i);
                if (val instanceof Integer) {
                    ps.setInt(i + 1, (Integer) val);
                } else if (val instanceof Double) {
                    ps.setDouble(i + 1, (Double) val);
                } else if (val instanceof Date) {
                    ps.setDate(i + 1, (Date) val);
                } else if (val instanceof String) {
                    ps.setString(i + 1, (String) val);
                }
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Facturadetalle(rs.getInt("fk_id_factura"), rs.getInt("fk_id_producto"), rs.getDouble("cantidad"), rs.getDouble("precio_unitario"), rs.getDouble("total_linea")
));
}
} catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}