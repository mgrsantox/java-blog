package com.java_blog.blog.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_blog.blog.binding.Post;

public interface PostRepository extends JpaRepository<Post, Serializable> {

}