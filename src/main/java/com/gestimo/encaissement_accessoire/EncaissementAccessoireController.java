package com.gestimo.encaissement_accessoire;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/encaissement_accessoire")
public class EncaissementAccessoireController {
    private final EncaissementAccessoireRepository repository;

    public EncaissementAccessoireController(EncaissementAccessoireRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EncaissementAccessoire> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public EncaissementAccessoire findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public EncaissementAccessoire create(@RequestBody EncaissementAccessoire obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public EncaissementAccessoire update(@PathVariable Long id, @RequestBody EncaissementAccessoire obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}