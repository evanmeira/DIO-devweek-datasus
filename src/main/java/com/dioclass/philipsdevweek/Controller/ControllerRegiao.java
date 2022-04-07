package com.dioclass.philipsdevweek.Controller;

import com.dioclass.philipsdevweek.Entity.Regiao;
import com.dioclass.philipsdevweek.Repo.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRegiao {

    private final RegiaoRepo regiaoRepo;

    public ControllerRegiao(RegiaoRepo regiaoRepo) {
        this.regiaoRepo = regiaoRepo;
    }

    @GetMapping("/regiao")
    public List<Regiao> getRegiao(){
        return this.regiaoRepo.findAll();
    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id){
        Optional<Regiao> regiaoOpt = this.regiaoRepo.findById(id);

        if(regiaoOpt.isPresent()){
            return new ResponseEntity<>( regiaoOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public Regiao putRegiao(@RequestBody Regiao regiao){
        return this.regiaoRepo.save(regiao);
    }

    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        this.regiaoRepo.deleteById(id);
    }
}
