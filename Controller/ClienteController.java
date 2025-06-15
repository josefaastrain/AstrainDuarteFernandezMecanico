package Controller;

import Model.Cliente;
import Dao.ClienteDAO;
import View.ClienteView;
import Util.Validador;

import java.util.*;

public class ClienteController { // Inicio

    private ClienteDAO dao;
    private ClienteView view;
    public Validador validador;

    public ClienteController(){
        dao = new ClienteDAO();
        view = new ClienteView();
        validador = new Validador();
    }

    public void iniciar(){
        int opcion;
        do {
            view.mostrarMenu();
            opcion = validador.validarInt(1);
            List<Cliente> listaClientes = dao.obtenerTodo();

            switch (opcion) {

                case 1 -> dao.crearCliente(view.leerNuevoCliente());
                case 2 -> view.mostrarClientes(dao.obtenerTodo());
                case 3 -> dao.actualizarCliente(view.leerClienteActualizado(listaClientes));
                case 4 -> dao.eliminarCliente(view.leerIdEliminar(listaClientes));
                case 5 -> System.out.println("Adios!...");

                default -> System.out.println("Ingrese una opcion valida");

            }
        } while (opcion != 5);
    }

} // Final
