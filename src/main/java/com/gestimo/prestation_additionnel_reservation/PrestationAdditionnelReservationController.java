package com.gestimo.prestation_additionnel_reservation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prestation_additionnel_reservation")
public class PrestationAdditionnelReservationController {
    private final PrestationAdditionnelReservationRepository repository;

    public PrestationAdditionnelReservationController(PrestationAdditionnelReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PrestationAdditionnelReservation> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public PrestationAdditionnelReservation findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public PrestationAdditionnelReservation create(@RequestBody PrestationAdditionnelReservation obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public PrestationAdditionnelReservation update(@PathVariable Long id, @RequestBody PrestationAdditionnelReservation obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}