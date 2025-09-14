package com.gestimo.table_encodage_portique;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/table_encodage_portique")
public class TableEncodagePortiqueController {
    private final TableEncodagePortiqueRepository repository;

    public TableEncodagePortiqueController(TableEncodagePortiqueRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TableEncodagePortique> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public TableEncodagePortique findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public TableEncodagePortique create(@RequestBody TableEncodagePortique obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public TableEncodagePortique update(@PathVariable Long id, @RequestBody TableEncodagePortique obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}