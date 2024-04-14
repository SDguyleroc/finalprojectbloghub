package com.finalProject.bloggerhub.repository;

import com.finalProject.bloggerhub.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByNameContaining(String name);
}
