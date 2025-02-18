package com.example.progettoViaggi.prenotazione;


import com.example.progettoViaggi.dipendente.Dipendente;
import com.example.progettoViaggi.dipendente.DipendenteRepository;
import com.example.progettoViaggi.viaggio.Viaggio;
import com.example.progettoViaggi.viaggio.ViaggioRepository;
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
public class PrenotazioneService {
    private final PrenotazioneRepository prenotazioneRepository;
    private final ViaggioRepository viaggioRepository;
    private final DipendenteRepository dipendenteRepository;


    public PrenotazioneResponseComplete findById(@PathVariable Long id) {
        if (!prenotazioneRepository.existsById(id)) {
            throw new EntityNotFoundException("Prenotazione con id " + id + " non trovato");
        }
        Prenotazione prenotazione = prenotazioneRepository.getById(id);
        PrenotazioneResponseComplete prenotazioneResponseComplete = new PrenotazioneResponseComplete();
        BeanUtils.copyProperties(prenotazione, prenotazioneResponseComplete);
        return prenotazioneResponseComplete;

    }


    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();

    }

    public PrenotazioneResponseId assegnaDipendente(@Valid AssegnaDipendenteRequest request) {
        Dipendente dipendente = dipendenteRepository.findById(request.getDipendenteId())
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato"));

        Viaggio viaggio = viaggioRepository.findById(request.getViaggioId())
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato"));


        //TODO:Qui metto la verifica che il dipendente non abbia già in programma un altro viaggio
        if (prenotazioneRepository.existsByDipendente_id(request.getDipendenteId())) {
            throw new IllegalArgumentException("Il dipendente è già assegnato a un altro viaggio.");
        }
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazioneRepository.save(prenotazione);
        PrenotazioneResponseId response = new PrenotazioneResponseId();
        response.setId(prenotazione.getId());
        return response;
    }

    public PrenotazioneResponseId create(@Valid PrenotazioneRequest request) {
        //TODO:Qui metto la verifica che il dipendente non abbia già in programma un altro viaggio
        if (prenotazioneRepository.existsByDipendente_id(request.getDipendenteId())) {
            throw new IllegalArgumentException("il dipendente inserito ha già un viaggio in programma");
        }

        Viaggio viaggio = viaggioRepository.findById(request.getViaggioId())
                .orElseThrow(() -> new EntityNotFoundException("Viaggio con id " + request.getViaggioId() + " non trovato"));
        Dipendente dipendente = dipendenteRepository.findById(request.getDipendenteId())
                .orElseThrow(() -> new EntityNotFoundException("Dipendente con id " + request.getDipendenteId() + " non trovato"));

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setViaggio(viaggio);
        prenotazione.setDipendente(dipendente);
        prenotazione.setDataRichiesta(request.getDataRichiesta());
        prenotazione.setPreferenze(request.getPreferenze());


        prenotazioneRepository.save(prenotazione);

        PrenotazioneResponseId prenotazioneResponseId = new PrenotazioneResponseId();
        BeanUtils.copyProperties(prenotazione, prenotazioneResponseId);
        return prenotazioneResponseId;
    }

    public PrenotazioneResponseComplete update(Long id, PrenotazioneRequest request) {
        if (!prenotazioneRepository.existsById(id)) {
            throw new EntityNotFoundException("Prenotazione con id " + id + " non trovato");
        }
        Prenotazione prenotazione = prenotazioneRepository.findById(id).get();
        BeanUtils.copyProperties(request, prenotazione);
        prenotazioneRepository.save(prenotazione);
        PrenotazioneResponseComplete prenotazioneResponseComplete = new PrenotazioneResponseComplete();
        BeanUtils.copyProperties(prenotazione, prenotazioneResponseComplete);
        return prenotazioneResponseComplete;

    }

    public void delete(@PathVariable Long id) {
        if (!prenotazioneRepository.existsById(id)) {
            throw new EntityNotFoundException("Prenotazione con id " + id + " non trovato");
        }
        prenotazioneRepository.deleteById(id);
    }

}
