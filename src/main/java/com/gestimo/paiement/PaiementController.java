package com.gestimo.paiement;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paiement")
public class PaiementController {
    private final PaiementRepository repository;

    public PaiementController(PaiementRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Paiement> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Paiement findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Paiement create(@RequestBody Paiement obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Paiement update(@PathVariable Long id, @RequestBody Paiement obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}