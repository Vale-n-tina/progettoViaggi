package com.example.progettoViaggi.dipendente;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Validated
@ControllerAdvice
@Service
@RequiredArgsConstructor
public class DipendenteService {
    private final DipendenteRepository dipendenteRepository;


    public DipendenteResponseComplete findById(@PathVariable Long id) {
        if (!dipendenteRepository.existsById(id)) {
            throw new EntityNotFoundException("Dipendente con id " + id + " non trovato");
        }
        Dipendente dipendente = dipendenteRepository.getById(id);
        DipendenteResponseComplete dipendenteResponseComplete = new DipendenteResponseComplete();
        BeanUtils.copyProperties(dipendente, dipendenteResponseComplete);
        return dipendenteResponseComplete;

    }


    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();

    }


    public DipendenteResponseId create(@Valid DipendenteRequest request) {
        if (dipendenteRepository.existsByUsernameIgnoreCase(request.getUsername())) {
            throw new IllegalArgumentException("Username già esistente");
        }
        if (dipendenteRepository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new IllegalArgumentException("Utente gia registrato con questa email");
        }
        Dipendente dipendente = new Dipendente();
        BeanUtils.copyProperties(request, dipendente);
        dipendenteRepository.save(dipendente);
        DipendenteResponseId dipendenteResponseId = new DipendenteResponseId();
        BeanUtils.copyProperties(dipendente, dipendenteResponseId);
        return dipendenteResponseId;
    }

    public DipendenteResponseComplete update(Long id,DipendenteRequest request) {
        if (!dipendenteRepository.existsById(id)) {
            throw new EntityNotFoundException("Dipendente con id " + id + " non trovato");
        }
        Dipendente dipendente= dipendenteRepository.findById(id).get();
        BeanUtils.copyProperties(request, dipendente);
        dipendenteRepository.save(dipendente);
        DipendenteResponseComplete dipendenteResponseComplete = new DipendenteResponseComplete();
        BeanUtils.copyProperties(dipendente, dipendenteResponseComplete);
        return dipendenteResponseComplete;

    }
  public void delete(@PathVariable Long id) {
        if(!dipendenteRepository.existsById(id)) {
            throw new EntityNotFoundException("Dipendente con id " + id + " non trovato");
        }
        dipendenteRepository.deleteById(id);
  }


}
