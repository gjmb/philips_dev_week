package com.dio_class.philips_dev_week.Controller;

import com.dio_class.philips_dev_week.Entity.Incidencia;
import com.dio_class.philips_dev_week.Entity.Regiao;
import com.dio_class.philips_dev_week.Repository.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerIncidencia {
    private final IncidenciaRepo irepository;

    public ControllerIncidencia(IncidenciaRepo irepository) {
        this.irepository = irepository;
    }

    @GetMapping("/incidencia")
    public ResponseEntity<List<Incidencia>> findIncidencia(){
        List<Incidencia> listaIncidencia = irepository.findAll();
        if (listaIncidencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/ocorrencia/{id}")
    public ResponseEntity<Incidencia> findOcorrenciasById(@PathVariable Long id){
        Optional<Incidencia> ocorrenciaOptional = irepository.findById(id);
        if (ocorrenciaOptional.isPresent()){
            Incidencia ocorrenciaUnid = ocorrenciaOptional.get();
            return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public Incidencia newIncidencia(@RequestBody Incidencia newIncidencia){
        return irepository.save(newIncidencia);
    }


}
