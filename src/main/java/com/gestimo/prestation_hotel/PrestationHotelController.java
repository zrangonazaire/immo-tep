package com.gestimo.prestation_hotel;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prestation_hotel")
public class PrestationHotelController {
    private final PrestationHotelRepository repository;

    public PrestationHotelController(PrestationHotelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PrestationHotel> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public PrestationHotel findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public PrestationHotel create(@RequestBody PrestationHotel obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public PrestationHotel update(@PathVariable Long id, @RequestBody PrestationHotel obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}