package Dao;

import Model.Mecanico;

import java.sql.*;
import java.util.*;

public class MecanicoDAO { // Inicio


    private Connection connection;

    public MecanicoDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tallermecanico", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearMecanico(Mecanico mecanico) { //Create

        String sql = "INSERT INTO mecanicos (nombre, especialidad, aniosExp) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, mecanico.getNombre());
            stmt.setString(2, mecanico.getEspecialidad());
            stmt.setInt(3, mecanico.getAnios_experiencia());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Mecanico> obtenerTodo() { // Read

        List<Mecanico> mecanicos = new ArrayList<>();

        String sql = "SELECT * FROM mecanicos";

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                mecanicos.add(new Mecanico(resultado.getInt("id_mecanico"),
                        resultado.getString("nombre"),
                        resultado.getString("especialidad"),
                        resultado.getInt("aniosExp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mecanicos;
    }

    public void actualizarMecanico(Mecanico mecanico) { // Update

        String sql = "UPDATE mecanicos SET nombre = ?, especialidad = ?, aniosExp = ? WHERE id_mecanico = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, mecanico.getNombre());
            stmt.setString(2, mecanico.getEspecialidad());
            stmt.setInt(3, mecanico.getAnios_experiencia());
            stmt.setInt(4, mecanico.getId_mecanico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarMecanico(int id) {

        String sql = "DELETE FROM mecanicos WHERE id_mecanico = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

} // Final
