package Poo_2025.Inventario.Acciones;

import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Servicio.Tipo_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Registro_Tipo {
    @Autowired
    private Tipo_Servicio tipoServicio;
    public void registrar() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del tipo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la descripción del tipo: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el Efecto del tipo: ");
        String efecto = scanner.nextLine();

        Tipo tipo = new Tipo(nombre, descripcion, efecto);

        tipoServicio.guardar(tipo);

        System.out.println("Tipo de movimiento registrado con éxito.");
    }
}
