package Poo_2025.Inventario.Servicio;

import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Repositorio.Tipo_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Tipo_Servicio {

    @Autowired
    private Tipo_Repositorio tipoRepo;

    public Tipo guardar(Tipo tipo) {
        return tipoRepo.save(tipo);
    }

    public List<Tipo> listar() {
        return tipoRepo.findAll();
    }

    public Tipo obtenerPorId(Integer id) {
        Optional<Tipo> tipo = tipoRepo.findById(id);
        return tipo.orElse(null);
    }

    public Tipo actualizar(Integer id, Tipo tipoActualizado) {
        Optional<Tipo> tipoExistente = tipoRepo.findById(id);
        if (tipoExistente.isPresent()) {
            Tipo tipo = tipoExistente.get();
            tipo.setNombre(tipoActualizado.getNombre());
            tipo.setDescripcion(tipoActualizado.getDescripcion());
            tipo.setEfectoStock(tipoActualizado.getEfectoStock());
            return tipoRepo.save(tipo);
        }
        return null;
    }

    public boolean eliminar(Integer id) {
        if (tipoRepo.existsById(id)) {
            tipoRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
