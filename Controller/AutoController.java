package Controller;

import Model.Auto;
import Dao.AutoDAO;
import View.AutoView;
import Util.Validador;

import java.util.*;

public class AutoController {

    private AutoDAO dao;
    private AutoView view;
    public Validador validador;

    public AutoController(){
        dao = new AutoDAO();
        view = new AutoView();
        validador = new Validador();
    }

    public void iniciar(){

        int opcion;
        do{
            view.mostrarMenu();
            opcion = validador.validarInt(1);
            List<Auto> listaAutos = dao.obtenerTodo();

            switch (opcion){

                case 1 -> dao.crearAuto(view.leerNuevoAuto());
                case 2 -> view.mostrarAutos(dao.obtenerTodo());
                case 3 -> dao.actualizarAuto(view.leerAutoActualizado(listaAutos));
                case 4 -> dao.EliminarAuto(view.leerIdEliminar(listaAutos));
                case 5 -> System.out.println("Adios!...");

                default -> System.out.println("Ingrese una opcion valida.");

            }
        } while (opcion != 5);
    }

}
