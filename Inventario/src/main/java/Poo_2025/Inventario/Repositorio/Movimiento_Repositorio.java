package Poo_2025.Inventario.Repositorio;

import Poo_2025.Inventario.Modelo.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Movimiento_Repositorio extends JpaRepository<Movimiento, Long> {

}
