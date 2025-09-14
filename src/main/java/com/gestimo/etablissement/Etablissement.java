package com.gestimo.etablissement;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.chapitre.Chapitre;
import com.gestimo.etablissement_utilisateur.EtablissementUtilisateur;
import java.util.List;


@Entity
@Table(name = "etablissement")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    @ManyToOne
    @JoinColumn(name = "id_chapitre", referencedColumnName = "id")
    private Chapitre id_chapitre;
    private String lib_chapitre;

    @OneToMany(mappedBy = "etabl_id")
    private List<EtablissementUtilisateur> etablissement_utilisateur_list;

}