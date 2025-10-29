package Poo_2025.Inventario.Controller;

import Poo_2025.Inventario.DTO.DTO_Proveedor;
import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Servicio.Proveedor_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventario/proveedores")
@CrossOrigin(origins = "*")
public class Proveedor_Controller {
    @Autowired
    private Proveedor_Servicio proveedorServicio;
    // Crear proveedor
    @PostMapping
    public ResponseEntity<String> crearProveedor(@Valid @RequestBody DTO_Proveedor dto) {
        Proveedor proveedor = Proveedor.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .build();

        Proveedor creado = proveedorServicio.guardar(proveedor);
        return ResponseEntity.ok("Proveedor creado exitosamente: "+dto.getNombre());
    }
    // Listar todos
    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        List<Proveedor> lista = proveedorServicio.listar();
        return ResponseEntity.ok(lista);
    }
    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id) {
        Proveedor proveedor = proveedorServicio.obtenerPorId(id);
        if (proveedor != null)
        {
            return ResponseEntity.ok(proveedor);
        }else {
            String mensaje ="No se encontró ningún producto con el ID: " + id;
            return ResponseEntity.status(404).body(mensaje);
        }
    }
    // Actualizar proveedor
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProveedor(@PathVariable Integer id, @Valid @RequestBody DTO_Proveedor dto) {
        Proveedor proveedorActualizado = Proveedor.builder()
                .id(id)
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .build();
        Proveedor proveedor = proveedorServicio.actualizar(id, proveedorActualizado);
        if (proveedor != null)
        {
            return ResponseEntity.ok("Proveedor actualizado exitosamente con ID: "+ id);
        }else{
            return ResponseEntity.status(404).body("No se encontró ningún proveedor con el ID: "+ id);
        }
    }
    // Eliminar proveedor
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable Integer id) {
        boolean eliminado= proveedorServicio.eliminar(id);
        if (eliminado)
        {
            return ResponseEntity.ok("Proveedor eliminado exitosamente con ID: " + id);
        }else{
            return ResponseEntity.status(404).body("Nose encontró ningún proveedor con ID: "+ id);
        }
    }
}