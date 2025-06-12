package Controller;

import DAO.ClienteDAO;
import Model.Cliente;
import java.util.List;

public class ClienteController {
    private ClienteDAO dao;

    public ClienteController() {
        this.dao = new ClienteDAO();
    }

    public void crearCliente(String nombre, String rut, String telefono) {
        dao.insertar(new Cliente(nombre, rut, telefono));
    }
    public List<Cliente> obtenerClientes() {
        return dao.listar();
    }
    public Cliente obtenerClientePorId(int id) {
        return dao.buscarPorId(id);
    }
    public void actualizarCliente(int id, String nombre, String rut, String telefono) {
        dao.actualizar(new Cliente(id, nombre, rut, telefono));
    }
    public void eliminarCliente(int id) {
        dao.eliminar(id);
    }
}
