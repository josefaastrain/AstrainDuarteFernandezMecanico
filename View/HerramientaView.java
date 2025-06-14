package View;

import Model.Herramienta;
import Util.Validador;

import java.util.*;

public class HerramientaView {

    Validador validador;

    public void mostrarMenu() {
        System.out.println("Menu de Herramientas");
        System.out.println("1.- Añadir Herramienta");        // Create
        System.out.println("2.- Listar Herramientas");       // Read
        System.out.println("3.- Actualizar Herramienta");    // Update
        System.out.println("4.- Eliminar Herramienta");     // Delete
        System.out.println("5.- Salir al menu principal");
        System.out.println("Indique una opción:");
    }

    public void mostrarEquipos(List<Herramienta> tools) { //Read
        if (tools.isEmpty()) {
            System.out.println("No hay herramientas");
        } else {
            tools.forEach(System.out::println);
        }
    }

    public Herramienta leerNuevaHerramienta() { //Create
        System.out.println("Nombre: ");
        String nombre;
        nombre = validador.validarString(25);

        System.out.println("Tipo: ");
        String tipo;
        tipo = validador.validarString(25);

        //Leer Estado
        String estado;
        estado = leerEstadoHerramienta();


        Herramienta tool = new Herramienta();
        tool.setNombre(nombre);
        tool.setTipo(tipo);
        tool.setEstado(estado);

        return tool;
    }

    public Herramienta leerHerramientaActualizada(List<Herramienta> tools){

       if (tools.isEmpty()) {
           System.out.println("No hay herramientas para actualizar");
           return null;
       }

       int id;
       boolean existe = false;

       do {
           System.out.println("Ingrese el ID de la herramienta a actualizar: ");
           id = validador.validarInt(99);
           for (Herramienta h : tools){
               if (h.getId_herramienta() == id) {
                   existe = true;
                   break;
               }
           }

           if (!existe) {
               System.out.println(" ID no encotrado. Ingrese un ID valido.");
           }
       } while (!existe);

       Herramienta tool = leerNuevaHerramienta();
       tool.setId_herramienta(id);
        return tool;
    }

    public int leerIdEliminar(List<Herramienta> tools) {
       int id;
       boolean existe = false;

       if (tools.isEmpty()) {
           System.out.println("No hay herramientas para eliminar");
           return -1;
       }

       do {
           System.out.println("Ingrese el ID a eliminar");
           id = validador.validarInt(99);

           for (Herramienta h : tools){ // Verifica si el ID existe
               if (h.getId_herramienta() == id) {
                   existe = true;
                   break;
               }
           }
           if (!existe) {
               System.out.println("ID no encotrado. Ingrese un id valido");
           }

       } while (!existe);

        return id;
    }


    public String leerEstadoHerramienta() {
        String estado;
        do {
            System.out.println("Estado");
            System.out.println("Ingrese la opción:");
            System.out.println("a.- Disponible");
            System.out.println("b.- En uso");

            estado = validador.validarString(1);
            if (estado.equalsIgnoreCase("a")) {
                return "Disponible";
            } else if (estado.equalsIgnoreCase("b")) {
                return "En uso";
            } else {
                System.out.println("Valor no válido. Intente de nuevo.");
            }
        } while (true);
    }


}
