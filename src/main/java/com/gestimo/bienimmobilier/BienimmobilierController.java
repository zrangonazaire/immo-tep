package com.gestimo.bienimmobilier;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bienimmobilier")
public class BienimmobilierController {
    private final BienimmobilierRepository repository;

    public BienimmobilierController(BienimmobilierRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Bienimmobilier> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Bienimmobilier findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Bienimmobilier create(@RequestBody Bienimmobilier obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Bienimmobilier update(@PathVariable Long id, @RequestBody Bienimmobilier obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}