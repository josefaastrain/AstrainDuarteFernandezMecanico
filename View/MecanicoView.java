package View;

import Model.Mecanico;
import Util.Validador;

import java.util.List;

public class MecanicoView { // Inicio

    Validador validador = new Validador();

    public void mostrarMenu() {
        System.out.println("\n👤🔧 𝗠𝗲𝗻𝘂́ 𝗱𝗲 𝗠𝗲𝗰𝗮́𝗻𝗶𝗰𝗼𝘀 🔧👤");
        System.out.println("1.- Añadir Mecánico ➕ ");        // Create
        System.out.println("2.- Listar Mecanicos 📋 ");       // Read
        System.out.println("3.- Actualizar Mecanicos ✏️ ");   // Update
        System.out.println("4.- Eliminar Mecanicos 🗑️ ");     // Delete
        System.out.println("5.- Salir al menu principal 🔙 ");
        System.out.println(" 👉 Indique una opción:");
    }

    public void mostrarMecanicos(List<Mecanico> mecanicos) {

        if (mecanicos.isEmpty()) {
            System.out.println("No hay Clientes");
        } else {
            mecanicos.forEach(System.out::println);
        }
    }

    public Mecanico leerNuevoMecanico() {
        System.out.println("\n🆕 Nuevo Mecánico");
        System.out.println("👤 Nombre: ");
        String nombre;
        nombre = validador.validarString(25);

        System.out.println("🔧 Especialidad: ");
        String esp;
        esp = validador.validarString(25);

        System.out.println("⏳ Años de experiencia: ");
        int exp;
        exp = validador.validarInt(2);

        Mecanico chambeador = new Mecanico();
        chambeador.setNombre(nombre);
        chambeador.setEspecialidad(esp);
        chambeador.setAnios_experiencia(exp);

        return chambeador;
    }

    public Mecanico leerMecanicoActualizado(List<Mecanico> mecanicos) {
        if (mecanicos.isEmpty()){
            System.out.println("⚠️ No hay mecanicos para actualizar.");
            return null;
        }

        int id;
        boolean existe = false;

        do {
            System.out.println("✏️ Ingrese el ID del Mecanico a actualizar");
            id = validador.validarInt(99);

            for (Mecanico m : mecanicos){
                if (m.getId_mecanico() == id) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                System.out.println("❌ ERROR: ID no encontrado. Ingrese un ID valido");
            }
        } while (!existe);

        Mecanico mecanico = leerNuevoMecanico();
        mecanico.setId_mecanico(id);
        return mecanico;
    }

    public int leerIdEliminar(List<Mecanico> mecanicos){
        int id;
        boolean existe = false;

        if (mecanicos.isEmpty()) {
            System.out.println("⚠️ No hay mecanicos para eliminar.");
            return -1;
        }

        do {
            System.out.println("🗑️ Ingrese el ID a eliminar: ");
            id = validador.validarInt(99);

            for (Mecanico m : mecanicos){
                if (m.getId_mecanico() == id ) {
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
} //Final
