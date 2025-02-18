package com.example.progettoViaggi.prenotazione;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneRequest {
    @NotNull(message = "Il campo 'viaggioId' non può essere nullo")
    private Long viaggioId;
    @NotNull(message = "Il campo 'dipendenteId' non può essere nullo")
    private Long dipendenteId;
    @Future(message = "La data richiesta non può essere nel passato")
    private Date dataRichiesta;
    private String preferenze;
}
