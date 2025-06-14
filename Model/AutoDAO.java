import Model.Auto;
import java.sql.*;
import java.util.*;

public class AutoDAO {
    public AutoDAO() {
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS autos (" +
                    "id_auto INT AUTO_INCREMENT PRIMARY KEY," +
                    "marca VARCHAR(25)," +
                    "modelo VARCHAR(25)," +
                    "anio INT," +
                    "patente VARCHAR(6))");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void insertar(Auto auto) {
        String sql = "INSERT INTO autos (marca, modelo, anio, patente) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, auto.getMarca());
            ps.setString(2, auto.getModelo());
            ps.setInt(3, auto.getAnio());
            ps.setString(4, auto.getPatente());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Auto> listar() {
        List<Auto> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM autos")) {
            while (rs.next()) {
                lista.add(new Auto(
                        rs.getInt("id_auto"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getString("patente")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public Auto buscarPorId(int id) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM autos WHERE id_auto=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    return new Auto(rs.getInt("id_auto"), rs.getString("marca"),
                            rs.getString("modelo"), rs.getInt("anio"), rs.getString("patente"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void actualizar(Auto auto) {
        String sql = "UPDATE autos SET marca=?, modelo=?, anio=?, patente=? WHERE id_auto=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, auto.getMarca());
            ps.setString(2, auto.getModelo());
            ps.setInt(3, auto.getAnio());
            ps.setString(4, auto.getPatente());
            ps.setInt(5, auto.getIdAuto());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void eliminar(int id) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM autos WHERE id_auto=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
