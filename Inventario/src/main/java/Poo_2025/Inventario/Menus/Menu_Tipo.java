package Poo_2025.Inventario.Menus;

import Poo_2025.Inventario.Acciones.Registro_Tipo;
import Poo_2025.Inventario.Acciones.Actualizar_Tipo;
import Poo_2025.Inventario.Acciones.Eliminar_Tipo;
import Poo_2025.Inventario.Acciones.Listar_Tipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Menu_Tipo {

    @Autowired
    private Registro_Tipo registroTipo;

    @Autowired
    private Actualizar_Tipo actualizarTipo;

    @Autowired
    private Listar_Tipos listarTipo;

    @Autowired
    private Eliminar_Tipo eliminarTipo;

    public void mostrar(Scanner sc) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== Gestión de Tipos de Movimiento ===");
            System.out.println("1. Registrar Tipos de Movimiento");
            System.out.println("2. Listar Tipos Movimientos");
            System.out.println("3. Actualizar Tipo Movimiento");
            System.out.println("4. Eliminar Tipo de Movimiento");
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
                    registroTipo.registrar();
                    break;
                case 2:
                    listarTipo.listar();
                    break;
                case 3:
                    actualizarTipo.actualizar();
                    break;
                case 4:
                    eliminarTipo.eliminar();
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
