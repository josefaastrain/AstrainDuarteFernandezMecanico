package Model;

import Model.Herramienta;
import java.sql.*;
import java.util.*;

public class HerramientaDAO {
    public HerramientaDAO() {
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS herramientas (" +
                    "id_herramienta INT AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(25)," +
                    "tipo VARCHAR(25)," +
                    "estado VARCHAR(25))");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void insertar(Herramienta herramienta) {
        String sql = "INSERT INTO herramientas (nombre, tipo, estado) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, herramienta.getNombre());
            ps.setString(2, herramienta.getTipo());
            ps.setString(3, herramienta.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Herramienta> listar() {
        List<Herramienta> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM herramientas")) {
            while (rs.next()) {
                lista.add(new Herramienta(
                        rs.getInt("id_herramienta"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("estado")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public Herramienta buscarPorId(int id) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM herramientas WHERE id_herramienta=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    return new Herramienta(rs.getInt("id_herramienta"), rs.getString("nombre"),
                            rs.getString("tipo"), rs.getString("estado"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void actualizar(Herramienta herramienta) {
        String sql = "UPDATE herramientas SET nombre=?, tipo=?, estado=? WHERE id_herramienta=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, herramienta.getNombre());
            ps.setString(2, herramienta.getTipo());
            ps.setString(3, herramienta.getEstado());
            ps.setInt(4, herramienta.getId_herramienta());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void eliminar(int id) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM herramientas WHERE id_herramienta=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
