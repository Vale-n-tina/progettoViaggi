package com.example.progettoViaggi.dipendente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteResponseComplete {
    private Long id;
    private String nome;
    private String cognome;
    private String username;
    private String email;

}
