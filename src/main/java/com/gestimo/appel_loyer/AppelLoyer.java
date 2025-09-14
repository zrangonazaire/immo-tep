package com.gestimo.appel_loyer;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;


@Entity
@Table(name = "appel_loyer")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AppelLoyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private Integer annee_appel_loyer;
    private LocalDateTime date_debut_mois_appel_loyer;
    private LocalDateTime date_fin_mois_appel_loyer;
    private LocalDateTime date_paiement_prevu_appel_loyer;
    private String desc_appel_loyer;
}