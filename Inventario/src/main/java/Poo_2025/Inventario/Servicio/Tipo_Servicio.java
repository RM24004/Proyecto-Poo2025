package Poo_2025.Inventario.Servicio;

import Poo_2025.Inventario.Modelo.Tipo;
import Poo_2025.Inventario.Repositorio.Tipo_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Tipo_Servicio {
    @Autowired
    private Tipo_Repositorio tipoRepo;

    // Guardar un Tipo
    public  void guardar(Tipo tipo) {
        tipoRepo.save(tipo);
    }
    // Listar todos Tipos
    public List<Tipo> listar() {
        return tipoRepo.findAll();
    }
    // Eliminar un Tipo por ID
    public void eliminar(Integer id) {
        tipoRepo.deleteById(id);
    }
}
