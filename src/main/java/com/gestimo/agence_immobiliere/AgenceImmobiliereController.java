package com.gestimo.agence_immobiliere;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agence_immobiliere")
public class AgenceImmobiliereController {
    private final AgenceImmobiliereRepository repository;

    public AgenceImmobiliereController(AgenceImmobiliereRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AgenceImmobiliere> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public AgenceImmobiliere findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public AgenceImmobiliere create(@RequestBody AgenceImmobiliere obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public AgenceImmobiliere update(@PathVariable Long id, @RequestBody AgenceImmobiliere obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}