package com.gestimo.categorie_chambre;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorie_chambre")
public class CategorieChambreController {
    private final CategorieChambreRepository repository;

    public CategorieChambreController(CategorieChambreRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CategorieChambre> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public CategorieChambre findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public CategorieChambre create(@RequestBody CategorieChambre obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public CategorieChambre update(@PathVariable Long id, @RequestBody CategorieChambre obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}