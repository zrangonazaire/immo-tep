package com.gestimo.facture;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.contrat_reservation.ContratReservation;


@Entity
@Table(name = "facture")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private String payment_status;
    private Double total_amount;
    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private ContratReservation reservation_id;
}