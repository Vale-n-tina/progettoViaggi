package com.example.progettoViaggi.prenotazione;


import com.example.progettoViaggi.dipendente.Dipendente;
import com.example.progettoViaggi.viaggio.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "prenotazione")
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;
    @OneToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;
    private Date dataRichiesta;
    private String preferenze;

}
