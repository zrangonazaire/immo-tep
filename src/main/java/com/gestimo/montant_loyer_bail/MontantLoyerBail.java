package com.gestimo.montant_loyer_bail;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;


@Entity
@Table(name = "montant_loyer_bail")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MontantLoyerBail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private Double ancien_montant_loyer;
    private LocalDateTime debut_loyer;
    private LocalDateTime fin_loyer;
    private Double montant_augmentation;
    private Double nouveau_montant_loyer;
    private String status_loyer;
    private Double taux_loyer;
    private Long bail_location_id;
}