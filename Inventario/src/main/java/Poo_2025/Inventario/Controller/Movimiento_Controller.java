package Poo_2025.Inventario.Controller;

import Poo_2025.Inventario.DTO.DTO_Movimiento;
import Poo_2025.Inventario.Modelo.Movimiento;
import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Servicio.Movimiento_Servicio;
import Poo_2025.Inventario.Servicio.Producto_Servicio;
import Poo_2025.Inventario.Servicio.Tipo_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventario/movimientos")
@CrossOrigin(origins = "*")
public class Movimiento_Controller {
    @Autowired
    private Movimiento_Servicio movimientoServicio;
    @Autowired
    private Producto_Servicio productoServicio;
    @Autowired
    private Tipo_Servicio tipoServicio;
    // Crear un movimiento (entrada o salida)
    @PostMapping
    public ResponseEntity<String> crearMovimiento(@Valid @RequestBody DTO_Movimiento dto) {
        Producto producto = productoServicio.obtenerPorId(dto.getIdProducto());
        Tipo tipo = tipoServicio.obtenerPorId(dto.getIdTipo());
        if (producto == null || tipo == null) {
            return ResponseEntity.badRequest().body("Producto o Tipo inválido");
        }
        Movimiento movimiento = Movimiento.builder()
                .producto(producto)
                .tipo(tipo)
                .cantidad(dto.getCantidad())
                .fecha(dto.getFecha())
                .observaciones(dto.getObservaciones())
                .build();
        Movimiento creado = movimientoServicio.registrarMovimiento(movimiento);
        if (creado == null) {
            return ResponseEntity.status(500).body("Error al registrar el movimiento");
        }
        return ResponseEntity.ok("Movimiento registrado exitosamente para el producto: " + producto.getNombre());
    }
    // Listar todos los movimientos
    @GetMapping
    public ResponseEntity<List<Movimiento>> listarMovimientos() {
        return ResponseEntity.ok(movimientoServicio.listar());
    }
    // Obtener movimiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Movimiento movimiento = movimientoServicio.obtenerPorId(id);
        if (movimiento != null) {
            return ResponseEntity.ok(movimiento); //Devuelve el objeto
        } else {
            String mensaje = "No se encontró ningún movimiento con ID: " + id;
            return ResponseEntity.status(404).body(mensaje);
        }
    }
    // Eliminar un movimiento por ID (y revertir stock)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMovimiento(@PathVariable Long id) {
        boolean eliminado = movimientoServicio.eliminarPorId(id);
        if (eliminado) {
            return ResponseEntity.ok("Movimiento eliminado correctamente y stock actualizado.");
        } else {
            return ResponseEntity.status(404).body("No se encontró el movimiento con ID: " + id);
        }
    }
}