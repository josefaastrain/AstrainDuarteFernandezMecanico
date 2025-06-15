package View;

import Model.Cliente;
import Util.Validador;
import java.util.*;

public class ClienteView {

    Validador validador = new Validador();


    public void mostrarMenu() {
        System.out.println("\n👥 𝗠𝗲𝗻𝘂́ 𝗱𝗲 𝗖𝗹𝗶𝗲𝗻𝘁𝗲𝘀 👥 ");
        System.out.println("1.- Añadir Cliente ➕ ");        // Create
        System.out.println("2.- Listar Clientes 📋 ");       // Read
        System.out.println("3.- Actualizar Cliente ✏️ ");    // Update
        System.out.println("4.- Eliminar Cliente 🗑️ ");     // Delete
        System.out.println("5.- Salir al menu principal 🔙 ");
        System.out.println("👉 Indique una opción:");
    }

    public void mostrarClientes(List<Cliente> clientes){

        if (clientes.isEmpty()) {
            System.out.println("⚠️ No hay clientes registrados.");
        } else {
            System.out.println("\n📋 Lista de Clientes:");
            clientes.forEach(c -> System.out.println("🔹 " + c));
        }
    }

    public Cliente leerNuevoCliente() {
        System.out.println("\n🆕 Nuevo Cliente");
        System.out.println("🔤 Nombre:");
        String nombre;
        nombre = validador.validarString(25);

        System.out.println("🆔 Rut:");
        String rut;
        rut = validador.validarString(25);

        System.out.println("📞 Telefono:");
        String telefono;
        telefono = validador.validarString(25);

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setRut(rut);
        cliente.setTelefono(telefono);

        return cliente;
    }

    public Cliente leerClienteActualizado(List<Cliente> clientes) {

        if (clientes.isEmpty()) {
            System.out.println("⚠️ No hay clientes para actualizar.");
            return null;
        }

        int id;
        boolean existe = false;

        do {
            System.out.println("✏️ Ingrese el ID del cliente a actualizar:");
            id = validador.validarInt(99);

            for (Cliente c : clientes) {
                if (c.getId_cliente() == id) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                System.out.println("❌ ERROR: ID no encontrado. Ingrese un ID valido.");
            }

        } while (!existe);

        Cliente cliente = leerNuevoCliente();
        cliente.setId_cliente(id);
        return cliente;
    }

    public int leerIdEliminar(List<Cliente> clientes) {
        int id;
        boolean existe = false;

        if (clientes.isEmpty()) {
            System.out.println("⚠️ No hay clientes para eliminar.");
            return -1;
        }

        do {
            System.out.println("🗑️ Ingrese el ID a eliminar:");
            id = validador.validarInt(99);

            for (Cliente c : clientes) { // Verifica si el ID existe
                if (c.getId_cliente() == id) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                System.out.println("❌ ERROR: ID no encontrado. Ingrese un ID valido.");
            }

        } while (!existe);

        return id;
    }
}
