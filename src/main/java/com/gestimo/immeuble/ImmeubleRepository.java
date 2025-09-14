package com.gestimo.immeuble;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmeubleRepository extends JpaRepository<Immeuble, Long> {
}