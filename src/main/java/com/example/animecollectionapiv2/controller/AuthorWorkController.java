package com.example.animecollectionapiv2.controller;

import com.example.animecollectionapiv2.entity.AuthorWork;
import com.example.animecollectionapiv2.service.AuthorService;
import com.example.animecollectionapiv2.service.AuthorWorkService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author-works")
public class AuthorWorkController {
    private final AuthorWorkService authorWorkService;
    public AuthorWorkController(AuthorWorkService authorWorkService){ this.authorWorkService = authorWorkService; }

    @PostMapping
    public String create(@RequestBody AuthorWork newAuthorWork) {
        boolean isSucceed = authorWorkService.create(newAuthorWork);
        return isSucceed ? "The creation is done successfully!" : "The creation is failed";
    }

    @GetMapping
    public AuthorWork get(@RequestParam Long author_id) {
        return authorWorkService.selectById(author_id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody AuthorWork newAuthorWork) {
        boolean isSucceed = authorWorkService.update(id, newAuthorWork);
        return isSucceed ? "The update is done successfully!" : "The update is failed";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean isSucceed = authorWorkService.delete(id);
        return isSucceed ? "The deletion is done successfully!" : "The deletion is failed";
    }
}
