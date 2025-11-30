package Poo_2025.Inventario;
import Poo_2025.Inventario.Menus.Menu_Movimiento;
import Poo_2025.Inventario.Menus.Menu_Proveedor;
import Poo_2025.Inventario.Menus.Menu_Producto;
import Poo_2025.Inventario.Menus.Menu_Tipo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(InventarioApplication.class, args);
        Menu_Movimiento menuMovimiento = context.getBean(Menu_Movimiento.class);
        Menu_Proveedor menuProveedor = context.getBean(Menu_Proveedor.class);
        Menu_Producto menuProducto = context.getBean(Menu_Producto.class);
        Menu_Tipo menuTipo = context.getBean(Menu_Tipo.class);
        mostrarMenu(menuProveedor, menuProducto, menuTipo, menuMovimiento);
    }

    private static void mostrarMenu(Menu_Proveedor menuProveedor, Menu_Producto menuProducto, Menu_Tipo menuTipo, Menu_Movimiento menuMovimiento) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== Menu Inventario 2025 =====");
            System.out.println("1. Gestión de Productos");
            System.out.println("2. Gestión de Proveedores");
            System.out.println("3. Gestión de Movimientos");
            System.out.println("4. Tipos de Movimientos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida.");
                System.out.println("Ingrese un numero nuevamente.");
                sc.next();
            }
            opcion = sc.nextInt();

            sc.nextLine();

            switch (opcion) {
                case 1 -> menuProducto.mostrar(sc);
                case 2 -> menuProveedor.mostrar(sc);
                case 3 -> menuMovimiento.mostrar(sc);
                case 4 -> menuTipo.mostrar(sc);
                case 5 -> { System.out.println("Saliendo..."); System.exit(0); }
                default -> System.out.println("Opción inválida.");
            }
        } while (true);
    }
}


