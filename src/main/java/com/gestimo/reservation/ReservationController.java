package com.gestimo.reservation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationRepository repository;

    public ReservationController(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Reservation findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Reservation update(@PathVariable Long id, @RequestBody Reservation obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}