package com.gestimo.image_table;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/image_table")
public class ImageTableController {
    private final ImageTableRepository repository;

    public ImageTableController(ImageTableRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ImageTable> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ImageTable findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ImageTable create(@RequestBody ImageTable obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ImageTable update(@PathVariable Long id, @RequestBody ImageTable obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}