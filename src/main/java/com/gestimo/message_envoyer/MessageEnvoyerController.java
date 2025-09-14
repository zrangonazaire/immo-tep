package com.gestimo.message_envoyer;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/message_envoyer")
public class MessageEnvoyerController {
    private final MessageEnvoyerRepository repository;

    public MessageEnvoyerController(MessageEnvoyerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MessageEnvoyer> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public MessageEnvoyer findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public MessageEnvoyer create(@RequestBody MessageEnvoyer obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public MessageEnvoyer update(@PathVariable Long id, @RequestBody MessageEnvoyer obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}