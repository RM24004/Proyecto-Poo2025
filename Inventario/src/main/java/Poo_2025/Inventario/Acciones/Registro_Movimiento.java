package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Modelo.Movimiento;
import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Repositorio.Movimiento_Repositorio;
import Poo_2025.Inventario.Repositorio.Producto_Repositorio;
import Poo_2025.Inventario.Repositorio.Tipo_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Registro_Movimiento {

    @Autowired
    private Movimiento_Repositorio movimientoRepo;

    @Autowired
    private Producto_Repositorio productoRepo;

    @Autowired
    private Tipo_Repositorio tipoRepo;

    public void registrar() {
        Scanner scanner = new Scanner(System.in);

        // Selección del producto
        System.out.print("Ingrese ID del producto: ");
        Integer idProducto = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Optional<Producto> optionalProducto = productoRepo.findById(idProducto);
        if (optionalProducto.isEmpty()) {
            System.out.println("Producto no encontrado.");
            return;
        }
        Producto producto = optionalProducto.get();

        // Selección del tipo de movimiento
        System.out.print("Ingrese ID del tipo de movimiento: ");
        Integer idTipo = scanner.nextInt();
        scanner.nextLine();

        Optional<Tipo> optionalTipo = tipoRepo.findById(idTipo);
        if (optionalTipo.isEmpty()) {
            System.out.println("Tipo de movimiento no encontrado.");
            return;
        }
        Tipo tipo = optionalTipo.get();

        // Cantidad
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        // Efecto sobre el stock (ENTRADA o SALIDA)
        String efecto = tipo.getEfectoStock() != null ? tipo.getEfectoStock().trim().toUpperCase() : "";

        if (!efecto.equals("ENTRADA") && !efecto.equals("SALIDA")) {
            System.out.println("Error: el efecto_stock debe ser 'ENTRADA' o 'SALIDA'.");
            return;
        }

        // Validación de stock solo si es salida
        if (efecto.equals("SALIDA") && cantidad > producto.getStockActual()) {
            System.out.println("No hay suficiente stock para realizar esta salida.");
            return;
        }

        // Observaciones
        System.out.print("Observaciones: ");
        String observaciones = scanner.nextLine();

        // Actualizar stock según el tipo
        if (efecto.equals("ENTRADA")) {
            producto.setStockActual(producto.getStockActual() + cantidad);
        } else if (efecto.equals("SALIDA")) {
            producto.setStockActual(producto.getStockActual() - cantidad);
        }

        productoRepo.save(producto);

        // Guardar movimiento
        Movimiento movimiento = new Movimiento();
        movimiento.setProductoid(producto);
        movimiento.setTipo(tipo);
        movimiento.setCantidad(cantidad);
        movimiento.setObservaciones(observaciones);
        movimiento.setFecha(LocalDate.now());

        movimientoRepo.save(movimiento);

        System.out.println("Movimiento registrado correctamente (" + efecto + ").");
    }
}


