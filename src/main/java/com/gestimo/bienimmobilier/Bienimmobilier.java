package com.gestimo.bienimmobilier;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;


@Entity
@Table(name = "bienimmobilier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bienimmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type_bien_immobilier;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private String bien_meubler_residence;
    private String code_abrv_bien_immobilier;
}