import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TcentrDAO {

public Tcentr insert(Tcentr entity) {
    String sql = "INSERT INTO tcentr (nomce, sence) VALUES (?, ?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setString(1, entity.getNomce());
ps.setString(2, entity.getSence());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado);        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Tcentr tcentr) {
    String sql = "UPDATE tcentr SET numce = ?, nomce = ?, sence = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInteger(1, tcentr.getNumce());
        ps.setString(2, tcentr.getNomce());
        ps.setString(3, tcentr.getSence());
        ps.setInt(4, tcentr.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM tcentr WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Tcentr> findAll() {
    List<Tcentr> list = new ArrayList<>();
    String sql = "SELECT * FROM tcentr";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Tcentr(rs.getInteger("numce"), rs.getString("nomce"), rs.getString("sence")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Tcentr findById(int id) {
    String sql = "SELECT * FROM tcentr WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Tcentr(rs.getInt("numce"), rs.getString("nomce"), rs.getString("sence"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


public PreparedStatement setupParameters( PreparedStatement ps,List<Object> valores,Integer numce, String nomce, String sence){
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
return ps;}


public String getFindByAllSql(List<Object> valores,Integer numce, String nomce, String sence){String baseSql = "SELECT * FROM tcentr";
        List<String> condiciones = new ArrayList<>();
   if (numce != null) {
            condiciones.add("numce = ?");
            valores.add(numce);
        }
   if (nomce != null) {
            condiciones.add("nomce = ?");
            valores.add(nomce);
        }
   if (sence != null) {
            condiciones.add("sence = ?");
            valores.add(sence);
        }
String sql = baseSql + " WHERE " + String.join(" AND ", condiciones);
return sql;
}



public List<Tcentr> findByAll(Integer numce, String nomce, String sence) {
        List<Object> valores = new ArrayList<>();        List<Tcentr> lista = new ArrayList<>();
try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(getFindByAllSql(valores,tcentrDAO,tcentrDAO,tcentrDAO))) {

ps = setupParameters(ps,valores, tcentrDAO,tcentrDAO,tcentrDAO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Tcentr(rs.getInt("numce"), rs.getString("nomce"), rs.getString("sence")
));
}
} catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}