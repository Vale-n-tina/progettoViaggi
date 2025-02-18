package com.example.progettoViaggi.viaggio;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioRequest {
    @NotBlank(message = "Il nome del viaggio non può essere vuoto")
    private String destinazione;
    @Future(message = "La data di partenza non può essere nel passato")
    private Date data;
    private StatoViaggio Stato;
}
