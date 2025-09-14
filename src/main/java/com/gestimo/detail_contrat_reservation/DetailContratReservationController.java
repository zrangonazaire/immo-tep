package com.gestimo.detail_contrat_reservation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detail_contrat_reservation")
public class DetailContratReservationController {
    private final DetailContratReservationRepository repository;

    public DetailContratReservationController(DetailContratReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DetailContratReservation> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public DetailContratReservation findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public DetailContratReservation create(@RequestBody DetailContratReservation obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public DetailContratReservation update(@PathVariable Long id, @RequestBody DetailContratReservation obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}