package com.gestimo.suivie_depense;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suivie_depense")
public class SuivieDepenseController {
    private final SuivieDepenseRepository repository;

    public SuivieDepenseController(SuivieDepenseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SuivieDepense> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public SuivieDepense findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public SuivieDepense create(@RequestBody SuivieDepense obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public SuivieDepense update(@PathVariable Long id, @RequestBody SuivieDepense obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}