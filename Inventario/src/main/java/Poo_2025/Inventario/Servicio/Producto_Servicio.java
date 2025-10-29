package Poo_2025.Inventario.Servicio;

import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Repositorio.Producto_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Producto_Servicio {

    @Autowired
    private Producto_Repositorio productoRepo;

    public Producto guardar(Producto producto) {
        return productoRepo.save(producto);
    }

    public List<Producto> listar() {
        return productoRepo.findAll();
    }

    public Producto obtenerPorId(Integer id) {
        Optional<Producto> opt = productoRepo.findById(id);
        return opt.orElse(null);
    }

    public Producto actualizar(Integer id, Producto actualizado) {
        Optional<Producto> opt = productoRepo.findById(id);
        if (opt.isPresent()) {
            Producto p = opt.get();
            p.setNombre(actualizado.getNombre());
            p.setDescripcion(actualizado.getDescripcion());
            p.setPrecioUnitario(actualizado.getPrecioUnitario());
            p.setStockActual(actualizado.getStockActual());
            p.setProveedor(actualizado.getProveedor());
            return productoRepo.save(p);
        }
        return null;
    }

    public boolean eliminar(Integer id) {
        if (productoRepo.existsById(id)) {
            productoRepo.deleteById(id);
            return true;
        }
        return false;
    }
}