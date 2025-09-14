package com.gestimo.hibernate_sequence;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "hibernate_sequence")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class HibernateSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long next_val;
}