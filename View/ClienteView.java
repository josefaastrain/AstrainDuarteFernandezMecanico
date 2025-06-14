package View;

import Controller.ClienteController;
import Model.Cliente;
import Util.Validador;
import java.util.List;

public class ClienteView {
    private ClienteController controller = new ClienteController();

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Crear Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Volver al menú principal");
            int opcion = Validador.leerEntero("Seleccione una opción: ", 1, 5);

            switch (opcion) {
                case 1: listar(); break;
                case 2: crear(); break;
                case 3: actualizar(); break;
                case 4: eliminar(); break;
                case 5: return;
            }
        }
    }

    private void listar() {
        List<Cliente> lista = controller.obtenerClientes();
        System.out.println("ID | Nombre | RUT | Teléfono");
        for (Cliente c : lista)
            System.out.println(c);
    }

    private void crear() {
        int id_cliente = Validador.leerEntero("ID: ", 1, Integer.MAX_VALUE);
        String nombre = Validador.leerTexto("Nombre: ", 25);
        String rut = Validador.leerTexto("RUT: ", 25);
        String telefono = Validador.leerTexto("Teléfono: ", 25);
        controller.crearCliente(id_cliente, nombre, rut, telefono);
        System.out.println("Cliente creado exitosamente.");
    }

    private void actualizar() {
        int id = Validador.leerEntero("ID de cliente a actualizar: ", 1, Integer.MAX_VALUE);
        Cliente c = controller.obtenerClientePorId(id);
        if (c == null) {
            System.out.println("ERROR: Cliente no encontrado.");
            return;
        }
        String nombre = Validador.leerTexto("Nombre (actual: " + c.getNombre() + "): ", 25);
        String rut = Validador.leerTexto("RUT (actual: " + c.getRut() + "): ", 25);
        String telefono = Validador.leerTexto("Teléfono (actual: " + c.getTelefono() + "): ", 25);
        controller.actualizarCliente(id, nombre, rut, telefono);
        System.out.println("Cliente actualizado.");
    }

    private void eliminar() {
        int id = Validador.leerEntero("ID de cliente a eliminar: ", 1, Integer.MAX_VALUE);
        controller.eliminarCliente(id);
        System.out.println("Cliente eliminado.");
    }
}
