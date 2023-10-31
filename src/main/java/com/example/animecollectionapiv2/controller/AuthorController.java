package com.example.animecollectionapiv2.controller;

import com.example.animecollectionapiv2.entity.Author;
import com.example.animecollectionapiv2.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public String create(@RequestBody Author newAuthor) {
        boolean isSucceed = authorService.create(newAuthor);
        return isSucceed ? "The creation is done successfully!" : "The creation is failed";
    }

    @GetMapping("/{id}")
    public Author get(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Author newAuthor) {
        boolean isSucceed = authorService.update(id, newAuthor);
        return isSucceed ? "The update is done successfully!" : "The update is failed";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean isSucceed = authorService.delete(id);
        return isSucceed ? "The deletion is done successfully!" : "The deletion is failed";
    }
}
