package com.gestimo.site;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/site")
public class SiteController {
    private final SiteRepository repository;

    public SiteController(SiteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Site> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Site findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Site create(@RequestBody Site obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Site update(@PathVariable Long id, @RequestBody Site obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}