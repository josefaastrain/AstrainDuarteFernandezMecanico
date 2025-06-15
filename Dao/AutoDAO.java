package Dao;

import Model.Auto;

import java.sql.*;
import java.util.*;

public class AutoDAO { //Inicio

    private Connection connection;

    public AutoDAO(){ //Conexion a bdd
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tallermecanico", "root", "");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearAuto(Auto auto){ // Create

        String sql = "INSERT INTO autos (marca, modelo, anio, patente) VALUES (?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, auto.getMarca());
            stmt.setString(2, auto.getModelo());
            stmt.setInt(3, auto.getAnio());
            stmt.setString(4, auto.getPatente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<Auto> obtenerTodo() { //Read
        List<Auto> autos = new ArrayList<>();

        String sql = "SELECT * FROM autos";

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                autos.add(new Auto(resultado.getInt("id_auto"),
                        resultado.getString("marca"),
                        resultado.getString("modelo"),
                        resultado.getInt("anio"),
                        resultado.getString("patente")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
}

public void actualizarAuto(Auto auto){ // Update

        String sql = "UPDATE autos SET marca = ?, modelo = ?, anio = ?, patente = ? WHERE id_auto = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, auto.getMarca());
            stmt.setString(2, auto.getModelo());
            stmt.setInt(3, auto.getAnio());
            stmt.setString(4, auto.getPatente());
            stmt.setInt(5, auto.getId_auto());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
}

public void EliminarAuto(int id) { // Delete

        String sql = "DELETE FROM autos WHERE id_auto = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
}

} // Final

