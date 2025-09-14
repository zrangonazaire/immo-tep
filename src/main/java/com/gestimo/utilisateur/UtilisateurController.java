package com.gestimo.utilisateur;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    private final UtilisateurRepository repository;

    public UtilisateurController(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Utilisateur> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Utilisateur findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}