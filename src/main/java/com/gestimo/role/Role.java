package com.gestimo.role;

import com.gestimo.abstract_entity.AbstractEntity;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.permission.Permission;

import jakarta.persistence.*;
import java.util.Set;

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

  private String descriptionRole;
  private String nomRole;
      @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_permissions",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;
}
