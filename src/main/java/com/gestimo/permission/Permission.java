package com.gestimo.permission;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomPermission;
    private String descriptionPermission;
    private String module; // Exemple: Client, Commande, Employé

    private boolean canRead;
    private boolean canWrite;
    private boolean canEdit;
    private boolean canDelete;

    @Override
    public String getAuthority() {
        return nomPermission;
    }
}
