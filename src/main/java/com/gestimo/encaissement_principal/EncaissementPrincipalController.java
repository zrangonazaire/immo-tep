package com.gestimo.encaissement_principal;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/encaissement_principal")
public class EncaissementPrincipalController {
    private final EncaissementPrincipalRepository repository;

    public EncaissementPrincipalController(EncaissementPrincipalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EncaissementPrincipal> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public EncaissementPrincipal findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public EncaissementPrincipal create(@RequestBody EncaissementPrincipal obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public EncaissementPrincipal update(@PathVariable Long id, @RequestBody EncaissementPrincipal obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}