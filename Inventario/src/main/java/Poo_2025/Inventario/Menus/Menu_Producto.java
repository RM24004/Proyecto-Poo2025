package Poo_2025.Inventario.Menus;
import Poo_2025.Inventario.Acciones.Eliminar_Producto;
import Poo_2025.Inventario.Acciones.Actualizar_Producto;
import Poo_2025.Inventario.Acciones.Registro_Producto;
import Poo_2025.Inventario.Acciones.Listar_Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Menu_Producto {

    @Autowired
    private Registro_Producto registroProducto;

    @Autowired
    private Actualizar_Producto actualizarProducto;

    @Autowired
    private Listar_Productos listarProducto;

    @Autowired
    private Eliminar_Producto eliminarProducto;

    public void mostrar(Scanner sc) {
        int opcion;

        do {
            System.out.println("\nGestión de Productos");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> registroProducto.registrar();
                case 2 -> listarProducto.listar();
                case 3 -> actualizarProducto.actualizar();
                case 4 -> eliminarProducto.eliminar();
                case 5 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        } while (true);
    }
}
