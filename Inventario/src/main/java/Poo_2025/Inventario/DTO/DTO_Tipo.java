package Poo_2025.Inventario.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DTO_Tipo {

    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre debe tener como máximo 100 caracteres")
    private String nombre;

    @Size(max = 500, message = "La descripción debe tener como máximo 500 caracteres")
    private String descripcion;

    @NotBlank(message = "El efecto en stock no puede estar vacío")
    @Pattern(regexp = "^(Entrada|Salida)$", message = "El efecto debe ser Entrada o Salida")
    private String efectoStock;
}