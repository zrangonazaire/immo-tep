package com.gestimo.cron_mail;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cron_mail")
public class CronMailController {
    private final CronMailRepository repository;

    public CronMailController(CronMailRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CronMail> findAll() {
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    public CronMail findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public CronMail create(@RequestBody CronMail obj) {
        return repository.save(obj);
    }

    @PutMapping("/<built-in function id>")
    public CronMail update(@PathVariable Long id, @RequestBody CronMail obj) {
        try { java.lang.reflect.Field f = obj.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(obj, id); } catch (Exception e) {}
        return repository.save(obj);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}