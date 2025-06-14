package View;

import Controller.AutoController;
import Model.Auto;
import Util.Validador;
import java.util.List;

public class AutoView {
    private AutoController controller = new AutoController();

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Autos ---");
            System.out.println("1. Listar Autos");
            System.out.println("2. Crear Auto");
            System.out.println("3. Actualizar Auto");
            System.out.println("4. Eliminar Auto");
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
        List<Auto> lista = controller.obtenerAutos();
        System.out.println("ID | Marca | Modelo | Año | Patente");
        for (Auto a : lista)
            System.out.println(a);
    }

    private void crear() {
        int id_auto = Validador.leerEntero("ID: ", 1, Integer.MAX_VALUE);
        String marca = Validador.leerTexto("Marca: ", 25);
        String modelo = Validador.leerTexto("Modelo: ", 25);
        int anio = Validador.leerEntero("Año: ", 1900, 2100);
        String patente = Validador.leerTexto("Patente (6 caracteres): ", 6);
        controller.crearAuto(id_auto, marca, modelo, anio, patente);
        System.out.println("Auto creado exitosamente.");
    }

    private void actualizar() {
        int id = Validador.leerEntero("ID de auto a actualizar: ", 1, Integer.MAX_VALUE);
        Auto a = controller.obtenerAutoPorId(id);
        if (a == null) {
            System.out.println("ERROR: Auto no encontrado.");
            return;
        }
        String marca = Validador.leerTexto("Marca (actual: " + a.getMarca() + "): ", 25);
        String modelo = Validador.leerTexto("Modelo (actual: " + a.getModelo() + "): ", 25);
        int anio = Validador.leerEntero("Año (actual: " + a.getAnio() + "): ", 1900, 2100);
        String patente = Validador.leerTexto("Patente (actual: " + a.getPatente() + "): ", 6);
        controller.actualizarAuto(id, marca, modelo, anio, patente);
        System.out.println("Auto actualizado.");
    }

    private void eliminar() {
        int id = Validador.leerEntero("ID de auto a eliminar: ", 1, Integer.MAX_VALUE);
        controller.eliminarAuto(id);
        System.out.println("Auto eliminado.");
    }
}
