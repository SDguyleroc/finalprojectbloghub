package com.finalProject.bloggerhub.controller;

import com.finalProject.bloggerhub.entity.Post;
import com.finalProject.bloggerhub.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Guy-leroc Ossebi
 * Controller class for managing blog posts.
 */

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * Creates a new post.
     *
     * @param post The post to be created.
     * @return ResponseEntity containing the created post, or an error response if creation fails.
     */

    @PostMapping
    public ResponseEntity<?> createdPost(@RequestBody Post post){
        try{
            Post createdpost = postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdpost);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Retrieves all posts.
     *
     * @return ResponseEntity containing a list of all posts, or an error response if retrieval fails.
     */

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost(){
       try {
           return ResponseEntity.status(HttpStatus.OK).body(postService.getAllposts());
       }
       catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }


    /**
     * Retrieves a post by its ID.
     *
     * @param postId The ID of the post to retrieve.
     * @return ResponseEntity containing the retrieved post, or an error response if the post is not found.
     */
    
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

    /**
     * Increases the like count for a post.
     *
     * @param postId The ID of the post to like.
     * @return ResponseEntity indicating success or failure of the like operation.
     */

    @PutMapping("/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable Long postId ){
        try{
            postService.likePost(postId);
            return ResponseEntity.ok(new String[]{"Liked Post"});
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

      /**
     * Searches for posts by name.
     *
     * @param name The name to search for in post titles.
     * @return ResponseEntity containing a list of posts whose titles contain the specified name,
     *         or an error response if the search fails.
     */
    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postService.searchByName(name));
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
