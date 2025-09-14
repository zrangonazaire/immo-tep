package com.gestimo.contrat_reservation;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.facture.Facture;
import java.util.List;


@Entity
@Table(name = "contrat_reservation")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ContratReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
    private String detail_contrat;

    @OneToMany(mappedBy = "reservation_id")
    private List<Facture> facture_list;

}