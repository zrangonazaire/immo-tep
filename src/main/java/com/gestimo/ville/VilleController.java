package com.gestimo.ville;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ville")
public class VilleController {
    private final VilleRepository repository;

    public VilleController(VilleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Ville> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Ville findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Ville create(@RequestBody Ville obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Ville update(@PathVariable Long id, @RequestBody Ville obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}