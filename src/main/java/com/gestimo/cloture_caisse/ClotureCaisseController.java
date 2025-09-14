package com.gestimo.cloture_caisse;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cloture_caisse")
public class ClotureCaisseController {
    private final ClotureCaisseRepository repository;

    public ClotureCaisseController(ClotureCaisseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ClotureCaisse> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ClotureCaisse findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ClotureCaisse create(@RequestBody ClotureCaisse obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ClotureCaisse update(@PathVariable Long id, @RequestBody ClotureCaisse obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}