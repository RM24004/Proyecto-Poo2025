package Poo_2025.Inventario.Menus;

import Poo_2025.Inventario.Acciones.Listar_Proveedores;
import Poo_2025.Inventario.Acciones.Registro_Proveedor;
import Poo_2025.Inventario.Acciones.Actualizar_Proveedor;
import Poo_2025.Inventario.Acciones.Eliminar_Proveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Menu_Proveedor {

    @Autowired
    private Registro_Proveedor registroProveedor;

    @Autowired
    private Listar_Proveedores listarProveedores;

    @Autowired
    private Actualizar_Proveedor actualizarProveedores;

    @Autowired
    private Eliminar_Proveedor eliminarProveedores;

    public void mostrar(Scanner sc) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Gestión de Proveedores ===");
            System.out.println("1. Registrar Proveedor");
            System.out.println("2. Listar Proveedores");
            System.out.println("3. Actualizar Proveedor");
            System.out.println("4. Eliminar Proveedores");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            if(scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el buffer
            } else {
                System.out.println("Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar entrada inválida
                continue;
            }

            switch (opcion) {
                case 1:
                    registroProveedor.registrar();
                    break;
                case 2:
                    listarProveedores.listar();
                    break;
                case 3:
                    actualizarProveedores.actualizar();
                    break;
                case 4:
                    eliminarProveedores.eliminar();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    return; // Sale del menú
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (true);
    }
}
