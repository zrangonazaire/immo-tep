package com.gestimo.charges;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/charges")
public class ChargesController {
    private final ChargesRepository repository;

    public ChargesController(ChargesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Charges> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Charges findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Charges create(@RequestBody Charges obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Charges update(@PathVariable Long id, @RequestBody Charges obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}