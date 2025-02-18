package com.example.progettoViaggi.viaggio;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModificaStatoViaggioRequest {
    @NotNull(message = "Il campo viaggioId non può essere null")
    private Long viaggioId;
    @NotNull(message = "Il campo nuovoStato non può essere null")
    private StatoViaggio nuovoStato;
}
