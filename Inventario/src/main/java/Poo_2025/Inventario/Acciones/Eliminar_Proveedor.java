package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Repositorio.Proveedor_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Eliminar_Proveedor {

    private final Proveedor_Repositorio proveedorRepo;

    @Autowired
    public Eliminar_Proveedor(Proveedor_Repositorio proveedorRepo) {
        this.proveedorRepo = proveedorRepo;
    }

    public void eliminar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del proveedor a eliminar: ");
        Integer id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        if (proveedorRepo.existsById(id)) {
            proveedorRepo.deleteById(id);
            System.out.println("Proveedor eliminado correctamente.");
        } else {
            System.out.println("No se encontró proveedor con el ID " + id);
        }
    }
}

