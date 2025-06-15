package Dao;

import Model.Herramienta;

import java.sql.*;
import java.util.*;

public class HerramientaDAO { // Inicio

    private Connection connection;

    public HerramientaDAO() { // Conexion bdd
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tallermecanico", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearHerramienta(Herramienta herramienta) { // Create

        String sql = "INSERT INTO herramientas (nombre, tipo, estado) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, herramienta.getNombre());
            stmt.setString(2, herramienta.getTipo());
            stmt.setString(3, herramienta.getEstado());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Herramienta> obtenerTodo() { // Read
        List<Herramienta> herramientas = new ArrayList<>();

        String sql = "SELECT * FROM herramientas";

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                herramientas.add(new Herramienta(resultado.getInt("id_herramienta"),
                        resultado.getString("nombre"),
                        resultado.getString("tipo"),
                        resultado.getString("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return herramientas;
    }

    public void actualizarHerramienta(Herramienta herramienta) { // Update

        String sql = "UPDATE herramientas SET nombre = ?, tipo = ?, estado = ? WHERE id_herramienta = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, herramienta.getNombre());
            stmt.setString(2, herramienta.getTipo());
            stmt.setString(3, herramienta.getEstado());
            stmt.setInt(4, herramienta.getId_herramienta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarHerramienta(int id){

        String sql = "DELETE FROM herramientas WHERE id_herramienta = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

} // Final
