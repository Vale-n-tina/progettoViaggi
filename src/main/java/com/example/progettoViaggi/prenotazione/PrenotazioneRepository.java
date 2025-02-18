package com.example.progettoViaggi.prenotazione;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    public boolean existsByDipendente_id(Long dipendenteId);
}
