package com.gestimo.encaissement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EncaissementRepository extends JpaRepository<Encaissement, Long> {
}