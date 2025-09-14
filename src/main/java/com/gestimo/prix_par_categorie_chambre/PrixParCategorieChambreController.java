package com.gestimo.prix_par_categorie_chambre;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prix_par_categorie_chambre")
public class PrixParCategorieChambreController {
    private final PrixParCategorieChambreRepository repository;

    public PrixParCategorieChambreController(PrixParCategorieChambreRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PrixParCategorieChambre> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public PrixParCategorieChambre findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public PrixParCategorieChambre create(@RequestBody PrixParCategorieChambre obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public PrixParCategorieChambre update(@PathVariable Long id, @RequestBody PrixParCategorieChambre obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}