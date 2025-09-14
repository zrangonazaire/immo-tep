package com.gestimo.role;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleRepository repository;

    public RoleController(RoleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Role> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Role findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Role create(@RequestBody Role obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Role update(@PathVariable Long id, @RequestBody Role obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}