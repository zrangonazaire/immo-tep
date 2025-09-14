package com.gestimo.charge_additionnelle;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/charge_additionnelle")
public class ChargeAdditionnelleController {
    private final ChargeAdditionnelleRepository repository;

    public ChargeAdditionnelleController(ChargeAdditionnelleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ChargeAdditionnelle> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ChargeAdditionnelle findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ChargeAdditionnelle create(@RequestBody ChargeAdditionnelle obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ChargeAdditionnelle update(@PathVariable Long id, @RequestBody ChargeAdditionnelle obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}