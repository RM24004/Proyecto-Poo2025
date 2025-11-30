package Poo_2025.Inventario.Acciones;


import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Repositorio.Tipo_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class Actualizar_Tipo {

    private final Tipo_Repositorio tipoRepo;

    @Autowired
    public Actualizar_Tipo(Tipo_Repositorio tipoRepo) {
        this.tipoRepo = tipoRepo;
    }
    public void actualizar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del Tipo de Movimiento a actualizar: ");
        Integer id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Optional<Tipo> optionalTipo = tipoRepo.findById(id);

        if (optionalTipo.isPresent()) {
            Tipo tipo = optionalTipo.get();

            System.out.println("Tipo actual: " + tipo);

            System.out.print("Nuevo nombre tipo (actual: " + tipo.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (!nombre.isBlank()) tipo.setNombre(nombre);

            System.out.print("Nueva description (actual: " + tipo.getDescripcion() + "): ");
            String descripcion = scanner.nextLine();
            if (!descripcion.isBlank()) tipo.setDescripcion(descripcion);

            tipoRepo.save(tipo);
            System.out.println("Tipo actualizado correctamente.");

        } else {
            System.out.println("No se encontró el tipo de movimiento con el ID " + id);
        }
    }
}
