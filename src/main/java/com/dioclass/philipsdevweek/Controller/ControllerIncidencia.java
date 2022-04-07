package com.dioclass.philipsdevweek.Controller;

import com.dioclass.philipsdevweek.Entity.Incidencia;
import com.dioclass.philipsdevweek.Repo.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerIncidencia {

    private final IncidenciaRepo incidenciaRepo;

    public ControllerIncidencia(IncidenciaRepo incidenciaRepo) {
        this.incidenciaRepo = incidenciaRepo;
    }

    @GetMapping("/incindencia")
    public List<Incidencia> getIncidiencia(){
        return this.incidenciaRepo.findAll();
    }

    @GetMapping("incidencia/{id}")
    public ResponseEntity<?> getIncidenciaById(@PathVariable long id){
        Optional<Incidencia> incidenciaOpt = this.incidenciaRepo.findById(id);

        if(incidenciaOpt.isPresent()){
            return new ResponseEntity<>(incidenciaOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public Incidencia putIncidencia(@RequestBody Incidencia incidencia){
        return this.incidenciaRepo.save(incidencia);
    }

    @DeleteMapping("/incidencia/delete/{id}")
    public void deleteIncidencia(@PathVariable Long id){
        this.incidenciaRepo.deleteById(id);
    }
}
