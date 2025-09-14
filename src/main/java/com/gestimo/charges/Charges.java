package com.gestimo.charges;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;


@Entity
@Table(name = "charges")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Charges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private Double augmentation_charge;
    private LocalDateTime debut_charge;
    private LocalDateTime fin_charge;
    private Double montant_charge;
    private Double taux_charge;
    private Integer type_charge;
    private Long bail_locataire_charge_id;
}