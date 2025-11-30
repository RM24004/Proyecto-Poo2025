package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Repositorio.Producto_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Eliminar_Producto {
    @Autowired
    private final Producto_Repositorio productoRepo;

    public Eliminar_Producto(Producto_Repositorio productoRepo) {
        this.productoRepo = productoRepo;
    }
    public void eliminar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto a eliminar: ");
        Integer id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        if (productoRepo.existsById(id)) {
            productoRepo.deleteById(id);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se encontró producto con el ID " + id);
        }
    }
}
