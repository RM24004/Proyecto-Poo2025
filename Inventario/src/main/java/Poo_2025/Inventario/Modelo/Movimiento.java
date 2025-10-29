package Poo_2025.Inventario.Modelo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo tipo;

    @Column(nullable = false)
    private Double cantidad;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 300)
    private String observaciones;
}