package com.java_blog.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_blog.blog.binding.Post;
import com.java_blog.blog.repo.PostRepository;

@Service
public class PostserviceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Override
    public String upsert(Post post) {
        postRepo.save(post);
        return "success";
    }

    @Override
    public Post getById(Integer id) {
        Optional<Post> findById = postRepo.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public String deleteById(Integer id) {
        if (postRepo.existsById(id)) {
            postRepo.deleteById(id);
            return "Delete Success";
        } else {
            return "No Record Found";
        }
    }

}