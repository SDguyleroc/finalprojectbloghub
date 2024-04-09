package com.finalProject.bloggerhub.controller;

import com.finalProject.bloggerhub.entity.Post;
import com.finalProject.bloggerhub.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createdPost(@RequestBody Post post){
        try{
            Post createdpost = postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdpost);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
