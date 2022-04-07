package com.dioclass.philipsdevweek.Controller;

import com.dioclass.philipsdevweek.Entity.FaixaEtaria;
import com.dioclass.philipsdevweek.Repo.FaixaEtariaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerFaixaEtaria {

    private final FaixaEtariaRepo faixaEtariaRepo;

    public ControllerFaixaEtaria(FaixaEtariaRepo faixaEtariaRepo) {
        this.faixaEtariaRepo = faixaEtariaRepo;
    }

    @GetMapping("/faixaetaria")
    public List<FaixaEtaria> getFaixaEtaria(){
        return this.faixaEtariaRepo.findAll();
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> getFaixaEtariaById(@PathVariable Long id){
        Optional<FaixaEtaria> faixaOpt = this.faixaEtariaRepo.findById(id);

        if(faixaOpt.isPresent()){
            return new ResponseEntity<>(faixaOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria putFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria){
        return this.faixaEtariaRepo.save(faixaEtaria);
    }

    @DeleteMapping("faixaetaria/delete/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id){
        this.faixaEtariaRepo.deleteById(id);
    }
}
