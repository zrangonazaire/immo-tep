package com.gestimo.client_fidel;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/client_fidel")
public class ClientFidelController {
    private final ClientFidelRepository repository;

    public ClientFidelController(ClientFidelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ClientFidel> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public ClientFidel findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ClientFidel create(@RequestBody ClientFidel obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public ClientFidel update(@PathVariable Long id, @RequestBody ClientFidel obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}