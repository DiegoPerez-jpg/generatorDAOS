import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TempleDAO {

public Temple insert(Temple entity) {
    String sql = "INSERT INTO temple (numde, extel, fecna, fecin, salar, comis, numhi, nomem) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setInteger(1, entity.getNumde());
ps.setInteger(2, entity.getExtel());
ps.setLocalDate(3, entity.getFecna());
ps.setLocalDate(4, entity.getFecin());
ps.setDouble(5, entity.getSalar());
ps.setDouble(6, entity.getComis());
ps.setInteger(7, entity.getNumhi());
ps.setString(8, entity.getNomem());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado);        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Temple temple) {
    String sql = "UPDATE temple SET numem = ?, numde = ?, extel = ?, fecna = ?, fecin = ?, salar = ?, comis = ?, numhi = ?, nomem = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInteger(1, temple.getNumem());
        ps.setInteger(2, temple.getNumde());
        ps.setInteger(3, temple.getExtel());
        ps.setLocalDate(4, temple.getFecna());
        ps.setLocalDate(5, temple.getFecin());
        ps.setDouble(6, temple.getSalar());
        ps.setDouble(7, temple.getComis());
        ps.setInteger(8, temple.getNumhi());
        ps.setString(9, temple.getNomem());
        ps.setInt(10, temple.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int id) {
    String sql = "DELETE FROM temple WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public List<Temple> findAll() {
    List<Temple> list = new ArrayList<>();
    String sql = "SELECT * FROM temple";
    try (Connection conn = Conexion.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            list.add(new Temple(rs.getInteger("numem"), rs.getInteger("numde"), rs.getInteger("extel"), rs.getLocalDate("fecna"), rs.getLocalDate("fecin"), rs.getDouble("salar"), rs.getDouble("comis"), rs.getInteger("numhi"), rs.getString("nomem")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}


public Temple findById(int id) {
    String sql = "SELECT * FROM temple WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Temple(rs.getInt("numem"), rs.getInt("numde"), rs.getInt("extel"), rs.getLocalDate("fecna"), rs.getLocalDate("fecin"), rs.getDouble("salar"), rs.getDouble("comis"), rs.getInt("numhi"), rs.getString("nomem"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


public PreparedStatement setupParameters( PreparedStatement ps,List<Object> valores,Integer numem, Integer numde, Integer extel, LocalDate fecna, LocalDate fecin, Double salar, Double comis, Integer numhi, String nomem){
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


public String getFindByAllSql(List<Object> valores,Integer numem, Integer numde, Integer extel, LocalDate fecna, LocalDate fecin, Double salar, Double comis, Integer numhi, String nomem){String baseSql = "SELECT * FROM temple";
        List<String> condiciones = new ArrayList<>();
   if (numem != null) {
            condiciones.add("numem = ?");
            valores.add(numem);
        }
   if (numde != null) {
            condiciones.add("numde = ?");
            valores.add(numde);
        }
   if (extel != null) {
            condiciones.add("extel = ?");
            valores.add(extel);
        }
   if (fecna != null) {
            condiciones.add("fecna = ?");
            valores.add(fecna);
        }
   if (fecin != null) {
            condiciones.add("fecin = ?");
            valores.add(fecin);
        }
   if (salar != null) {
            condiciones.add("salar = ?");
            valores.add(salar);
        }
   if (comis != null) {
            condiciones.add("comis = ?");
            valores.add(comis);
        }
   if (numhi != null) {
            condiciones.add("numhi = ?");
            valores.add(numhi);
        }
   if (nomem != null) {
            condiciones.add("nomem = ?");
            valores.add(nomem);
        }
String sql = baseSql + " WHERE " + String.join(" AND ", condiciones);
return sql;
}



public List<Temple> findByAll(Integer numem, Integer numde, Integer extel, LocalDate fecna, LocalDate fecin, Double salar, Double comis, Integer numhi, String nomem) {
        List<Object> valores = new ArrayList<>();        List<Temple> lista = new ArrayList<>();
try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(getFindByAllSql(valores,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO))) {

ps = setupParameters(ps,valores, templeDAO,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO,templeDAO);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Temple(rs.getInt("numem"), rs.getInt("numde"), rs.getInt("extel"), rs.getLocalDate("fecna"), rs.getLocalDate("fecin"), rs.getDouble("salar"), rs.getDouble("comis"), rs.getInt("numhi"), rs.getString("nomem")
));
}
} catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}