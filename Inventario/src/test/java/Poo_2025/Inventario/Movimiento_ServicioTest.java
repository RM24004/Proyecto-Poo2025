package Poo_2025.Inventario;

import Poo_2025.Inventario.Modelo.Movimiento;
import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Repositorio.Movimiento_Repositorio;
import Poo_2025.Inventario.Repositorio.Producto_Repositorio;
import Poo_2025.Inventario.Repositorio.Tipo_Repositorio;
import Poo_2025.Inventario.Servicio.Movimiento_Servicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovimientoServicioTest {

    @Mock
    private Movimiento_Repositorio movimientoRepo;

    @Mock
    private Producto_Repositorio productoRepo;

    @Mock
    private Tipo_Repositorio tipoRepo;

    @InjectMocks
    private Movimiento_Servicio movimientoServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    // TEST: Registrar movimiento de entrada exitosamente

    @Test
    void registrarMovimiento_Entrada_Exito() {

        // ======= Datos de producto y tipo =========
        Producto producto = new Producto();
        producto.setIdProducto(1);
        producto.setStockActual(10.0);

        Tipo tipo = new Tipo();
        tipo.setId(1);
        tipo.setEfectoStock("entrada");

        Movimiento mov = new Movimiento();
        mov.setCantidad(5.0);
        mov.setProducto(producto);
        mov.setTipo(tipo);

        // ======= Configuración de Mocks ===========
        when(productoRepo.findById(1)).thenReturn(Optional.of(producto));
        when(tipoRepo.findById(1)).thenReturn(Optional.of(tipo));
        when(movimientoRepo.save(any(Movimiento.class))).thenAnswer(i -> i.getArgument(0));

        // ======= Ejecutar =======
        Movimiento resultado = movimientoServicio.registrarMovimiento(mov);

        // ======= Validar =========
        assertNotNull(resultado);
        assertEquals(15, producto.getStockActual());   // 10 + 5 evaluamos si es igual al cambio

        verify(productoRepo).save(producto);           // se guardó el producto
        verify(movimientoRepo).save(mov);              // se guardó el movimiento
    }
}
