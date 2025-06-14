package Controller;

import Model.HerramientaDAO;
import Model.Mecanico;
import Model.MecanicoDAO;
import View.HerramientaView;
import View.MecanicoView;
import Util.Validador;

import java.util.*;

public class MecanicoController { // Inicio

    private MecanicoDAO dao;
    private MecanicoView view;
    public Validador validador;

    public MecanicoController(){
        dao = new MecanicoDAO();
        view = new MecanicoView();
        validador = new Validador();
    }

    public void iniciar(){

        int opcion;

        do {
            view.mostrarMenu();
            opcion = validador.validarInt(1);
            List<Mecanico> listaMecanicos = dao.obtenerTodo();

            switch (opcion) {

                case 1 -> dao.crearMecanico(view.leerNuevoMecanico());
                case 2 -> view.mostrarMecanicos(dao.obtenerTodo());
                case 3 -> dao.actualizarMecanico(view.leerMecanicoActualizado(listaMecanicos));
                case 4 -> dao.eliminarMecanico(view.leerIdEliminar(listaMecanicos));
                case 5 -> System.out.println("Adios!...");

                default -> System.out.println("Ingrese una opcion valida.");

            }
        } while (opcion!= 5);
    }

}// Final
