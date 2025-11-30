package Poo_2025.Inventario.Servicio;

import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Repositorio.Producto_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producto_Servicio {

    @Autowired
    private Producto_Repositorio productoRepo;

        public void guardar(Producto producto) {
            productoRepo.save(producto);
        }

        public List<Producto> listar() {
            return productoRepo.findAll();
        }

        public void eliminar(Integer id) {
            productoRepo.deleteById(id);
        }
}
