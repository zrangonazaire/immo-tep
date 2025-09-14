package com.gestimo.hibernate_sequence;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hibernate_sequence")
public class HibernateSequenceController {
    private final HibernateSequenceRepository repository;

    public HibernateSequenceController(HibernateSequenceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<HibernateSequence> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public HibernateSequence findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public HibernateSequence create(@RequestBody HibernateSequence obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public HibernateSequence update(@PathVariable Long id, @RequestBody HibernateSequence obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}