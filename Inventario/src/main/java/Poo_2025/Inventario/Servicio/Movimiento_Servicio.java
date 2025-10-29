package Poo_2025.Inventario.Servicio;

import Poo_2025.Inventario.Modelo.Movimiento;
import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Repositorio.Movimiento_Repositorio;
import Poo_2025.Inventario.Repositorio.Producto_Repositorio;
import Poo_2025.Inventario.Repositorio.Tipo_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class Movimiento_Servicio {

    @Autowired
    private Movimiento_Repositorio movimientoRepo;

    @Autowired
    private Producto_Repositorio productoRepo;

    @Autowired
    private Tipo_Repositorio tipoRepo;

    // Registrar un nuevo movimiento
    public Movimiento registrarMovimiento(Movimiento movimiento) {
        if (movimiento.getProducto() == null || movimiento.getTipo() == null) {
            return null;
        }


        Optional<Producto> optProd = productoRepo.findById(movimiento.getProducto().getIdProducto());
        Optional<Tipo> optTipo = tipoRepo.findById(movimiento.getTipo().getId());

        if (optProd.isEmpty() || optTipo.isEmpty()) {
            return null;
        }

        Producto producto = optProd.get();
        Tipo tipo = optTipo.get();

        movimiento.setProducto(producto);
        movimiento.setTipo(tipo);
        movimiento.setFecha(LocalDate.now());

        // Aplicar efecto del movimiento
        if (tipo.getEfectoStock().equalsIgnoreCase("entrada")) {
            producto.setStockActual(producto.getStockActual() + movimiento.getCantidad());
        } else if (tipo.getEfectoStock().equalsIgnoreCase("salida")) {
            if (producto.getStockActual() < movimiento.getCantidad()) {
                return null; // No hay suficiente stock
            }
            producto.setStockActual(producto.getStockActual() - movimiento.getCantidad());
        }

        productoRepo.save(producto);
        return movimientoRepo.save(movimiento);
    }

    // Listar todos los movimientos
    public List<Movimiento> listar() {
        return movimientoRepo.findAll();
    }

    // Buscar un movimiento por ID
    public Movimiento obtenerPorId(Long id) {
        return movimientoRepo.findById(id).orElse(null);
    }

    // Eliminar movimiento y revertir efecto del stock
    public boolean eliminarPorId(Long id) {
        Optional<Movimiento> optMov = movimientoRepo.findById(id);
        if (optMov.isEmpty()) {
            return false;
        }

        Movimiento movimiento = optMov.get();
        Producto producto = movimiento.getProducto();
        Tipo tipo = movimiento.getTipo();

        // Revertir el efecto del movimiento
        if (tipo.getEfectoStock().equalsIgnoreCase("entrada")) {
            producto.setStockActual(producto.getStockActual() - movimiento.getCantidad());
        } else if (tipo.getEfectoStock().equalsIgnoreCase("salida")) {
            producto.setStockActual(producto.getStockActual() + movimiento.getCantidad());
        }

        productoRepo.save(producto);
        movimientoRepo.deleteById(id);
        return true;
    }
}