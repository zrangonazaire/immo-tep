package com.gestimo.quittance;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quittance")
public class QuittanceController {
    private final QuittanceRepository repository;

    public QuittanceController(QuittanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Quittance> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Quittance findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Quittance create(@RequestBody Quittance obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Quittance update(@PathVariable Long id, @RequestBody Quittance obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}