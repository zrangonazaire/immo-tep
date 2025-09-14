package com.gestimo.encaissement;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;


@Entity
@Table(name = "encaissement")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Encaissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mode_paiement;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private LocalDateTime date_encaissement;
    private Double montant_encaissement;
    private String numero_cheque;
}