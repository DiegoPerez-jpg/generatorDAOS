import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class templeDAO {

public void insert(Temple temple) {
    String sql = "INSERT INTO temple (int(11), int(11), int(11), date, date, decimal(10,2), decimal(10,2), int(11), varchar(50)) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(01, entity.getNumem());
ps.setInt(11, entity.getNumde());
ps.setInt(21, entity.getExtel());
ps.setLocalDate(31, entity.getFecna());
ps.setLocalDate(41, entity.getFecin());
ps.setDouble(51, entity.getSalar());
ps.setDouble(61, entity.getComis());
ps.setInt(71, entity.getNumhi());
ps.setString(81, entity.getNomem());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Temple temple) {
    String sql = "UPDATE temple SET numem = ?, numde = ?, extel = ?, fecna = ?, fecin = ?, salar = ?, comis = ?, numhi = ?, nomem = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, temple.getNumem());
        ps.setInt(2, temple.getNumde());
        ps.setInt(3, temple.getExtel());
        ps.setLocalDate(4, temple.getFecna());
        ps.setLocalDate(5, temple.getFecin());
        ps.setDouble(6, temple.getSalar());
        ps.setDouble(7, temple.getComis());
        ps.setInt(8, temple.getNumhi());
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
            list.add(new Temple(rs.getInt("numem"), rs.getInt("numde"), rs.getInt("extel"), rs.getLocalDate("fecna"), rs.getLocalDate("fecin"), rs.getDouble("salar"), rs.getDouble("comis"), rs.getInt("numhi"), rs.getString("nomem")));
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


}