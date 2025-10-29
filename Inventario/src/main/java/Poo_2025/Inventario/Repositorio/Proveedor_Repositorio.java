package Poo_2025.Inventario.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Poo_2025.Inventario.Modelo.Proveedor;
@Repository
public interface Proveedor_Repositorio extends JpaRepository<Proveedor, Integer> {
}
