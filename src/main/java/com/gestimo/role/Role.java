package com.gestimo.role;

import com.gestimo.abstract_entity.AbstractEntity;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends AbstractEntity {

  @ManyToOne
  @JoinColumn(name = "id_agence", referencedColumnName = "id")
  private AgenceImmobiliere id_agence;

  private String description_role;
}
