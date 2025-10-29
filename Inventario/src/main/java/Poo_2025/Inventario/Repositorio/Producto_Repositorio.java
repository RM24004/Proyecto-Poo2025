package Poo_2025.Inventario.Repositorio;

import Poo_2025.Inventario.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Producto_Repositorio extends JpaRepository<Producto, Integer> {
}
