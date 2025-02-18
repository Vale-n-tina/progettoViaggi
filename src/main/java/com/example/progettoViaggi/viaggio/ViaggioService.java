package com.example.progettoViaggi.viaggio;


import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class ViaggioService {

    private final ViaggioRepository viaggioRepository;


    public ViaggioResponseComplete findById(@PathVariable Long id) {
        if (!viaggioRepository.existsById(id)) {
            throw new EntityNotFoundException("Dipendente con id " + id + " non trovato");
        }
        Viaggio viaggio = viaggioRepository.getById(id);
        ViaggioResponseComplete viaggioResponseComplete = new ViaggioResponseComplete();
        BeanUtils.copyProperties(viaggio, viaggioResponseComplete);
        return viaggioResponseComplete;

    }


    public List<Viaggio> findAll() {
        return viaggioRepository.findAll();

    }

    public ViaggioResponseId modificaStatoViaggio(ModificaStatoViaggioRequest request) {
        Viaggio viaggio = viaggioRepository.findById(request.getViaggioId()).orElseThrow(() -> new EntityNotFoundException("Viaggio con id " + request.getViaggioId() + " non trovato"));
         viaggio.setStato(request.getNuovoStato());
        viaggioRepository.save(viaggio);
        ViaggioResponseId viaggioResponseId = new ViaggioResponseId();
        viaggioResponseId.setId(viaggio.getId());
        return viaggioResponseId;
    }


    public ViaggioResponseId create(@Valid ViaggioRequest request) {
        if (viaggioRepository.existsByData(request.getData())) {
            throw new IllegalArgumentException("Un viaggio per quella data è gia stato creato");
        }

        Viaggio viaggio = new Viaggio();
        BeanUtils.copyProperties(request, viaggio);
       viaggioRepository.save(viaggio);
       ViaggioResponseId viaggioResponseId = new ViaggioResponseId();
        BeanUtils.copyProperties(viaggio, viaggioResponseId);
        return viaggioResponseId;
    }

    public ViaggioResponseComplete update(Long id, ViaggioRequest request) {
        if (!viaggioRepository.existsById(id)) {
            throw new EntityNotFoundException("Viaggio con id " + id + " non trovato");
        }
        Viaggio viaggio = viaggioRepository.findById(id).get();
        BeanUtils.copyProperties(request, viaggio);
        viaggioRepository.save(viaggio);
       ViaggioResponseComplete viaggioResponseComplete = new ViaggioResponseComplete();
        BeanUtils.copyProperties(viaggio, viaggioResponseComplete);
        return viaggioResponseComplete;

    }

    public void delete(@PathVariable Long id) {
        if (!viaggioRepository.existsById(id)) {
            throw new EntityNotFoundException("Viaggio con id " + id + " non trovato");
        }
        viaggioRepository.deleteById(id);
    }

}
