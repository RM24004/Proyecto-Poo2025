package Poo_2025.Inventario.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DTO_Proveedor {

    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "Máximo 100 caracteres")
    private String nombre;

    @Email(message = "Debe ser un correo válido")
    @Size(max = 100, message = "Máximo 100 caracteres")
    private String email;

    @Pattern(regexp = "\\d{8,9}", message = "El teléfono debe tener entre 8 y 9 dígitos")
    private String telefono;

    @Size(max = 200, message = "Máximo 200 caracteres")
    private String direccion;
}
