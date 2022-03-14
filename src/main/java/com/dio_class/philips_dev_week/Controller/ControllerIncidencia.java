package com.dio_class.philips_dev_week.Controller;

import com.dio_class.philips_dev_week.Entity.IncidenciaExame;
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
    public ResponseEntity<List<IncidenciaExame>> findIncidencia(){
        List<IncidenciaExame> listaIncidencia = irepository.findAll();
        if (listaIncidencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<IncidenciaExame> findOcorrenciasById(@PathVariable Long id){
        Optional<IncidenciaExame> incidenciaOptional = irepository.findById(id);
        if (incidenciaOptional.isPresent()){
            IncidenciaExame incidenciaUnid = incidenciaOptional.get();
            return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public IncidenciaExame newIncidencia(@RequestBody IncidenciaExame newIncidencia){
        return irepository.save(newIncidencia);
    }


}
