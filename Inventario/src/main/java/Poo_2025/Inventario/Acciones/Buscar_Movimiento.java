package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Modelo.Movimiento;
import Poo_2025.Inventario.Repositorio.Movimiento_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Buscar_Movimiento {

    @Autowired
    private Movimiento_Repositorio movimientoRepo;

    public void buscarPorNombreProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("Debe ingresar un nombre válido.");
            return;
        }

        // Filtrar movimientos según el nombre del producto (ignora mayúsculas/minúsculas)
        List<Movimiento> resultados = movimientoRepo.findAll().stream()
                .filter(m -> m.getProductoid().getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .toList();

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron movimientos para el producto: " + nombre);
            return;
        }

        System.out.println("\n=== Resultados de búsqueda ===");
        for (Movimiento m : resultados) {
            System.out.println(
                    "ID Movimiento: " + m.getId() +
                            " | Producto: " + m.getProductoid().getNombre() +
                            " | Tipo: " + m.getTipo().getNombre() +
                            " | Cantidad: " + m.getCantidad() +
                            " | Fecha: " + m.getFecha() +
                            " | Observaciones: " + m.getObservaciones()
            );
        }
    }
}
