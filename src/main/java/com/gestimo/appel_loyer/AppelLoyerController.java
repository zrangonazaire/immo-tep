package com.gestimo.appel_loyer;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appel_loyer")
public class AppelLoyerController {
    private final AppelLoyerRepository repository;

    public AppelLoyerController(AppelLoyerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AppelLoyer> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public AppelLoyer findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public AppelLoyer create(@RequestBody AppelLoyer obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public AppelLoyer update(@PathVariable Long id, @RequestBody AppelLoyer obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}