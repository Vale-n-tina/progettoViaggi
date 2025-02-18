package com.example.progettoViaggi.viaggio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "viaggio")
@AllArgsConstructor
@NoArgsConstructor
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String destinazione;
    private Date data;
@Enumerated(EnumType.STRING)
    private StatoViaggio Stato;


}
