package com.gestimo.file_data;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/file_data")
public class FileDataController {
    private final FileDataRepository repository;

    public FileDataController(FileDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FileData> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public FileData findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public FileData create(@RequestBody FileData obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public FileData update(@PathVariable Long id, @RequestBody FileData obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}