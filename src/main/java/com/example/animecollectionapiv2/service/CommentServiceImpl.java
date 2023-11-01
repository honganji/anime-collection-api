package com.example.animecollectionapiv2.service;

import com.example.animecollectionapiv2.entity.Comment;
import com.example.animecollectionapiv2.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{
    private CommentRepository commentRepository;
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public boolean create(Comment newComment) {
        return commentRepository.create(newComment);
    }

    @Override
    public List<Map<String, Object>> findById(Long id) {
        return commentRepository.selectById(id);
    }

    @Override
    public boolean update(Long id, Comment newComment) {
        return commentRepository.update(id, newComment);
    }

    @Override
    public boolean delete(Long id) {
        return commentRepository.delete(id);
    }
}
