package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Servicio.Producto_Servicio;
import Poo_2025.Inventario.Repositorio.Proveedor_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class Registro_Producto {

    @Autowired
    private Producto_Servicio productoServicio;

    @Autowired
    private Proveedor_Repositorio proveedorRepo;

    public void registrar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== REGISTRO DE PRODUCTO ===");

        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese descripción: ");
        String descripcion = sc.nextLine();

        System.out.print("Ingrese precio unitario: ");
        Double precio = null;
        while (precio == null) {
            try {
                precio = Double.parseDouble(sc.nextLine());
                if (precio <= 0) {
                    System.out.println("El precio debe ser mayor que 0.");
                    precio = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido para el precio.");
            }
        }

        System.out.print("Ingrese stock inicial: ");
        Integer stock = null;
        while (stock == null) {
            try {
                stock = Integer.parseInt(sc.nextLine());
                if (stock < 0) {
                    System.out.println("El stock no puede ser negativo.");
                    stock = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido para el stock.");
            }
        }

        System.out.print("Ingrese ID del proveedor: ");
        Integer idProveedor = null;
        while (idProveedor == null) {
            try {
                idProveedor = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido para el ID del proveedor.");
            }
        }

        Optional<Proveedor> proveedorOpt = proveedorRepo.findById(idProveedor);
        if (proveedorOpt.isEmpty()) {
            System.out.println("No se encontró un proveedor con ID no se hizo el registro de los datos  " + idProveedor);
            return;
        }

        Proveedor proveedor = proveedorOpt.get();

        // Crear el producto
        Producto producto = new Producto(nombre, descripcion, precio, stock, proveedor);

        // Guardar en BD
        productoServicio.guardar(producto);

    }
}