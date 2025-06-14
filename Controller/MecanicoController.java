package Controller;

import DAO.MecanicoDAO;
import Model.Mecanico;
import java.util.List;

public class MecanicoController {
    private MecanicoDAO dao;

    public MecanicoController() {
        this.dao = new MecanicoDAO();
    }

    public void crearMecanico(int id_mecanico, String nombre, String especialidad, int aniosExperiencia) {
        dao.insertar(new Mecanico(id_mecanico, nombre, especialidad, aniosExperiencia));
    }
    public List<Mecanico> obtenerMecanicos() {
        return dao.listar();
    }
    public Mecanico obtenerMecanicoPorId(int id) {
        return dao.buscarPorId(id);
    }
    public void actualizarMecanico(int id, String nombre, String especialidad, int aniosExperiencia) {
        dao.actualizar(new Mecanico(id, nombre, especialidad, aniosExperiencia));
    }
    public void eliminarMecanico(int id) {
        dao.eliminar(id);
    }
}
