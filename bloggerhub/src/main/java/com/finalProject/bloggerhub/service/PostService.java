package com.finalProject.bloggerhub.service;

import com.finalProject.bloggerhub.entity.Post;

import java.util.List;

/**
 * A service interface for managing blog posts.
 */

public interface PostService {

    /**
     * Saves a new post.
     *
     * @param post The post to be saved.
     * @return The saved post.
     */

    Post savePost(Post post);

    /**
     * Retrieves all posts.
     *
     * @return A list of all posts.
     */
    
    List<Post> getAllposts();

     /**
     * Retrieves a post by its ID.
     *
     * @param postId The ID of the post to retrieve.
     * @return The post with the specified ID, or null if not found.
     */
    Post getPostById(Long postId);

    /**
     * Increases the like count for a post.
     *
     * @param postId The ID of the post to like.
     */
    void likePost(Long postId);

    /**
     * Searches for posts by name.
     *
     * @param name The name to search for in post titles.
     * @return A list of posts whose titles contain the specified name.
     */
    List<Post> searchByName(String name);

}
