package com.gestimo.services_hotel;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.client_hotel.ClientHotel;
import com.gestimo.prestation_hotel.PrestationHotel;


@Entity
@Table(name = "services_hotel")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ServicesHotel {
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
    @JoinColumn(name = "client_hotel_id", referencedColumnName = "id")
    private ClientHotel client_hotel_id;
    @ManyToOne
    @JoinColumn(name = "prestation_hotel_id", referencedColumnName = "id")
    private PrestationHotel prestation_hotel_id;
}