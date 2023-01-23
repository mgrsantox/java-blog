package com.java_blog.blog.service;

import java.util.List;

import com.java_blog.blog.binding.Post;

public interface PostService {

    public String upsert(Post post);

    public Post getById(Integer id);

    public List<Post> getAllPosts();

    public String deleteById(Integer id);

}