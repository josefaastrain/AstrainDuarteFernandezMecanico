package View;

import Model.Cliente;
import java.util.*;

public class ClienteView {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("Menu de Clientes");
        System.out.println("1.- Añadir Cliente");        // Create
        System.out.println("2.- Listar Clientes");       // Read
        System.out.println("3.- Actualizar Cliente");    // Update
        System.out.println("4.- Eliminar Cliente");     // Delete
        System.out.println("5.- Salir al menu principal");
        System.out.println("Indique una opción:");
    }

    public void mostrarClientes(List<Cliente> clientes){

        if (clientes.isEmpty()) {
            System.out.println("No hay Clientes");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    public Cliente leerNuevoCliente(){
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Rut:");
        String rut = sc.nextLine();
        System.out.println("Telefono:");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setRut(rut);
        cliente.setTelefono(telefono);

        return cliente;
    }

    public Cliente leerClienteActualizado() {
        System.out.println("Ingrese el ID del equipo a actualizar");
        int id = Integer.parseInt(sc.nextLine());
        Cliente cliente = leerNuevoCliente();
        cliente.setId_Cliente(id);
        return cliente;
    }

    public int leerIdEliminar(){
        System.out.println("Indique el ID a eliminar:");
        return Integer.parseInt(sc.nextLine());
    }

    public int leerOpcion() {
        return Integer.parseInt(sc.nextLine());
    }

}
