package Poo_2025.Inventario.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DTO_Producto {

    private Integer idProducto;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "Máximo 100 caracteres")
    private String nombre;

    @Size(max = 300, message = "Máximo 300 caracteres")
    private String descripcion;

    @NotNull(message = "El precio unitario es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que cero")
    private Double precioUnitario;

    @NotNull(message = "El stock actual es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Double stockActual;

    @NotNull(message = "El ID del proveedor es obligatorio")
    private Integer idProveedor;
}


