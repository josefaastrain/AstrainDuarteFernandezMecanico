package View;

import Model.Auto;
import Util.Validador;
import java.util.*;

public class AutoView {
    Validador validador = new Validador();

    public void mostrarMenu() {
        System.out.println("🚗💨 Menu de Autos 🚗💨");
        System.out.println("1.- Crear Auto ➕ ");        // Create
        System.out.println("2.- Listar Auto 📋 ");       // Read
        System.out.println("3.- Actualizar Auto ✏️ ");   // Update
        System.out.println("4.- Eliminar Auto 🗑️ ");     // Delete
        System.out.println("5.- Salir al menu principal 🔙 ");
        System.out.println("👉 Indique una opción:");
    }

    public void mostrarAutos(List<Auto> autos) {
        if (autos.isEmpty()) {
            System.out.println("⚠️ No hay autos registrados 😿");
        } else {
            System.out.println("\n📋 Lista de Autos:");
            autos.forEach(a -> System.out.println("🔹 " + a));
        }
    }

    public Auto leerNuevoAuto() {
        System.out.println("\n🆕 Nuevo Auto");
        System.out.println("🏷️ Marca™️: ");
        String marca;
        marca = validador.validarString(25);

        System.out.println("🏎️💨 Modelo: ");
        String modelo;
        modelo = validador.validarString(25);

        System.out.println("📅 Año: ");
        int anio;
        anio = validador.validarAnio();

        System.out.println("📄 Patente: ");
        String patente;
        patente = validador.validarStringExacto( 6);

        Auto autito = new Auto();
        autito.setMarca(marca);
        autito.setModelo(modelo);
        autito.setAnio(anio);
        autito.setPatente(patente);

        return autito;
    }

    public Auto leerAutoActualizado(List<Auto> autos) {

        if (autos.isEmpty()) {
            System.out.println("⚠️ No hay autos para actualizar");
            return null;
        }

        int id;
        boolean existe = false;

        do {
            System.out.println("✏️ Ingrese el ID del auto a actualizar");
            id = validador.validarInt(99);

            for (Auto a : autos) {
                if (a.getId_auto() == id) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                System.out.println("❌ ERROR: ID no encontrado. Ingrese un ID valido");
            }

        } while (!existe);


        Auto autito = leerNuevoAuto();
        autito.setId_auto(id);
        return autito;
    }

    public int leerIdEliminar(List<Auto> autos) {
        int id;
        boolean existe = false;

        if (autos.isEmpty()) {
            System.out.println("⚠️ No hay autos para eliminar");
            return -1;
        }

        do{
            System.out.println("🗑️ Ingrese el ID a eliminar");
            id = validador.validarInt(99);

            for (Auto a: autos){ // Verifica si el ID existe
                if (a.getId_auto() == id){
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                System.out.println("❌ ERROR: ID no encontrado. Ingrese un id valido");
            }

        }while (!existe);

        return id;
    }

}
