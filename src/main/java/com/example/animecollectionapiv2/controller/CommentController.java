package com.example.animecollectionapiv2.controller;

import com.example.animecollectionapiv2.entity.Comment;
import com.example.animecollectionapiv2.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = {"http://localhost:3000", "https://anime-collection-fullstack.vercel.app"})
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String create(@RequestBody Comment newComment) {
        boolean isSucceed = commentService.create(newComment);
        return isSucceed ? "The creation is done successfully!" : "The creation is failed";
    }

    @GetMapping("/{id}")
    public List<Map<String, Object>> get(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Comment newComment) {
        boolean isSucceed = commentService.update(id, newComment);
        return isSucceed ? "The update is done successfully!" : "The update is failed";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean isSucceed = commentService.delete(id);
        return isSucceed ? "The deletion is done successfully!" : "The deletion is failed";
    }
}
