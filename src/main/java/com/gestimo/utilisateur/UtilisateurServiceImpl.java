package com.gestimo.utilisateur;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestimo.permission.Permission;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UtilisateurServiceImpl implements UserDetailsService, UtilisateurService {
    final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByTelephone(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur pas trouvé(e) " + username));
        var authorities = utilisateur.getRoles().stream().flatMap(
                role -> role.getPermissions().stream()).map(
                        Permission::getAuthority)
                .map(
                        SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        return User.withUsername(utilisateur.getTelephone())
                .password(utilisateur.getPassword())
                .authorities(authorities).disabled(!utilisateur.isEnabled())
                .build();
    }

}
