package com.gestimo.utilisateur;

import com.gestimo.abstract_entity.AbstractEntity;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.role.Role;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Utilisateur  implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @CreatedDate
  private LocalDateTime creationDdate;
  private Long idCreateur;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;
  @ManyToOne
  @JoinColumn(name = "id_agence", referencedColumnName = "id")
  private AgenceImmobiliere idAgence;

  private LocalDateTime dateDeNaissance;
  private LocalDateTime dateDebutPiece;
  private LocalDateTime dateFinPiece;
  private String email;
  private String nomEtPrenomS;
  private String motDePasse;
  private String telephone;
  private String pieceIdentite;
  private boolean enabled = true;
  private boolean accountlocked = false;

  @Override
  public String getPassword() {
    return motDePasse;
  }

  @Override
  public String getUsername() {
    return telephone;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !accountlocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
        .flatMap(role -> role.getPermissions().stream())
        .collect(Collectors.toSet());
  }

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

}
