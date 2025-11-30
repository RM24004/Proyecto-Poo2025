package Poo_2025.Inventario.Acciones;


import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Repositorio.Producto_Repositorio;

@Component
public class Listar_Productos {

    @Autowired
    private Producto_Repositorio productoRepo;
    public void listar() {
        System.out.println("\nLista de Productos:");

        List<Producto> producto = productoRepo.findAll();

        if (producto.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Producto p : producto) {
                System.out.println("ID: " + p.getIdProducto() + " | Nombre: " + p.getNombre() +" | Descripcion: " + p.getDescripcion()
                        + " | Precio unitario: " + p.getPrecioUnitario() + " | Stock Actual: " + p.getStockActual() + " | ID Proveedor: " + p.getProveedor().getId());
            }
        }
    }
}
