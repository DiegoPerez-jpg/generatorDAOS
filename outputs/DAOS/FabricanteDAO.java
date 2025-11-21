import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FabricanteDAO {

public Fabricante insert(Fabricante entity) {
    String sql = "INSERT INTO fabricante (nombre) VALUES (?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setString(1, entity.getNombre());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado);        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Fabricante fabricante) {
    String sql = "UPDATE fabricante SET nombre = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, fabricante.getNombre());
        ps.setInt(2, fabricante.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM fabricante WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Fabricante> findAll() {
    List<Fabricante> list = new ArrayList<>();
    String sql = "SELECT * FROM fabricante";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Fabricante(rs.getInteger("id"), rs.getString("nombre")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Fabricante findById(int id) {
    String sql = "SELECT * FROM fabricante WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Fabricante(rs.getInt("id"), rs.getString("nombre"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


public List<Fabricante> findByAll(Integer id, String nombre) {
String baseSql = "SELECT * FROM fabricante";
        List<String> condiciones = new ArrayList<>();
        List<Object> valores = new ArrayList<>();   if (id != null) {
            condiciones.add("id = ?");
            valores.add(id);
        }
   if (nombre != null) {
            condiciones.add("nombre = ?");
            valores.add(nombre);
        }
if (condiciones.isEmpty()) {
            return new ArrayList<>();
        }
String sql = baseSql + " WHERE " + String.join(" AND ", condiciones);
        List<Fabricante> lista = new ArrayList<>();
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
                lista.add(new Fabricante(rs.getInt("id"), rs.getString("nombre")
));
}
} catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}