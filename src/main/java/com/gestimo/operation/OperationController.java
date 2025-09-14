package com.gestimo.operation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/operation")
public class OperationController {
    private final OperationRepository repository;

    public OperationController(OperationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Operation> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Operation findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Operation create(@RequestBody Operation obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Operation update(@PathVariable Long id, @RequestBody Operation obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}