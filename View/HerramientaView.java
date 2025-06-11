package View;

import Model.Herramienta;

import java.util.*;

public class HerramientaView {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("Menu de Herramientas");
        System.out.println("1.- Añadir Herramienta");        // Create
        System.out.println("2.- Listar Herramientas");       // Read
        System.out.println("3.- Actualizar Herramienta");    // Update
        System.out.println("4.- Eliminar Herramienta");     // Delete
        System.out.println("5.- Salir al menu principal");
        System.out.println("Indique una opción:");
    }

    public void mostrarEquipos(List<Herramienta> tools) {
        if (tools.isEmpty()) {
            System.out.println("No hay herramientas");
        } else {
            tools.forEach(System.out::println);
        }
    }

    public Herramienta leerNuevaHerramienta() {
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Tipo: ");
        String tipo = sc.nextLine();

        System.out.println("Estado"); // Disponible o En uso
        String estado = sc.nextLine();

        Herramienta tool = new Herramienta();
        tool.setNombre(nombre);
        tool.setTipo(tipo);
        tool.setEstado(estado);

        return tool;
    }


}
