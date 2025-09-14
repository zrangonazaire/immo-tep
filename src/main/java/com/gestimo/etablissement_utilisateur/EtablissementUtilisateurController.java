package com.gestimo.etablissement_utilisateur;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etablissement_utilisateur")
public class EtablissementUtilisateurController {
    private final EtablissementUtilisateurRepository repository;

    public EtablissementUtilisateurController(EtablissementUtilisateurRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EtablissementUtilisateur> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public EtablissementUtilisateur findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public EtablissementUtilisateur create(@RequestBody EtablissementUtilisateur obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public EtablissementUtilisateur update(@PathVariable Long id, @RequestBody EtablissementUtilisateur obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}