package com.gestimo.chapitre;
import jakarta.persistence.*;
import lombok.*;
import com.gestimo.etablissement.Etablissement;
import java.util.List;


@Entity
@Table(name = "chapitre")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Chapitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle_chapitre;

    @OneToMany(mappedBy = "id_chapitre")
    private List<Etablissement> etablissement_list;

}