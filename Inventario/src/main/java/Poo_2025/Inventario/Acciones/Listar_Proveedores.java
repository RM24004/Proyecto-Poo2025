package Poo_2025.Inventario.Acciones;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Repositorio.Proveedor_Repositorio;

@Component
public class Listar_Proveedores {

    @Autowired
    private Proveedor_Repositorio proveedorRepo;

    public void listar() {
        System.out.println("\nLista de Proveedores:");

        List<Proveedor> proveedores = proveedorRepo.findAll();

        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Proveedor p : proveedores) {
                System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() +" | E-mail: " + p.getEmail()
                        + " | Dirección: " + p.getDireccion() + " | Teléfono: " + p.getTelefono());
            }
        }
    }
}
