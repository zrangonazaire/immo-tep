package com.gestimo.cron_mail;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;


@Entity
@Table(name = "cron_mail")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CronMail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private Integer day_of_month;
    private String is_donne;
    private LocalDateTime next_date_mail;
}