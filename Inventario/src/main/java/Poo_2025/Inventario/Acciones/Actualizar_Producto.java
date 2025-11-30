package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Repositorio.Producto_Repositorio;
import Poo_2025.Inventario.Repositorio.Proveedor_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.Scanner;
@Component
public class Actualizar_Producto {

    @Autowired
    private final Producto_Repositorio productoRepo;

    @Autowired
    private final Proveedor_Repositorio proveedorRepo;

    public Actualizar_Producto(Producto_Repositorio productoRepo, Proveedor_Repositorio proveedorRepo) {
        this.productoRepo = productoRepo;
        this.proveedorRepo = proveedorRepo;
    }

    public void actualizar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto a actualizar: ");
        Integer id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Optional<Producto> optionalProducto = productoRepo.findById(id);

        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();

            System.out.print("Nuevo nombre (actual: " + producto.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (!nombre.isBlank()) producto.setNombre(nombre);

            System.out.print("Nueva descripción (actual: " + producto.getDescripcion() + "): ");
            String descripcion = scanner.nextLine();
            if (!descripcion.isBlank()) producto.setDescripcion(descripcion);

            System.out.print("Nuevo Precio unitario (actual: " + producto.getPrecioUnitario() + "): ");
            String precio = scanner.nextLine();
            if (!precio.isBlank()) {
                double nuevoPrecio = Double.parseDouble(precio);
                producto.setPrecioUnitario(nuevoPrecio);
            }

            System.out.print("Stock (actual: " + producto.getStockActual() + "): ");
            String stock = scanner.nextLine();
            if (!stock.isBlank()) {
                int nuevoStock = Integer.parseInt(stock);
                producto.setStockActual(nuevoStock);
            }

            // 🔹 Aquí corregimos el proveedor
            System.out.print("ID del proveedor (actual: " + producto.getProveedor().getId() + "): ");
            String idProv = scanner.nextLine();
            if (!idProv.isBlank()) {
                Integer nuevoIdProv = Integer.parseInt(idProv);
                proveedorRepo.findById(nuevoIdProv).ifPresent(producto::setProveedor);
            }

            productoRepo.save(producto);
            System.out.println("Producto actualizado correctamente.");

        } else {
            System.out.println("No se encontró producto con el ID " + id);
        }
    }
}