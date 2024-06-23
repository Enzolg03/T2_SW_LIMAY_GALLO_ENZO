package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.service;

import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.model.bd.Personaje;

import java.util.List;
import java.util.Optional;

public interface IPersonajeService {
    List<Personaje> listarPersonajes();
    Personaje guardarPersonaje(Personaje personaje);
    Optional<Personaje> obtenerPersonajeXId(Integer id);
}
