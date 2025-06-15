package Controller;

import Model.Herramienta;
import Dao.HerramientaDAO;
import View.HerramientaView;
import Util.Validador;

import java.util.*;

public class HerramientaController { // Inicio

    private HerramientaDAO dao;
    private HerramientaView view;
    public Validador validador;

    public HerramientaController(){
        dao = new HerramientaDAO();
        view = new HerramientaView();
        validador = new Validador();
    }

    public void iniciar(){

        int opcion;

        do {
            view.mostrarMenu();
            opcion = validador.validarInt(1);
            List<Herramienta> listaHerramientas = dao.obtenerTodo();

            switch (opcion) {

                case 1 -> dao.crearHerramienta(view.leerNuevaHerramienta());
                case 2 -> view.mostrarHerramientas(dao.obtenerTodo());
                case 3 -> dao.actualizarHerramienta(view.leerHerramientaActualizada(listaHerramientas));
                case 4 -> dao.eliminarHerramienta(view.leerIdEliminar(listaHerramientas));
                case 5 -> System.out.println("Adios!...");
            }
        } while (opcion != 5);
    }

} //Final
