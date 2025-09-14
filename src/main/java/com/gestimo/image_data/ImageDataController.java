package com.gestimo.image_data;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/image_data")
public class ImageDataController {
    private final ImageDataRepository repository;

    public ImageDataController(ImageDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ImageData> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ImageData findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ImageData create(@RequestBody ImageData obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ImageData update(@PathVariable Long id, @RequestBody ImageData obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}