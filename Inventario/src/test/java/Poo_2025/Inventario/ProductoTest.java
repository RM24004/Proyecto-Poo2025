package Poo_2025.Inventario;
import Poo_2025.Inventario.Servicio.Producto_Servicio;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import Poo_2025.Inventario.DTO.DTO_Producto;
import Poo_2025.Inventario.Modelo.Proveedor;
import Poo_2025.Inventario.Repositorio.Proveedor_Repositorio;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductoTest {

    @Autowired
    private final Producto_Servicio productoServicio;

    @Autowired
    private final Proveedor_Repositorio proveedorRepo;

    @Test
    void crear_producto_test() {
        // Crear un proveedor de prueba
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Proveedor de prueba");
        proveedor.setDireccion("Calle Falsa 123");
        proveedor.setEmail("asdas@gmail.com");
        proveedor.setTelefono("55512348");
        proveedorRepo.save(proveedor);

        // Crear DTO con datos de producto
        DTO_Producto dto = new DTO_Producto();
        dto.setNombre("Laptop ASUS");
        dto.setDescripcion("Laptop de alto rendimiento");
        dto.setPrecioUnitario(850.0);
        dto.setStockActual(10.0);
        dto.setIdProveedor(proveedor.getId());

        // Ejecutar
        //DTO_Producto resultado= productoServicio.guardar(dto);

        // Validar resultados
        //Assertions.assertNotNull(resultado.getIdProducto(), "El ID del producto no debe ser nulo");
        //Assertions.assertEquals("Laptop ASUS", resultado.getNombre());
        //Assertions.assertEquals(proveedor.getId(), resultado.getIdProveedor());
    }
}


