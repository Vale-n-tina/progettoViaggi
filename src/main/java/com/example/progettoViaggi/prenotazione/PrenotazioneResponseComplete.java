package com.example.progettoViaggi.prenotazione;


import com.example.progettoViaggi.dipendente.DipendenteResponseId;
import com.example.progettoViaggi.viaggio.ViaggioResponseId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneResponseComplete {
    private Date dataRichiesta;
    private String preferenze;
    private ViaggioResponseId viaggio;
    private DipendenteResponseId dipendente;


}
