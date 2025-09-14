package com.gestimo.etablissement_utilisateur;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.etablissement.Etablissement;


@Entity
@Table(name = "etablissement_utilisateur")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EtablissementUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private String etable_default;
    @ManyToOne
    @JoinColumn(name = "etabl_id", referencedColumnName = "id")
    private Etablissement etabl_id;
    private Long utilisateur_etabl_id;
}