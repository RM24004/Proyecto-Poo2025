package Poo_2025.Inventario;

import Poo_2025.Inventario.Modelo.Producto;
import Poo_2025.Inventario.Repositorio.Producto_Repositorio;
import Poo_2025.Inventario.Servicio.Producto_Servicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Producto_ServicioTest {
    @Mock
    private Producto_Repositorio productoRepo;
    @InjectMocks
    private Producto_Servicio productoServicio;
    @Test
    void testGuardarProducto() {
        Producto producto = new Producto();
        producto.setNombre("Laptop");
        when(productoRepo.save(producto)).thenReturn(producto);
        Producto resultado = productoServicio.guardar(producto);
        assertEquals("Laptop", resultado.getNombre());
        verify(productoRepo).save(producto);
    }
    @Test
    void testObtenerPorIdExistente() {
        Producto producto = new Producto();
        producto.setIdProducto(1);
        when(productoRepo.findById(1)).thenReturn(Optional.of(producto));
        Producto resultado = productoServicio.obtenerPorId(1);
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdProducto());
    }
    @Test
    void testObtenerPorIdNoExistente() {
        when(productoRepo.findById(99)).thenReturn(Optional.empty());
        Producto resultado = productoServicio.obtenerPorId(99);
        assertNull(resultado);
    }
    @Test
    void testActualizarProductoExistente() {
        Producto original = new Producto();
        original.setIdProducto(1);
        original.setNombre("CPU");
        Producto actualizado = new Producto();
        actualizado.setNombre("CPU Gamer");
        when(productoRepo.findById(1)).thenReturn(Optional.of(original));
        when(productoRepo.save(any())).thenReturn(original);
        Producto resultado = productoServicio.actualizar(1, actualizado);
        assertEquals("CPU Gamer", resultado.getNombre());
    }

    @Test
    void testEliminarProductoExistente() {
        when(productoRepo.existsById(1)).thenReturn(true);
        boolean resultado = productoServicio.eliminar(1);
        assertTrue(resultado);
        verify(productoRepo).deleteById(1);
    }
    @Test
    void testEliminarProductoNoExistente() {
        when(productoRepo.existsById(99)).thenReturn(false);
        boolean resultado = productoServicio.eliminar(99);
        assertFalse(resultado);
        verify(productoRepo, never()).deleteById(anyInt());
    }
}