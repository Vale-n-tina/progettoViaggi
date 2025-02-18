package com.example.progettoViaggi.dipendente;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    public boolean existsByUsernameIgnoreCase(String username);
    public boolean existsByEmailIgnoreCase(String email);
}
