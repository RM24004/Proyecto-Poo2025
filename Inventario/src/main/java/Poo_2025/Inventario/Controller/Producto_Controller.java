package Poo_2025.Inventario.Controller;

import Poo_2025.Inventario.DTO.DTO_Producto;
import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Servicio.Producto_Servicio;
import Poo_2025.Inventario.Servicio.Proveedor_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventario/productos")
@CrossOrigin(origins = "*")
public class Producto_Controller {
    @Autowired
    private Producto_Servicio productoServicio;
    @Autowired
    private Proveedor_Servicio proveedorServicio;
    // Crear producto
    @PostMapping
    public ResponseEntity<String> crearProducto(@Valid @RequestBody DTO_Producto dto) {
        Proveedor proveedor = proveedorServicio.obtenerPorId(dto.getIdProveedor());
        if (proveedor == null) {
            return ResponseEntity.badRequest().body("Proveedor no válido con ID: " + dto.getIdProveedor());
        }
        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precioUnitario(dto.getPrecioUnitario())
                .stockActual(dto.getStockActual())
                .proveedor(proveedor)
                .build();

        productoServicio.guardar(producto);
        return ResponseEntity.ok("Producto creado exitosamente: " + dto.getNombre());
    }
    // Listar todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> lista = productoServicio.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/precio")
    public ResponseEntity<List<Producto>> buscarPorPrecio(@Valid @RequestParam Double precio) {
        List<Producto> resultado = productoServicio.listar().stream()
                .filter(p -> p.getPrecioUnitario().equals(precio))
                .toList();

        return ResponseEntity.ok(resultado);
    }

    // Buscar producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id) {
        Producto producto = productoServicio.obtenerPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.status(404).body("No se encontró ningún producto con ID: " + id);
    }
    // Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Integer id, @Valid @RequestBody DTO_Producto dto) {
        Proveedor proveedor = proveedorServicio.obtenerPorId(dto.getIdProveedor());
        if (proveedor == null) {
            return ResponseEntity.badRequest().body("Proveedor no válido con ID: " + dto.getIdProveedor());
        }
        Producto actualizado = Producto.builder()
                .idProducto(id)
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precioUnitario(dto.getPrecioUnitario())
                .stockActual(dto.getStockActual())
                .proveedor(proveedor)
                .build();
        Producto producto = productoServicio.actualizar(id, actualizado);
        if (producto != null) {
            return ResponseEntity.ok("Producto actualizado exitosamente con ID: " + id);
        }
        return ResponseEntity.status(404).body("No se encontró ningún producto con ID: " + id);
    }
    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id) {
        boolean eliminado = productoServicio.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok("Producto eliminado exitosamente con ID: " + id);
        }
        return ResponseEntity.status(404).body("No se encontró ningún producto con ID: " + id);
    }
}