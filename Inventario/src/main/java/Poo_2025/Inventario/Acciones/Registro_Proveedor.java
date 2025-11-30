package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Servicio.Proveedor_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Registro_Proveedor {
    @Autowired
    private Proveedor_Servicio proveedorServicio;

    public void registrar() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el e-mail del proveedor: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese el teléfono del proveedor: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese la dirección del proveedor: ");
        String direccion = scanner.nextLine();

        Proveedor proveedor = new Proveedor(nombre, email, telefono, direccion);

        proveedorServicio.guardar(proveedor);

        System.out.println("Proveedor registrado con éxito.");
    }
}
