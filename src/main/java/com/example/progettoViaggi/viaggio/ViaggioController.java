package com.example.progettoViaggi.viaggio;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaggio")
@RequiredArgsConstructor
public class ViaggioController {

    private final ViaggioService viaggioService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Viaggio> findAll() {
        return viaggioService.findAll();

    }
    @PutMapping("/modificaStato")
    @ResponseStatus(HttpStatus.OK)
    public ViaggioResponseId modificaStatoViaggio(@RequestBody ModificaStatoViaggioRequest request) {
        return viaggioService.modificaStatoViaggio(request);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ViaggioResponseComplete findById(@PathVariable Long id) {
        return viaggioService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioResponseId create(@RequestBody ViaggioRequest request) {
        return viaggioService.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ViaggioResponseComplete update(@PathVariable Long id, @RequestBody ViaggioRequest request) {
        return viaggioService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        viaggioService.delete(id);
    }
}
