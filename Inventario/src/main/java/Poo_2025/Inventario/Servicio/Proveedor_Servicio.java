package Poo_2025.Inventario.Servicio;

import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Repositorio.Proveedor_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Proveedor_Servicio {

    @Autowired
    private Proveedor_Repositorio proveedorRepo;

    // Guardar un proveedor
    public  void guardar(Proveedor proveedor) {
        proveedorRepo.save(proveedor);
    }

    // Listar todos los proveedores
    public List<Proveedor> listar() {
        return proveedorRepo.findAll();
    }

    // Eliminar un proveedor por ID
    public void eliminar(Integer id) {
        proveedorRepo.deleteById(id);
    }
}
