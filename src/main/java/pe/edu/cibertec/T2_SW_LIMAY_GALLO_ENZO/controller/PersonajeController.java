package pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.model.bd.Personaje;
import pe.edu.cibertec.T2_SW_LIMAY_GALLO_ENZO.service.PersonajeService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/personaje")
public class PersonajeController {
    private PersonajeService personajeService;

    @GetMapping("")
    public ResponseEntity<List<Personaje>> listarPersonaje(){
        List<Personaje> personajeList = new ArrayList<>(personajeService.listarPersonajes());
        if(personajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personajeList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Personaje> obtenerPersonajeXId(
            @PathVariable Integer id){
        Personaje category = personajeService
                .obtenerPersonajeXId(id).orElseThrow(
                        () -> new ResourceNotFoundException(
                                "El personaje con Id "+
                                        id + " no existe"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Personaje> registrarCategoria(
            @RequestBody Personaje personaje
    ){
        return new ResponseEntity<>(
                personajeService.guardarPersonaje(personaje), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Personaje> actualizarPersonaje(
            @PathVariable Integer id,
            @RequestBody Personaje personaje
    ){
        Personaje nuevoPersonaje = personajeService.obtenerPersonajeXId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La personaje sin Id" +
                        + id + " no existe"));
        nuevoPersonaje.setNompersonaje(personaje.getNompersonaje());
        nuevoPersonaje.setApepersonaje(personaje.getApepersonaje());
        nuevoPersonaje.setFechnacpersonaje(personaje.getFechnacpersonaje());
        return new ResponseEntity<>(
                personajeService.guardarPersonaje(nuevoPersonaje),
                HttpStatus.OK);
    }
}
