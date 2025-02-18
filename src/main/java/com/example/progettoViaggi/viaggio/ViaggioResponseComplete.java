package com.example.progettoViaggi.viaggio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioResponseComplete {
    private Long id;
    private String destinazione;
    private Date data;
    private StatoViaggio Stato;
}
