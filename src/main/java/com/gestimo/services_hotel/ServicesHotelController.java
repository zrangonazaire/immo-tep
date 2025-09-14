package com.gestimo.services_hotel;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/services_hotel")
public class ServicesHotelController {
    private final ServicesHotelRepository repository;

    public ServicesHotelController(ServicesHotelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ServicesHotel> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ServicesHotel findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ServicesHotel create(@RequestBody ServicesHotel obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ServicesHotel update(@PathVariable Long id, @RequestBody ServicesHotel obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}