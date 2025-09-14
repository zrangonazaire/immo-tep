package com.gestimo.chapitre;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chapitre")
public class ChapitreController {
    private final ChapitreRepository repository;

    public ChapitreController(ChapitreRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Chapitre> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Chapitre findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Chapitre create(@RequestBody Chapitre obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Chapitre update(@PathVariable Long id, @RequestBody Chapitre obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}