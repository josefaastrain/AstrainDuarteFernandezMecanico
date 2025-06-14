package Controller;

import DAO.AutoDAO;
import Model.Auto;
import java.util.List;

public class AutoController {
    private AutoDAO dao;

    public AutoController() {
        this.dao = new AutoDAO();
    }

    public void crearAuto(int id_Auto, String marca, String modelo, int anio, String patente) {
        dao.insertar(new Auto(id_Auto, marca, modelo, anio, patente));
    }
    public List<Auto> obtenerAutos() {
        return dao.listar();
    }
    public Auto obtenerAutoPorId(int id) {
        return dao.buscarPorId(id);
    }
    public void actualizarAuto(int id, String marca, String modelo, int anio, String patente) {
        dao.actualizar(new Auto(id, marca, modelo, anio, patente));
    }
    public void eliminarAuto(int id) {
        dao.eliminar(id);
    }
}

