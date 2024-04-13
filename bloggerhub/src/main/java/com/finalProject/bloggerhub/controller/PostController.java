package com.finalProject.bloggerhub.controller;

import com.finalProject.bloggerhub.entity.Post;
import com.finalProject.bloggerhub.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*")
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

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost(){
       try {
           return ResponseEntity.status(HttpStatus.OK).body(postService.getAllposts());
       }
       catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId){
        try{
            Post post = postService.getPostById(postId);
            return  ResponseEntity.ok(post);
        }
        catch (EntityNotFoundException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable Long postId ){
        try{
            postService.likePost(postId);
            return ResponseEntity.ok(new String[]{"Liked Post"});
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
