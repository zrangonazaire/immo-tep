package com.gestimo.client_hotel;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.services_hotel.ServicesHotel;
import java.util.List;


@Entity
@Table(name = "client_hotel")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ClientHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creation_date;
    @ManyToOne
    @JoinColumn(name = "id_agence", referencedColumnName = "id")
    private AgenceImmobiliere id_agence;
    private Long id_createur;
    private LocalDateTime last_modified_date;
    private String addres;

    @OneToMany(mappedBy = "client_hotel_id")
    private List<ServicesHotel> services_hotel_list;

}