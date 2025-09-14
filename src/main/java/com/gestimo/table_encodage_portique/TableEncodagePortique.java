package com.gestimo.table_encodage_portique;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "table_encodage_portique")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TableEncodagePortique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomprenom;
}