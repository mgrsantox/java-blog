package com.java_blog.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java_blog.blog.binding.Post;
import com.java_blog.blog.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        String status = postService.upsert(post);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@RequestParam Integer id) {
        Post post = postService.getById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> updatePost(@RequestBody Post post) {
        String status = postService.upsert(post);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@RequestParam Integer id) {
        String status = postService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}