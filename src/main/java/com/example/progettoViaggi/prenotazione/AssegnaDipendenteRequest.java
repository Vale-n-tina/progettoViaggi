package com.example.progettoViaggi.prenotazione;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssegnaDipendenteRequest {
    private Long dipendenteId;
    private Long viaggioId;
}
