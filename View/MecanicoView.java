package View;

import Controller.MecanicoController;
import Model.Mecanico;
import Util.Validador;
import java.util.List;

public class MecanicoView {
    private MecanicoController controller = new MecanicoController();

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Mecánicos ---");
            System.out.println("1. Listar Mecánicos");
            System.out.println("2. Crear Mecánico");
            System.out.println("3. Actualizar Mecánico");
            System.out.println("4. Eliminar Mecánico");
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
        List<Mecanico> lista = controller.obtenerMecanicos();
        System.out.println("ID | Nombre | Especialidad | Años de Experiencia");
        for (Mecanico m : lista)
            System.out.println(m);
    }

    private void crear() {
        int id_mecanico = Validador.leerEntero("ID: ", 1, Integer.MAX_VALUE);
        String nombre = Validador.leerTexto("Nombre: ", 25);
        String especialidad = Validador.leerTexto("Especialidad: ", 25);
        int anios = Validador.leerEntero("Años de experiencia: ", 0, 99);
        controller.crearMecanico(id_mecanico, nombre, especialidad, anios);
        System.out.println("Mecánico creado exitosamente.");
    }

    private void actualizar() {
        int id = Validador.leerEntero("ID de mecánico a actualizar: ", 1, Integer.MAX_VALUE);
        Mecanico m = controller.obtenerMecanicoPorId(id);
        if (m == null) {
            System.out.println("ERROR: Mecánico no encontrado.");
            return;
        }
        String nombre = Validador.leerTexto("Nombre (actual: " + m.getNombre() + "): ", 25);
        String especialidad = Validador.leerTexto("Especialidad (actual: " + m.getEspecialidad() + "): ", 25);
        int anios = Validador.leerEntero("Años de experiencia (actual: " + m.getAnios_experiencia() + "): ", 0, 99);
        controller.actualizarMecanico(id, nombre, especialidad, anios);
        System.out.println("Mecánico actualizado.");
    }

    private void eliminar() {
        int id = Validador.leerEntero("ID de mecánico a eliminar: ", 1, Integer.MAX_VALUE);
        controller.eliminarMecanico(id);
        System.out.println("Mecánico eliminado.");
    }
}
