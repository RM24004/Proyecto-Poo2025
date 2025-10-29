package Poo_2025.Inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
        System.out.println("""
                === BACKEND INVENTARIO EN USO ===
                El frontend está activo o se puede usar Postman para pruebas.
                """);

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            do {
                System.out.print("\nIngrese 0 para salir del sistema: ");
                String entrada = scanner.nextLine().trim();
                opcion = entrada.matches("\\d+") ? Integer.parseInt(entrada) : -1;
            } while (opcion != 0);
        }

        System.out.println("Cerrando sistema...");
        System.exit(0);
    }
}