package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Repositorio.Tipo_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Eliminar_Tipo {

    private final Tipo_Repositorio tipoRepo;

    @Autowired
    public Eliminar_Tipo(Tipo_Repositorio tipoRepo) {
        this.tipoRepo = tipoRepo;
    }

    public void eliminar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del tipo de movimiento a eliminar: ");
        Integer id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        if (tipoRepo.existsById(id)) {
            tipoRepo.deleteById(id);
            System.out.println("Tipo de Movimiento eliminado correctamente.");
        } else {
            System.out.println("No se encontró el tipo de movimiento con el ID " + id);
        }
    }
}
