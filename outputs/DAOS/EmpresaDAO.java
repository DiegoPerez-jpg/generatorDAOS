import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

public Empresa insert(Empresa entity) {
    String sql = "INSERT INTO empresa (codigo, nombre, web, fk_id_direccion, fk_id_informacion) VALUES (?, ?, ?, ?, ?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setInteger(1, entity.getCodigo());
ps.setString(2, entity.getNombre());
ps.setString(3, entity.getWeb());
ps.setInteger(4, entity.getFk_id_direccion());
ps.setInteger(5, entity.getFk_id_informacion());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado);        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Empresa empresa) {
    String sql = "UPDATE empresa SET codigo = ?, nombre = ?, web = ?, fk_id_direccion = ?, fk_id_informacion = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInteger(1, empresa.getCodigo());
        ps.setString(2, empresa.getNombre());
        ps.setString(3, empresa.getWeb());
        ps.setInteger(4, empresa.getFk_id_direccion());
        ps.setInteger(5, empresa.getFk_id_informacion());
        ps.setInt(6, empresa.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM empresa WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Empresa> findAll() {
    List<Empresa> list = new ArrayList<>();
    String sql = "SELECT * FROM empresa";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Empresa(rs.getInteger("id"), rs.getInteger("codigo"), rs.getString("nombre"), rs.getString("web"), rs.getInteger("fk_id_direccion"), rs.getInteger("fk_id_informacion")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Empresa findById(int id) {
    String sql = "SELECT * FROM empresa WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Empresa(rs.getInt("id"), rs.getInt("codigo"), rs.getString("nombre"), rs.getString("web"), rs.getInt("fk_id_direccion"), rs.getInt("fk_id_informacion"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


public List<Empresa> findByAll(Integer id, Integer codigo, String nombre, String web, Integer fk_id_direccion, Integer fk_id_informacion) {
String baseSql = "SELECT * FROM empresa";
        List<String> condiciones = new ArrayList<>();
        List<Object> valores = new ArrayList<>();   if (id != null) {
            condiciones.add("id = ?");
            valores.add(id);
        }
   if (codigo != null) {
            condiciones.add("codigo = ?");
            valores.add(codigo);
        }
   if (nombre != null) {
            condiciones.add("nombre = ?");
            valores.add(nombre);
        }
   if (web != null) {
            condiciones.add("web = ?");
            valores.add(web);
        }
   if (fk_id_direccion != null) {
            condiciones.add("fk_id_direccion = ?");
            valores.add(fk_id_direccion);
        }
   if (fk_id_informacion != null) {
            condiciones.add("fk_id_informacion = ?");
            valores.add(fk_id_informacion);
        }
if (condiciones.isEmpty()) {
            return new ArrayList<>();
        }
String sql = baseSql + " WHERE " + String.join(" AND ", condiciones);
        List<Empresa> lista = new ArrayList<>();
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
                lista.add(new Empresa(rs.getInt("id"), rs.getInt("codigo"), rs.getString("nombre"), rs.getString("web"), rs.getInt("fk_id_direccion"), rs.getInt("fk_id_informacion")
));
}
} catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}