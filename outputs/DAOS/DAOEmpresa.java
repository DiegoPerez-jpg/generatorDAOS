import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class empresaDAO {

public Empresa insert(Empresa entity) {
    String sql = "INSERT INTO empresa (nombre, web, domiciliofiscal, contacto, fk_id_direccion, fk_id_informacion) VALUES (?, ?, ?, ?, ?, ?)";
long idGenerado = -1;
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setString(1, entity.getNombre());
ps.setString(2, entity.getWeb());
ps.setString(3, entity.getDomiciliofiscal());
ps.setString(4, entity.getContacto());
ps.setInt(5, entity.getFk_id_direccion());
ps.setInt(6, entity.getFk_id_informacion());        ps.executeUpdate();
try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
            idGenerado = rs.getLong(1);
        }
    }entity.setId(idGenerado)        return entity;    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


public void update(Empresa empresa) {
    String sql = "UPDATE empresa SET nombre = ?, web = ?, domiciliofiscal = ?, contacto = ?, fk_id_direccion = ?, fk_id_informacion = ? WHERE id = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, empresa.getNombre());
        ps.setString(2, empresa.getWeb());
        ps.setString(3, empresa.getDomiciliofiscal());
        ps.setString(4, empresa.getContacto());
        ps.setInt(5, empresa.getFk_id_direccion());
        ps.setInt(6, empresa.getFk_id_informacion());
        ps.setInt(7, empresa.getId());
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
            list.add(new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("web"), rs.getString("domiciliofiscal"), rs.getString("contacto"), rs.getInt("fk_id_direccion"), rs.getInt("fk_id_informacion")));
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
            return new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("web"), rs.getString("domiciliofiscal"), rs.getString("contacto"), rs.getInt("fk_id_direccion"), rs.getInt("fk_id_informacion"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


}