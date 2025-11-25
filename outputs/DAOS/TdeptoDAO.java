import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TdeptoDAO {

public Tdepto insert(Tdepto entity) {
    String sql = "INSERT INTO tdepto (numce, direc, tidir, presu, depde, nomde) VALUES (?, ?, ?, ?, ?, ?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setInteger(1, entity.getNumce());
ps.setInteger(2, entity.getDirec());
ps.setString(3, entity.getTidir());
ps.setDouble(4, entity.getPresu());
ps.setInteger(5, entity.getDepde());
ps.setString(6, entity.getNomde());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado);        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Tdepto tdepto) {
    String sql = "UPDATE tdepto SET numde = ?, numce = ?, direc = ?, tidir = ?, presu = ?, depde = ?, nomde = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInteger(1, tdepto.getNumde());
        ps.setInteger(2, tdepto.getNumce());
        ps.setInteger(3, tdepto.getDirec());
        ps.setString(4, tdepto.getTidir());
        ps.setDouble(5, tdepto.getPresu());
        ps.setInteger(6, tdepto.getDepde());
        ps.setString(7, tdepto.getNomde());
        ps.setInt(8, tdepto.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM tdepto WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Tdepto> findAll() {
    List<Tdepto> list = new ArrayList<>();
    String sql = "SELECT * FROM tdepto";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Tdepto(rs.getInteger("numde"), rs.getInteger("numce"), rs.getInteger("direc"), rs.getString("tidir"), rs.getDouble("presu"), rs.getInteger("depde"), rs.getString("nomde")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Tdepto findById(int id) {
    String sql = "SELECT * FROM tdepto WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Tdepto(rs.getInt("numde"), rs.getInt("numce"), rs.getInt("direc"), rs.getString("tidir"), rs.getDouble("presu"), rs.getInt("depde"), rs.getString("nomde"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


public PreparedStatement setupParameters( PreparedStatement ps,List<Object> valores,Integer numde, Integer numce, Integer direc, String tidir, Double presu, Integer depde, String nomde){
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


public String getFindByAllSql(List<Object> valores,Integer numde, Integer numce, Integer direc, String tidir, Double presu, Integer depde, String nomde){String baseSql = "SELECT * FROM tdepto";
        List<String> condiciones = new ArrayList<>();
   if (numde != null) {
            condiciones.add("numde = ?");
            valores.add(numde);
        }
   if (numce != null) {
            condiciones.add("numce = ?");
            valores.add(numce);
        }
   if (direc != null) {
            condiciones.add("direc = ?");
            valores.add(direc);
        }
   if (tidir != null) {
            condiciones.add("tidir = ?");
            valores.add(tidir);
        }
   if (presu != null) {
            condiciones.add("presu = ?");
            valores.add(presu);
        }
   if (depde != null) {
            condiciones.add("depde = ?");
            valores.add(depde);
        }
   if (nomde != null) {
            condiciones.add("nomde = ?");
            valores.add(nomde);
        }
String sql = baseSql + " WHERE " + String.join(" AND ", condiciones);
return sql;
}



public List<Tdepto> findByAll(Integer numde, Integer numce, Integer direc, String tidir, Double presu, Integer depde, String nomde) {
        List<Object> valores = new ArrayList<>();        List<Tdepto> lista = new ArrayList<>();
try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(getFindByAllSql(valores,tdeptoDAO,tdeptoDAO,tdeptoDAO,tdeptoDAO,tdeptoDAO,tdeptoDAO,tdeptoDAO))) {

ps = setupParameters(ps,valores, tdeptoDAO,tdeptoDAO,tdeptoDAO,tdeptoDAO,tdeptoDAO,tdeptoDAO,tdeptoDAO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Tdepto(rs.getInt("numde"), rs.getInt("numce"), rs.getInt("direc"), rs.getString("tidir"), rs.getDouble("presu"), rs.getInt("depde"), rs.getString("nomde")
));
}
} catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}