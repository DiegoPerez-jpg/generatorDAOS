import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tdeptoDAO {

public void insert(Tdepto tdepto) {
    String sql = "INSERT INTO tdepto (int(11), int(11), int(11), char(1), decimal(10,2), int(11), varchar(100)) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(01, entity.getNumde());
ps.setInt(11, entity.getNumce());
ps.setInt(21, entity.getDirec());
ps.setString(31, entity.getTidir());
ps.setDouble(41, entity.getPresu());
ps.setInt(51, entity.getDepde());
ps.setString(61, entity.getNomde());        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void update(Tdepto tdepto) {
    String sql = "UPDATE tdepto SET numde = ?, numce = ?, direc = ?, tidir = ?, presu = ?, depde = ?, nomde = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, tdepto.getNumde());
        ps.setInt(2, tdepto.getNumce());
        ps.setInt(3, tdepto.getDirec());
        ps.setString(4, tdepto.getTidir());
        ps.setDouble(5, tdepto.getPresu());
        ps.setInt(6, tdepto.getDepde());
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
            list.add(new Tdepto(rs.getInt("numde"), rs.getInt("numce"), rs.getInt("direc"), rs.getString("tidir"), rs.getDouble("presu"), rs.getInt("depde"), rs.getString("nomde")));
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


}