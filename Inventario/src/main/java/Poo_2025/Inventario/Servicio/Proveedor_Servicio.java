package Poo_2025.Inventario.Servicio;

import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Repositorio.Proveedor_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Proveedor_Servicio {

    @Autowired
    private Proveedor_Repositorio proveedorRepo;

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    public List<Proveedor> listar() {
        return proveedorRepo.findAll();
    }

    public Proveedor obtenerPorId(Integer id) {
        Optional<Proveedor> opt = proveedorRepo.findById(id);
        return opt.orElse(null);
    }

    public Proveedor actualizar(Integer id, Proveedor actualizado) {
        Optional<Proveedor> opt = proveedorRepo.findById(id);
        if (opt.isPresent()) {
            Proveedor p = opt.get();
            p.setNombre(actualizado.getNombre());
            p.setEmail(actualizado.getEmail());
            p.setTelefono(actualizado.getTelefono());
            p.setDireccion(actualizado.getDireccion());
            return proveedorRepo.save(p);
        }
        return null;
    }

    public boolean eliminar(Integer id) {
        if (proveedorRepo.existsById(id)) {
            proveedorRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

