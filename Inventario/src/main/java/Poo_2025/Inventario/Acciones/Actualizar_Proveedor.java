package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Repositorio.Proveedor_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Actualizar_Proveedor {

    @Autowired
    private final Proveedor_Repositorio proveedorRepo;

    @Autowired
    public Actualizar_Proveedor(Proveedor_Repositorio proveedorRepo) {
        this.proveedorRepo = proveedorRepo;
    }

    public void actualizar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del proveedor a actualizar: ");
        Integer id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Optional<Proveedor> optionalProveedor = proveedorRepo.findById(id);

        if (optionalProveedor.isPresent()) {
            Proveedor proveedor = optionalProveedor.get();

            System.out.println("Proveedor actual: " + proveedor);

            System.out.print("Nuevo nombre (actual: " + proveedor.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (!nombre.isBlank()) proveedor.setNombre(nombre);

            System.out.print("Nueva dirección (actual: " + proveedor.getDireccion() + "): ");
            String direccion = scanner.nextLine();
            if (!direccion.isBlank()) proveedor.setDireccion(direccion);

            System.out.print("Nuevo teléfono (actual: " + proveedor.getTelefono() + "): ");
            String telefono = scanner.nextLine();
            if (!telefono.isBlank()) proveedor.setTelefono(telefono);

            System.out.print("Nuevo email (actual: " + proveedor.getEmail() + "): ");
            String email = scanner.nextLine();
            if (!email.isBlank()) proveedor.setEmail(email);

            proveedorRepo.save(proveedor);
            System.out.println("Proveedor actualizado correctamente.");

        } else {
            System.out.println("No se encontró proveedor con el ID " + id);
        }
    }
}
