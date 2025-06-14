package Controller;

import Model.HerramientaDAO;
import Model.Herramienta;
import java.util.List;


public class HerramientaController {
    private HerramientaDAO dao;

    public HerramientaController() {
        this.dao = new HerramientaDAO();
    }

    public void crearHerramienta(int id_herramienta, String nombre, String tipo, String estado) {
        dao.insertar(new Herramienta(id_herramienta, nombre, tipo, estado));
    }
    public List<Herramienta> obtenerHerramientas() {
        return dao.listar();
    }
    public Herramienta obtenerHerramientaPorId(int id) {
        return dao.buscarPorId(id);
    }
    public void actualizarHerramienta(int id, String nombre, String tipo, String estado) {
        dao.actualizar(new Herramienta(id, nombre, tipo, estado));
    }
    public void eliminarHerramienta(int id) {
        dao.eliminar(id);
    }
}
