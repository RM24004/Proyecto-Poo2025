package Poo_2025.Inventario.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer id;

    private String nombre;
    private String descripcion;

    @Column(name = "efecto_stock")
    private String efectoStock;


    public Tipo() {
    }

    public Tipo(String nombre, String descripcion, String efectoStock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.efectoStock = efectoStock;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEfectoStock() {
        return efectoStock;
    }

    public void setEfectoStock(String efectoStock) {
        this.efectoStock = efectoStock;
    }
    @Override
    public String toString() {
        return nombre + " (" + efectoStock + ")";
    }
}

