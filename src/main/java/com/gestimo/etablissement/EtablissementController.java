package com.gestimo.etablissement;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etablissement")
public class EtablissementController {
    private final EtablissementRepository repository;

    public EtablissementController(EtablissementRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Etablissement> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Etablissement findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Etablissement create(@RequestBody Etablissement obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Etablissement update(@PathVariable Long id, @RequestBody Etablissement obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}