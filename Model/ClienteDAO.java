import Model.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDAO {
    public ClienteDAO() {
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS clientes (" +
                    "id_cliente INT AUTO_INCREMENT PRIMARY KEY," +
                    "nombre VARCHAR(25)," +
                    "rut VARCHAR(25)," +
                    "telefono VARCHAR(25))");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, rut, telefono) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getRut());
            ps.setString(3, cliente.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM clientes")) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("rut"),
                        rs.getString("telefono")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public Cliente buscarPorId(int id) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM clientes WHERE id_cliente=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    return new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"),
                            rs.getString("rut"), rs.getString("telefono"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre=?, rut=?, telefono=? WHERE id_cliente=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getRut());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, cliente.getIdCliente());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void eliminar(int id) {
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM clientes WHERE id_cliente=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

}
