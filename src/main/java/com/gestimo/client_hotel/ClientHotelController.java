package com.gestimo.client_hotel;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/client_hotel")
public class ClientHotelController {
    private final ClientHotelRepository repository;

    public ClientHotelController(ClientHotelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ClientHotel> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ClientHotel findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ClientHotel create(@RequestBody ClientHotel obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ClientHotel update(@PathVariable Long id, @RequestBody ClientHotel obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}