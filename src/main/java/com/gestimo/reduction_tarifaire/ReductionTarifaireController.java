package com.gestimo.reduction_tarifaire;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reduction_tarifaire")
public class ReductionTarifaireController {
    private final ReductionTarifaireRepository repository;

    public ReductionTarifaireController(ReductionTarifaireRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ReductionTarifaire> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ReductionTarifaire findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ReductionTarifaire create(@RequestBody ReductionTarifaire obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ReductionTarifaire update(@PathVariable Long id, @RequestBody ReductionTarifaire obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}