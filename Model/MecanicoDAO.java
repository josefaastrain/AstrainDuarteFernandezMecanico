package Model;

import Model.Mecanico;
import java.sql.*;
import java.util.*;

public class MecanicoDAO {
    public MecanicoDAO() {
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS mecanicos (" +
                    "id_mecanico INT AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(25)," +
                    "especialidad VARCHAR(25)," +
                    "anios_experiencia INT)");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void insertar(Mecanico mecanico) {
        String sql = "INSERT INTO mecanicos (nombre, especialidad, anios_experiencia) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mecanico.getNombre());
            ps.setString(2, mecanico.getEspecialidad());
            ps.setInt(3, mecanico.getAnios_experiencia());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Mecanico> listar() {
        List<Mecanico> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM mecanicos")) {
            while (rs.next()) {
                lista.add(new Mecanico(
                        rs.getInt("id_mecanico"),
                        rs.getString("nombre"),
                        rs.getString("especialidad"),
                        rs.getInt("anios_experiencia")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public Mecanico buscarPorId(int id) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM mecanicos WHERE id_mecanico=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    return new Mecanico(rs.getInt("id_mecanico"), rs.getString("nombre"),
                            rs.getString("especialidad"), rs.getInt("anios_experiencia"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void actualizar(Mecanico mecanico) {
        String sql = "UPDATE mecanicos SET nombre=?, especialidad=?, anios_experiencia=? WHERE id_mecanico=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mecanico.getNombre());
            ps.setString(2, mecanico.getEspecialidad());
            ps.setInt(3, mecanico.getAnios_experiencia());
            ps.setInt(4, mecanico.getId_mecanico());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void eliminar(int id) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM mecanicos WHERE id_mecanico=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
