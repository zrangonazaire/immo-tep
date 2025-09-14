package com.gestimo.etage;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etage")
public class EtageController {
    private final EtageRepository repository;

    public EtageController(EtageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Etage> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Etage findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Etage create(@RequestBody Etage obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Etage update(@PathVariable Long id, @RequestBody Etage obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}