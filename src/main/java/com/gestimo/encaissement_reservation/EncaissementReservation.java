package com.gestimo.encaissement_reservation;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;


@Entity
@Table(name = "encaissement_reservation")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EncaissementReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private LocalDateTime date_encaissement;
    private Double encien_sold_reservation;
    private String mode_paiement;
}