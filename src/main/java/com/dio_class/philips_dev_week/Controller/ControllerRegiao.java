package com.dio_class.philips_dev_week.Controller;

import com.dio_class.philips_dev_week.Entity.Regiao;
import com.dio_class.philips_dev_week.Repository.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRegiao {

    private final RegiaoRepo repository;

    public ControllerRegiao(RegiaoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/regiao")
    public List<Regiao> getRegiao(){
        return repository.findAll();
    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<Regiao> getRegiaoById(@PathVariable Long id){
        Optional<Regiao> regiaoEscolhidaOptional = repository.findById(id);
        if(regiaoEscolhidaOptional.isPresent()){
            Regiao regiaoUnid = regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public Regiao newRegiao(@RequestBody Regiao newRegiao){
        return repository.save(newRegiao);
    }

    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);
    }


}
