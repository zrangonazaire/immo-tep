package com.gestimo.contrat_reservation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contrat_reservation")
public class ContratReservationController {
    private final ContratReservationRepository repository;

    public ContratReservationController(ContratReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ContratReservation> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ContratReservation findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ContratReservation create(@RequestBody ContratReservation obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ContratReservation update(@PathVariable Long id, @RequestBody ContratReservation obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}