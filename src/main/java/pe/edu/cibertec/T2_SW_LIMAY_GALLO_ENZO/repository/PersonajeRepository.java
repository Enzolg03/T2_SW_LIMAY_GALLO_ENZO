package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.model.bd.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {
}
