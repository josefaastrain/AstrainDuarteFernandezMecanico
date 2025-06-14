package Model;

import java.sql.*;
import java.util.*;

public class ClienteDAO { // Inicio

    private Connection connection;

    public ClienteDAO(){ //Conexion a bdd
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientes", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearCliente(Cliente cliente) { // Create
        String sql = "INSERT INTO clientes (nombre, rut, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getRut());
            stmt.setString(3, cliente.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Cliente> obtenerTodo() { // Read
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT FROM clientes";

        try(Statement stmt = connection.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sql);
            while (resultado.next()){
                clientes.add(new Cliente(resultado.getInt("id_cliente"),
                        resultado.getString("nombre"),
                        resultado.getString("rut"),
                        resultado.getString("telefono")
                ));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void actualizarCliente(Cliente cliente) { // Update

        String sql = "UPDATE clientes SET nombre = ?, rut = ?, telefono = ? WHERE id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getRut());
            stmt.setString(3, cliente.getTelefono());
            stmt.setInt(4, cliente.getId_cliente());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void eliminarCliente(int id){ // Delete

        String sql = "DELETE FROM clientes WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

} // Final
