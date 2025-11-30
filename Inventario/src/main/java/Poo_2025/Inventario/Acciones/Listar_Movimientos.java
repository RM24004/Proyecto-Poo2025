package Poo_2025.Inventario.Acciones;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import Poo_2025.Inventario.Modelo.Movimiento;
import Poo_2025.Inventario.Repositorio.Movimiento_Repositorio;

@Component
public class Listar_Movimientos {

    @Autowired
    private Movimiento_Repositorio movimientoRepo;

    public void listar() {
        System.out.println("\n=== Lista de Movimientos ===");

        List<Movimiento> movimientos = movimientoRepo.findAll();

        if (movimientos.isEmpty()) {
            System.out.println("No hay movimientos registrados.");
        } else {
            for (Movimiento m : movimientos) {
                System.out.println(
                        "ID: " + m.getId()
                                + " | Producto: " + m.getProductoid().getNombre()
                                + " | Tipo: " + m.getTipo().getNombre()
                                + " | Cantidad: " + m.getCantidad()
                                + " | Fecha: " + m.getFecha()
                                + " | Observaciones: " + m.getObservaciones()
                );
            }
        }
    }
}

