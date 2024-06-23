package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.model.bd.Personaje;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.repository.PersonajeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonajeService implements IPersonajeService{
    private PersonajeRepository personajeRepository;
    @Override
    public List<Personaje> listarPersonajes() {
        return personajeRepository.findAll();
    }

    @Override
    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @Override
    public Optional<Personaje> obtenerPersonajeXId(Integer id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if(personaje.isEmpty()){
            return personaje;
        }
        return personaje;
    }
}
