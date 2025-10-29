package Poo_2025.Inventario.Repositorio;

import Poo_2025.Inventario.Modelo.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_Repositorio extends JpaRepository<Tipo, Integer> {
}