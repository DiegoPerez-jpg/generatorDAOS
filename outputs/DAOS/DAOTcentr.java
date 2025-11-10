import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tcentrDAO {

public void insert(Tcentr tcentr) {
    String sql = "INSERT INTO tcentr (int(11), varchar(100), varchar(100)) VALUES (?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(01, entity.getNumce());
ps.setString(11, entity.getNomce());
ps.setString(21, entity.getSence());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Tcentr tcentr) {
    String sql = "UPDATE tcentr SET numce = ?, nomce = ?, sence = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, tcentr.getNumce());
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
            list.add(new Tcentr(rs.getInt("numce"), rs.getString("nomce"), rs.getString("sence")));
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


}