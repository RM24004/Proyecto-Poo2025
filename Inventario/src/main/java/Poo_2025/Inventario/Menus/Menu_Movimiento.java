package Poo_2025.Inventario.Menus;
import Poo_2025.Inventario.Acciones.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class Menu_Movimiento {
    @Autowired
    private Registro_Movimiento registroMovimiento;

    @Autowired
    private Listar_Movimientos listarMovimientos;

    @Autowired
    private Buscar_Movimiento buscarMovimiento;

    @Autowired
    private Eliminar_Movimiento eliminarMovimiento;

     public void mostrar(Scanner sc) {
        int opcion;

        do {
            System.out.println("\nGestión de Movimientos");
            System.out.println("1. Registrar Movimiento");
            System.out.println("2. Listar Movimientos");
            System.out.println("3. Buscar por Producto");
            System.out.println("4. Anular movimiento ");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> registroMovimiento.registrar();
                case 2 ->listarMovimientos.listar();
                case 3 ->buscarMovimiento.buscarPorNombreProducto();
                case 4 ->eliminarMovimiento.eliminar();
                case 5 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        } while (true);
    }
}
