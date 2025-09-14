package com.gestimo.immeuble;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/immeuble")
public class ImmeubleController {
    private final ImmeubleRepository repository;

    public ImmeubleController(ImmeubleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Immeuble> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Immeuble findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Immeuble create(@RequestBody Immeuble obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Immeuble update(@PathVariable Long id, @RequestBody Immeuble obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}