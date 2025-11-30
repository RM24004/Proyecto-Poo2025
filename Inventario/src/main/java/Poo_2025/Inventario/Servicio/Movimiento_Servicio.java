package Poo_2025.Inventario.Servicio;
import Poo_2025.Inventario.Modelo.Movimiento;
import Poo_2025.Inventario.Repositorio.Movimiento_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class Movimiento_Servicio {
    @Autowired
    private Movimiento_Repositorio movimientoRepo;

    public void guardar(Movimiento movimiento) {
        movimientoRepo.save(movimiento);
    }
    public List<Movimiento> listar() {
        return  movimientoRepo.findAll();
    }
    public void eliminar(Long id) {
        movimientoRepo.deleteById(id);
    }
}

