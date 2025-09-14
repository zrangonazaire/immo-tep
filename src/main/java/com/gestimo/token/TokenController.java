package com.gestimo.token;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/token")
public class TokenController {
    private final TokenRepository repository;

    public TokenController(TokenRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Token> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public Token findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Token create(@RequestBody Token obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public Token update(@PathVariable Long id, @RequestBody Token obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}