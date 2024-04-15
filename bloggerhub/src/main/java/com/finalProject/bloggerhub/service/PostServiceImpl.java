package com.finalProject.bloggerhub.service;

import com.finalProject.bloggerhub.entity.Post;
import com.finalProject.bloggerhub.repository.PostRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link PostService} interface that provides methods to manage blog posts.
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


     /**
     * Saves a new post.
     *
     * @param post The post to be saved.
     * @return The saved post.
     */

    public Post savePost(Post post){
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());

        return postRepository.save(post);
    }

     /**
     * Retrieves all posts.
     *
     * @return A list of all posts.
     */

    public List<Post> getAllposts(){
        return postRepository.findAll();
    }


     /**
     * Retrieves a post by its ID.
     *
     * @param postId The ID of the post to retrieve.
     * @return The post with the specified ID.
     * @throws EntityNotFoundException If no post is found with the given ID.
     */
    
    public Post getPostById(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setViewCount(post.getViewCount() +1);
            return postRepository.save(post);
        }else {
            throw new EntityNotFoundException("Post not found:");
        }
    }


    /**
     * Increases the like count for a post.
     *
     * @param postId The ID of the post to like.
     * @throws EntityNotFoundException If no post is found with the given ID.
     */

    public void likePost(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();

            post.setLikeCount(post.getLikeCount() +1);
            postRepository.save(post);
        }
        else {
            throw new EntityNotFoundException("Post not found with Id: " + postId);
        }
    }


    /**
     * Searches for posts by name.
     *
     * @param name The name to search for in post titles.
     * @return A list of posts whose titles contain the specified name.
     */
    public List<Post> searchByName(String name){
        return postRepository.findAllByNameContaining(name);
    }
}
