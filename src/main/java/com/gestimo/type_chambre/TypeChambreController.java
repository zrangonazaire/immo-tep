package com.gestimo.type_chambre;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/type_chambre")
public class TypeChambreController {
    private final TypeChambreRepository repository;

    public TypeChambreController(TypeChambreRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TypeChambre> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public TypeChambre findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public TypeChambre create(@RequestBody TypeChambre obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public TypeChambre update(@PathVariable Long id, @RequestBody TypeChambre obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}