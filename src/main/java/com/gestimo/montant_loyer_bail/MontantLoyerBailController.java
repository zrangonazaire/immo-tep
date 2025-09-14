package com.gestimo.montant_loyer_bail;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/montant_loyer_bail")
public class MontantLoyerBailController {
    private final MontantLoyerBailRepository repository;

    public MontantLoyerBailController(MontantLoyerBailRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MontantLoyerBail> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public MontantLoyerBail findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public MontantLoyerBail create(@RequestBody MontantLoyerBail obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public MontantLoyerBail update(@PathVariable Long id, @RequestBody MontantLoyerBail obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}