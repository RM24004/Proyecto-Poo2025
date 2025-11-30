package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Servicio.Movimiento_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Eliminar_Movimiento {

    @Autowired
    private Movimiento_Servicio movimientoServicio;

    public void eliminar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== ELIMINAR MOVIMIENTO ===");
        System.out.print("Ingrese el ID del movimiento a eliminar: ");
        Long idMovimiento = scanner.nextLong();
        scanner.nextLine(); // limpiar buffer

        // Verificar si el movimiento existe antes de eliminar
        boolean existe = movimientoServicio.listar()
                .stream()
                .anyMatch(m -> m.getId().equals(idMovimiento));

        if (!existe) {
            System.out.println("No se encontró el movimiento con ID: " + idMovimiento);
            return;
        }

        // Eliminar directamente
        movimientoServicio.eliminar(idMovimiento);
        System.out.println("Movimiento eliminado correctamente.");
    }
}


