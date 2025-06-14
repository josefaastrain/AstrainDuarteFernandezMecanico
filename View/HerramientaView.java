package View;

import Controller.HerramientaController;
import Model.Herramienta;
import Util.Validador;
import java.util.List;

public class HerramientaView {
    private HerramientaController controller = new HerramientaController();

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Herramientas ---");
            System.out.println("1. Listar Herramientas");
            System.out.println("2. Crear Herramienta");
            System.out.println("3. Actualizar Herramienta");
            System.out.println("4. Eliminar Herramienta");
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
        List<Herramienta> lista = controller.obtenerHerramientas();
        System.out.println("ID | Nombre | Tipo | Estado");
        for (Herramienta h : lista)
            System.out.println(h);
    }

    private void crear() {
        int id_herramienta = Validador.leerEntero("ID: ", 1900, 2100);
        String nombre = Validador.leerTexto("Nombre: ", 25);
        String tipo = Validador.leerTexto("Tipo: ", 25);
        String estado;
        while (true) {
            estado = Validador.leerTexto("Estado (disponible/en uso): ", 25).toLowerCase();
            if (estado.equals("disponible") || estado.equals("en uso")) break;
            System.out.println("Estado inválido. Solo 'disponible' o 'en uso'.");
        }
        controller.crearHerramienta(id_herramienta, nombre, tipo, estado);
        System.out.println("Herramienta creada exitosamente.");
    }

    private void actualizar() {
        int id = Validador.leerEntero("ID de herramienta a actualizar: ", 1, Integer.MAX_VALUE);
        Herramienta h = controller.obtenerHerramientaPorId(id);
        if (h == null) {
            System.out.println("Herramienta no encontrada.");
            return;
        }
        String nombre = Validador.leerTexto("Nombre (actual: " + h.getNombre() + "): ", 25);
        String tipo = Validador.leerTexto("Tipo (actual: " + h.getTipo() + "): ", 25);
        String estado;
        while (true) {
            estado = Validador.leerTexto("Estado (actual: " + h.getEstado() + ") (disponible/en uso): ", 25).toLowerCase();
            if (estado.equals("disponible") || estado.equals("en uso"))
                break;
            System.out.println("Estado inválido. Solo 'disponible' o 'en uso'.");
        }
        controller.actualizarHerramienta(id, nombre, tipo, estado);
        System.out.println("Herramienta actualizada.");
    }

    private void eliminar() {
        int id = Validador.leerEntero("ID de herramienta a eliminar: ", 1, Integer.MAX_VALUE);
        controller.eliminarHerramienta(id);
        System.out.println("Herramienta eliminada.");
    }
}
