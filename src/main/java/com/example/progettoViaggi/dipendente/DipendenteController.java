package com.example.progettoViaggi.dipendente;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dipendente")
@RequiredArgsConstructor
public class DipendenteController {
    public final DipendenteService dipendenteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Dipendente> findAll() {
        return dipendenteService.findAll();

    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DipendenteResponseComplete findById(@PathVariable Long id) {
        return dipendenteService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteResponseId create(@RequestBody DipendenteRequest dipendenteRequest) {
        return dipendenteService.create(dipendenteRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DipendenteResponseComplete update(@PathVariable Long id, @RequestBody DipendenteRequest request) {
        return dipendenteService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        dipendenteService.delete(id);
    }
}
