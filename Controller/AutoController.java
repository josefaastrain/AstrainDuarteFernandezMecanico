package Controller;

import Model.AutoDAO;
import View.AutoView;

import java.util.*;

public class AutoController {

    private AutoDAO dao;
    private AutoView view;

    public AutoController(){
        dao = new AutoDAO();
        view = new AutoView();
    }

    public void iniciar(){

        int opcion;
        do{
            view.mostrarMenu();
            opcion = view.leerOpcion();

            switch (opcion){
                case 1 -> dao.crearAuto(view.leerNuevoAuto());
                case 2 -> view.mostrarAutos(dao.obtenerTodo());
                case 3 -> dao.actualizarAuto(view.leerAutoActualizado());
                case 4 -> dao.EliminarAuto(view.leerIdEliminar());
                case 5 -> System.out.println("Adios!...");
            }
        } while (opcion != 5);
    }

}
