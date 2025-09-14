package com.gestimo.utilisateur;

import com.gestimo.abstract_entity.AbstractEntity;
import com.gestimo.agence_immobiliere.AgenceImmobiliere;
import com.gestimo.role.Role;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

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

  private String authorities;
  private LocalDateTime date_de_naissance;
  private LocalDateTime date_debut_piece;
  private LocalDateTime date_fin_piece;
  private String email;

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'getPassword'"
    );
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'getUsername'"
    );
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'isAccountNonExpired'"
    );
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'isAccountNonLocked'"
    );
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'isCredentialsNonExpired'"
    );
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'getAuthorities'"
    );
  }
  private Set<Role> roles;
}
