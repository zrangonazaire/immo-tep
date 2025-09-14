package com.gestimo.hibernate_sequence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HibernateSequenceRepository extends JpaRepository<HibernateSequence, Long> {
}