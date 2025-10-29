package Poo_2025.Inventario.Controller;

import Poo_2025.Inventario.DTO.DTO_Tipo;
import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Servicio.Tipo_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventario/tipos")
@CrossOrigin(origins = "*")
public class Tipo_Controller {
    @Autowired
    private Tipo_Servicio tipoServicio;
    // Crear un nuevo tipo
    @PostMapping
    public ResponseEntity<String> crearTipo(@Valid @RequestBody DTO_Tipo dto) {
          Tipo tipo = Tipo.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .efectoStock(dto.getEfectoStock())
                .build();
        Tipo creado = tipoServicio.guardar(tipo);
        return ResponseEntity.ok("Tipo creado exitosamente: "+ dto.getNombre());
    }
    // Listar todos los tipos
    @GetMapping
    public ResponseEntity<List<Tipo>> listarTipos() {
        List<Tipo> tipos = tipoServicio.listar();
        return ResponseEntity.ok(tipos);
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id) {
        Tipo tipo = tipoServicio.obtenerPorId(id);

        if (tipo != null) {
            return ResponseEntity.ok(tipo); // Devuelve el objeto
        } else {
            String mensaje = "No se encontró ningún tipo con ID: " + id;
            return ResponseEntity.status(404).body(mensaje); // Solo el mensaje
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarTipo(@PathVariable Integer id, @Valid @RequestBody DTO_Tipo dto) {
        Tipo tipoActualizado = Tipo.builder()
                .id(id)
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .efectoStock(dto.getEfectoStock())
                .build();
        Tipo tipo = tipoServicio.actualizar(id, tipoActualizado);
        if (tipo != null) {
            return ResponseEntity.ok("Tipo actualizado exitosamente con ID: " + id);
        } else {
            return ResponseEntity.status(404).body("No se encontró ningún tipo con ID: " + id);
        }
    }
    // Eliminar un tipo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipo(@PathVariable Integer id) {
        boolean eliminado = tipoServicio.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok("Tipo eliminado exitosamente con ID: " + id);
        } else {
            return ResponseEntity.status(404).body("No se encontró ningún tipo con ID: " + id);
        }
    }
}