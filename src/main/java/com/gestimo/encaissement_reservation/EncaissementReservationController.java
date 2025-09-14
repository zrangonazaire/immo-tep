package com.gestimo.encaissement_reservation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/encaissement_reservation")
public class EncaissementReservationController {
    private final EncaissementReservationRepository repository;

    public EncaissementReservationController(EncaissementReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EncaissementReservation> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public EncaissementReservation findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public EncaissementReservation create(@RequestBody EncaissementReservation obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public EncaissementReservation update(@PathVariable Long id, @RequestBody EncaissementReservation obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}