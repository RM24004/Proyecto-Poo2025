package Poo_2025.Inventario.Acciones;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Repositorio.Tipo_Repositorio;

@Component
public class Listar_Tipos {

    @Autowired
    private Tipo_Repositorio tipoRepo;

    public void listar() {
        System.out.println("\nLista de Tipos de Movimiento:");

        List<Tipo> tipo = tipoRepo.findAll();

        if (tipo.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Tipo p : tipo) {
                System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() +" | Descripción: " + p.getDescripcion() + " | Efecto: " + p.getEfectoStock());
            }
        }
    }
}
