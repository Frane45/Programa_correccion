package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medicos")


public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<String> RegistraMedico(@Valid @RequestBody DatosRegistroMedico datosRegistroMedico) {
        medicoRepository.save(new Medico(datosRegistroMedico));
        return ResponseEntity.ok("Medico registrado exitosamente");


    }

    @GetMapping
    public Page<DatosListadoMedicos> ListadoMedico(@PageableDefault(size = 2) Pageable paginacion) {
        //return medicoRepository.findAll(paginacion).map(DatosListadoMedicos::new);
        return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedicos::new);
    }

    // DELETE LOGICO
    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }

    // DELETE LOGIC@DeleteMapping("/{id}")
   @Transactional
    public void eliminarMedico(@PathVariable Long id) {
       Medico medico = medicoRepository.getReferenceById(id);
        medico.desActivarMedico();
    }
}




// DELETE EN BASE DE DATOS
//@DeleteMapping("/{id}")
//@Transactional
//public void eliminarMedico(@PathVariable Long id) {
//Medico medico = medicoRepository.getReferenceById(id);
//medicoRepository.delete(medico);


//}
