package com.gestimo.groupe_droit;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/groupe_droit")
public class GroupeDroitController {
    private final GroupeDroitRepository repository;

    public GroupeDroitController(GroupeDroitRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<GroupeDroit> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public GroupeDroit findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public GroupeDroit create(@RequestBody GroupeDroit obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public GroupeDroit update(@PathVariable Long id, @RequestBody GroupeDroit obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}