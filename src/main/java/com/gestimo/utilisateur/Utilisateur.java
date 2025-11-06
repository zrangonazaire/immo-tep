package com.gestimo.utilisateur;

import com.gestimo.abstract_entity.AbstractEntity;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.role.Role;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Utilisateur extends AbstractEntity implements UserDetails {

  @ManyToOne
  @JoinColumn(name = "id_agence", referencedColumnName = "id")
  private AgenceImmobiliere id_agence;
  @Column(name = "username", length = 255)
  private String username;

  @Column(name = "date_de_naissance")
  private LocalDate dateDeNaissance;

  @Column(name = "date_debut_piece")
  private LocalDate dateDebutPiece;

  @Column(name = "date_fin_piece")
  private LocalDate dateFinPiece;

  @Column(name = "email", length = 255)
  private String email;

  @Column(name = "genre", length = 255)
  private String genre;

  @Column(name = "is_activated", nullable = false, columnDefinition = "bit(1)")
  private Boolean isActivated;

  @Column(name = "is_active", nullable = false, columnDefinition = "bit(1)")
  private Boolean isActive;

  @Column(name = "is_non_locked", nullable = false, columnDefinition = "bit(1)")
  private Boolean isNonLocked;

  @Column(name = "join_date")
  private LocalDateTime joinDate;

  @Column(name = "last_login_date")
  private LocalDateTime lastLoginDate;

  @Column(name = "last_login_date_display")
  private LocalDateTime lastLoginDateDisplay;

  @Column(name = "lieu_naissance", length = 255)
  private String lieuNaissance;

  @Column(name = "mobile", length = 255)
  private String mobile;

  // colonne avec accent dans la base : "nationalité"
  @Column(name = "nationalité", length = 255)
  private String nationaliteAvecAccent;

  @Column(name = "nom", length = 255)
  private String nom;

  @Column(name = "numero_piece_identite", length = 255)
  private String numeroPieceIdentite;

  @Column(name = "password", length = 255)
  private String password;

  @Column(name = "prenom", length = 255)
  private String prenom;

  @Column(name = "profile_image_url", length = 255)
  private String profileImageUrl;

  @Column(name = "role_used", length = 255)
  private String roleUsed;

  @Column(name = "type_piece_identite", length = 255)
  private String typePieceIdentite;

  @Column(name = "utilisateur_id_app", length = 255)
  private String utilisateurIdApp;

  // colonne "nationalite" (sans accent) également présente dans la table
  @Column(name = "nationalite", length = 255)
  private String nationalite;

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'getPassword'");
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'getUsername'");
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'isAccountNonExpired'");
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'isAccountNonLocked'");
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'isCredentialsNonExpired'");
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (roles==null && roles.getPermissions()==null) {
      return List.of();  
    }
    return roles.getPermissions()
    .stream()
    .map(p-> (GrantedAuthority) p)
    .collect(Collectors.toList());
  }

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private  Role roles;
}
