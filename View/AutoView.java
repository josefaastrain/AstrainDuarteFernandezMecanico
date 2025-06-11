package View;

import Model.Auto;

import java.util.*;

public class AutoView {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("🚗💨 Menu de Autos 🚗💨");
        System.out.println("1.- Crear Auto");        // Create
        System.out.println("2.- Listar Auto");       // Read
        System.out.println("3.- Actualizar Auto");   // Update
        System.out.println("4.- Eliminar Auto");     // Delete
        System.out.println("5.- Salir al menu principal");
        System.out.println("Indique una opción:");
    }

    public void mostrarAutos(List<Auto> autos) {
        if (autos.isEmpty()) {
            System.out.println("No hay autos 😿");
        } else {
            autos.forEach(System.out::println);
        }
    }

    public Auto leerNuevoAuto() {

        System.out.println("Marca: ");
        String marca = sc.nextLine();
        marca = validarString(marca, 25);

        System.out.println("Modelo: ");
        String modelo = sc.nextLine();
        modelo = validarString(modelo, 25);

        System.out.println("Año: ");
        String anio = sc.nextLine();
        anio = validarInt(anio, 4);

        System.out.println("Patente: ");
        String patente = sc.nextLine();
        patente = validarStringExacto(patente, 6);

        Auto autito = new Auto();
        autito.setMarca(marca);
        autito.setModelo(modelo);
        autito.setAnio(Integer.parseInt(anio));
        autito.setPatente(patente);

        return autito;
    }

    public Auto leerAutoActualizado(){
        System.out.println("Ingrese el ID del equipo a actualizar: ");
        String id = sc.nextLine();
        id = validarInt(id, 2);
        Auto autito = leerNuevoAuto();
        autito.setId_Auto(Integer.parseInt(id));
        return autito;
    }

    public int leerIdEliminar() {
        System.out.println("Ingrese el ID a eliminar: ");
        String dato = sc.nextLine();
        dato = validarInt(dato, 2);
        int opcion = Integer.parseInt(dato);
        return opcion;
    }


    public String validarString(String dato, int longitud) {
        dato = dato.trim(); // Elimina espacios antes y después
        boolean valido = false;

        do {
            if (dato.isEmpty()) {
                System.out.println("El dato no puede estar vacío. Ingrese uno:");
                dato = sc.nextLine().trim();

            } else if (dato.length() > longitud) {
                System.out.println("La máxima longitud de datos es: " + longitud +
                        "\nUsted ingresó: " + dato.length() + "\nIntente de nuevo:");
                dato = sc.nextLine().trim();

            } else if (dato.matches("\\d+")) {
                System.out.println("El dato no puede ser solo numérico. Intente de nuevo:");
                dato = sc.nextLine().trim();
                // matches compara la cadena de texto con lo que se pide abajo
                // \\d significa números del 0 al 9
                // + significa uno o más dígitos seguidos
                // Si es solo números, devuelve true

            } else {
                valido = true;
            }
        } while (!valido);

        return dato;
    }

    public String validarStringExacto(String dato, int longitud) {
        do {
            dato = validarString(dato, longitud);
            if (dato.length() != longitud) {
                System.out.println("El dato debe tener exactamente " + longitud + " caracteres. Intente de nuevo:");
                dato = sc.nextLine().trim();
            }
        } while (dato.length() != longitud);

        return dato;
    }

    public String validarInt(String dato, int longitud) {
        dato = dato.trim();
        boolean valido = false;

        do {
            if (dato.isEmpty()) {
                System.out.println("El dato no puede estar vacío. Intente de nuevo:");
                dato = sc.nextLine().trim();
                continue;
            }

            if (dato.length() > longitud) {
                System.out.println("La máxima longitud permitida es: " + longitud + ". Intente de nuevo:");
                dato = sc.nextLine().trim();
                continue;
            }

            try {
                int numero = Integer.parseInt(dato);
                if (numero <= 0) {
                    System.out.println("El número debe ser positivo. Intente de nuevo:");
                    dato = sc.nextLine().trim();
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido. Intente de nuevo:");
                dato = sc.nextLine().trim();
            }
        } while (!valido);

        return dato;
    }

    public int leerOpcion() {
        String dato;
        int opcion = -1;
        boolean valido = false;

        do {
            dato = sc.nextLine().trim();

            if (dato.isEmpty()) {
                System.out.println("La opción no puede estar vacía. Intente de nuevo:");
                continue;
            }

            if (!dato.matches("\\d")) {
                System.out.println("Debe ingresar un número válido (entre 1 y 5). Intente de nuevo:");
                continue;
            }

            opcion = Integer.parseInt(dato);

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción fuera de rango. Ingrese un número entre 1 y 5:");
            } else {
                valido = true;
            }
        } while (!valido);

        return opcion;
    }


}

