package com.gestimo.quartier;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quartier")
public class QuartierController {
    private final QuartierRepository repository;

    public QuartierController(QuartierRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Quartier> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Quartier findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Quartier create(@RequestBody Quartier obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Quartier update(@PathVariable Long id, @RequestBody Quartier obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}