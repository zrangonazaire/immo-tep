package com.gestimo.droit_acces;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/droit_acces")
public class DroitAccesController {
    private final DroitAccesRepository repository;

    public DroitAccesController(DroitAccesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DroitAcces> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public DroitAcces findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public DroitAcces create(@RequestBody DroitAcces obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public DroitAcces update(@PathVariable Long id, @RequestBody DroitAcces obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}