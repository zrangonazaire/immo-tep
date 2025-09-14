package com.gestimo.encaissement;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/encaissement")
public class EncaissementController {
    private final EncaissementRepository repository;

    public EncaissementController(EncaissementRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Encaissement> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Encaissement findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Encaissement create(@RequestBody Encaissement obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Encaissement update(@PathVariable Long id, @RequestBody Encaissement obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}