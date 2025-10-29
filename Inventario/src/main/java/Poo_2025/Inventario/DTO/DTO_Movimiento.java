package Poo_2025.Inventario.DTO;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DTO_Movimiento {

    private Integer id;

    @NotNull(message = "El ID del producto es obligatorio")
    private Integer idProducto;

    @NotNull(message = "El ID del tipo es obligatorio")
    private Integer idTipo;

    @NotNull(message = "La cantidad es obligatoria")
    @DecimalMin(value = "1.0", message = "La cantidad debe ser al menos 1")
    private Double cantidad;

    @NotNull(message = "La fecha es obligatoria")
    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate fecha;

    @Size(max = 300, message = "Máximo 300 caracteres en observaciones")
    private String observaciones;
}