package com.gestimo.pays;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pays")
public class PaysController {
    private final PaysRepository repository;

    public PaysController(PaysRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pays> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Pays findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Pays create(@RequestBody Pays obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Pays update(@PathVariable Long id, @RequestBody Pays obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}