package com.gestimo.prestation_additionnel_reservation;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;


@Entity
@Table(name = "prestation_additionnel_reservation")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PrestationAdditionnelReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private String reservation;
    private String service_additionnelle;
    private Long id_service_additionnel;
    private Long id_resvation_service_additionnel;
}