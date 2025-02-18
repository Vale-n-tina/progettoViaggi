package com.example.progettoViaggi.prenotazione;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazione")
@RequiredArgsConstructor
public class PrenotazioneController {
    public final PrenotazioneService prenotazioneService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Prenotazione> findAll() {
        return prenotazioneService.findAll();

    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PrenotazioneResponseComplete findById(@PathVariable Long id) {
        return prenotazioneService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneResponseId create(@RequestBody PrenotazioneRequest request) {
        return prenotazioneService.create(request);
    }
    @PostMapping("/assegna")
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneResponseId assegnaDipendente(@RequestBody AssegnaDipendenteRequest request) {
        return prenotazioneService.assegnaDipendente(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PrenotazioneResponseComplete update(@PathVariable Long id, @RequestBody PrenotazioneRequest request) {
        return prenotazioneService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        prenotazioneService.delete(id);
    }
}
