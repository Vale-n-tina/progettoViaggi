package com.example.progettoViaggi.viaggio;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
 public boolean existsByData(Date data);
}
